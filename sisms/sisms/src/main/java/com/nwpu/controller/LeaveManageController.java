package com.nwpu.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nwpu.model.Student;
import com.nwpu.model.StudentRecord;
import com.nwpu.service.LoginService;
import com.nwpu.service.LeaveService;
import com.nwpu.service.StudentService;
import com.nwpu.util.SendEmail;

@Controller
@RequestMapping("/leaveManage")
public class LeaveManageController {
	
	static String infoForQuery = "";
	static String flagForQuery = "";

	@Autowired
	private LeaveService leaveService;
	private StudentService studentservice;
	private LoginService loginservice;
	
	@RequestMapping("/fycate")
	public String fycate() {
		
		return "/leaveManage/lx-fycate";
	}
	
	@RequestMapping("/jscate")
	public String jscate(Model model) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
		String year = sdf.format(date);
		String month = sdf2.format(date);

		if(Integer.valueOf(month) >= 9) {
			year = year + 1;
		}
		String leaveDate = year + "-8-9";
		List<Student> stuList = new ArrayList<Student>();
		stuList = leaveService.queryBorrow(leaveDate);
		model.addAttribute("stuList", stuList);
		int size = stuList.size();
		model.addAttribute("size", size);
		
		return "/leaveManage/lx-jscate";
	}
	
	@RequestMapping("/xscate")
	public String xscate(Model model) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
		String year = sdf.format(date);
		String month = sdf2.format(date);

		if(Integer.valueOf(month) >= 9) {
			year = year + 1;
		}
		String leaveDate = year + "-8-9";
		//System.out.println(year);
		//System.out.println(month);
		List<Student> stuList = new ArrayList<Student>();
		stuList = leaveService.queryStudent(leaveDate);
		model.addAttribute("stuList", stuList);
		int size = stuList.size();
		model.addAttribute("size", size);
		
		return "/leaveManage/lx-xscate";
	}
	
	@RequestMapping("/xslook")
	public String xslook(HttpServletRequest request, Model model) {
		
		String studentID = request.getSession().getAttribute("userName").toString();
		
		Student student = leaveService.queryStudentByID(studentID);
		model.addAttribute("student", student);
	
		Student borrow = leaveService.queryBorrowByID(studentID);
		model.addAttribute("borrow", borrow);
		
		List<StudentRecord> recordList = new ArrayList<StudentRecord>();
		recordList = leaveService.queryRecordByID(studentID);
		model.addAttribute("recordList", recordList);
		
		return "/leaveManage/lx-xslook";
	}
	
	/*
	@RequestMapping("/email")
	public Map<String, String> email(HttpServletRequest request, Model model) throws Exception {

		
		String userName = request.getParameter("userName");
		String VerificationCode = request.getParameter("VerificationCode");
		System.out.println("password test");
		Map<String, String> map = new HashMap<String, String>();
		boolean isAdmin;
		// 获得session对象
		HttpSession session = request.getSession();
		String randomKey = session.getAttribute("randCode").toString();
		// 获取用户的登录密码
		String identifyID = loginservice.login(userName);
		System.out.println("jasdfhasjfFFFF");
		if (identifyID == null) {
			map.put("result", "用户不存在");
			return map;// 不存在该用户
				// 判断验证码
		}else {
				if (equal(randomKey, VerificationCode)) {
					session.setAttribute("userName", userName);
					String studentID = session.getAttribute("userName").toString();
					
					String QQemail = studentservice.queryEmailByID(studentID);
					
					System.out.println("11111111111111111111111111111111111111111111111111");
					SendEmail.email(QQemail);
					return map;
				} else {
					map.put("result", "验证码错误");
					return map;// 验证码错误
				}
			} 
	}
	*/
	
	@RequestMapping("email")
	public void email() throws Exception{
		SendEmail.email("2504267058@qq.com");
	}
	
	public boolean equal(String input, String output) {

		if (input.toLowerCase().equals(output.toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}
	
	//学生信息查询功能
		@RequestMapping("/Query")
		public String Query( Model model){
			String queryData = infoForQuery;
			String flag = flagForQuery;
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
			String year = sdf.format(date);
			String month = sdf2.format(date);

			if(Integer.valueOf(month) >= 9) {
				year = year + 1;
			}
			String leaveDate = year + "-8-9";

			List<Student> studentList = new ArrayList<Student>();	
			
			if(flag.equals("1")){
				if(queryData.equals("")){
					studentList = leaveService.queryStudent(leaveDate);
				}else{
					//按学生姓名模糊查询
					List<Student> firstList = leaveService.queryStudentBystuName(infoForQuery,leaveDate);
					if(!(firstList.isEmpty())){
						studentList = firstList;
					}
					
					//按学号精确查询
					Student student = leaveService.queryStudentByID(infoForQuery);
					if(!(student == null)){
						studentList.add(student);
					}
					
					//均未查询到结果
					if(studentList.isEmpty()){
						studentList = leaveService.queryStudent(leaveDate);
					}
				}
			}else{
				if(queryData.equals("")){
					studentList = leaveService.queryBorrow(leaveDate);
				}else{
					//按学生姓名模糊查询
					List<Student> firstList = leaveService.queryBorrowStudentBystuName(infoForQuery,leaveDate);
					if(!(firstList.isEmpty())){
						studentList = firstList;
					}
					
					//按学号精确查询
					Student student = leaveService.queryBorrowByID(infoForQuery);
					if(!(student == null)){
						studentList.add(student);
					}
					
					//均未查询到结果
					if(studentList.isEmpty()){
						studentList = leaveService.queryBorrow(leaveDate);
					}
				}
			}
			

			int length = studentList.size();
			model.addAttribute("stuList", studentList);
			model.addAttribute("size", length);
			
			if(flag.equals("1")){
				return "leaveManage/lx-xscate";
			}
			else {
				return "leaveManage/lx-jscate";
			}
			
		}
		
		//提供学生信息查询功能所需数据
		@RequestMapping("/QueryHelp")
		public void QueryHelp(ServletRequest request){
			infoForQuery = request.getParameter("info");
			flagForQuery = request.getParameter("flag");		
		}

}
