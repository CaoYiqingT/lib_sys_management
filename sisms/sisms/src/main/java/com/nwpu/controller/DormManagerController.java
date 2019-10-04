package com.nwpu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nwpu.model.Book;
import com.nwpu.model.Dorm;
import com.nwpu.model.DormApplication;
import com.nwpu.model.Student;
import com.nwpu.service.DormService;
import com.nwpu.serviceImpl.DormServiceImpl;

/*
 * 宿舍管理控制器
 */
@Controller
@RequestMapping("/dormManage")
public class DormManagerController {
	
	static String dormNumberForEdit="";
	static String studentNumberForEdit="";
	
	@Autowired
	private DormService dormService;
	
	@RequestMapping("/addDorm")
	public void addDorm(Dorm dorm) {
		
		dorm.setFull(false);
		System.out.println(dorm.toString());
		dormService.insertDorm(dorm);
	}
	
	@RequestMapping("/addRoom")
	public String addRoom(Model model) {
		
		List<Dorm> dormList = new ArrayList<Dorm>();
		dormList = dormService.selectDorm();
		int length = dormList.size();
		model.addAttribute("dList", dormList);
		model.addAttribute("size", length);
		
		return "/dormManage/addRoom";
	}
	
	@RequestMapping("/checkIn")
	public String checkIn(Model model) {
		
		List<Student> stuList = new ArrayList<Student>();
		stuList = dormService.queryStudent();
		int length = stuList.size();
		model.addAttribute("length", length);
		model.addAttribute("stuList", stuList);
		return "/dormManage/checkIn";
	}
	
	@RequestMapping("/dorm-student")
	public String queryApply(Model model, HttpServletRequest request) {
		
		String studentID = request.getSession().getAttribute("userName").toString();
		Student student = dormService.getStudentById(studentID);
		String studentName = student.getStudentName();
		model.addAttribute("name", studentName);
		
		String dormNumber = student.getDormNumber();
		model.addAttribute("dormNumber", dormNumber);
		
		List<Student> stuList = dormService.queryStudentByDrom(student.getDormNumber());
		model.addAttribute("stuList", stuList);
		
		List<DormApplication> applyList = new ArrayList<DormApplication>();
		applyList = dormService.queryApply(studentID);
		int length = applyList.size();
		model.addAttribute("length", length);
		model.addAttribute("applyList", applyList);
		
		return "/dormManage/dorm-student";
	}
	
	@RequestMapping("/insertApply")
	public void insertApply(HttpServletRequest request, DormApplication dormApply) {
		
		String userName = request.getSession().getAttribute("userName").toString();
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
		dormApply.setApplyNumber(ft.format(now));
		dormApply.setStudentID(userName);
		dormApply.setStatus(false);
		String date = dateFormat.format( now ); 
		dormApply.setDate(date);
		
		dormService.insertApply(dormApply);
	}
	
	@RequestMapping("/deleteDorm")
	public void deleteDorm(@RequestParam("param1") String[] param1) {
		
		for(int i = 0; i < param1.length; i++) {
			//System.out.println(param1[i]);
			dormService.deleteDorm(param1[i]);
		}
		//System.out.println(param1);
		//String[] selected = request.getParameterValues("ids");
		
	}
	
	/*@RequestMapping("/findStudentById")
	public String findStudentById(ServletRequest request, Model model) {
		
		String queryData = request.getParameter("queryData");
		System.out.println(queryData);
		List<Student> stuList = new ArrayList<Student>();
		stuList = dormService.queryStudentById(queryData);
		model.addAttribute("stuList", stuList);
		//model.addAttribute("lengh", 1);
		return "error";
	}*/
	
	@RequestMapping("/showQueryStudent")
	public String showQueryStudent(ServletRequest request, Model model) {
		
		String queryData = request.getParameter("queryData");
		if(queryData == "") {
			List<Student> stuList = new ArrayList<Student>();
			stuList = dormService.queryStudent();
			model.addAttribute("stuList", stuList);
			int length = stuList.size();
			model.addAttribute("length", length);
		}else {
			System.out.println(queryData);
			List<Student> stuList = new ArrayList<Student>();
			stuList = dormService.queryStudentById(queryData);
			model.addAttribute("stuList", stuList);
			int length = stuList.size();
			model.addAttribute("length", length);
		}
		return "/dormManage/checkIn";
	}
	
    //宿舍编辑页面
	@RequestMapping("/dormEdit")
	public String dormEdit(Model model){

		Dorm dorm = dormService.queryDormByDormNumber(dormNumberForEdit);
		model.addAttribute("dorm", dorm);
		return "dormManage/dormEdit";
	}
	
	//宿舍编辑页面所需数据
	@RequestMapping("/dormEditHelp")
	public void dormEditHelp(ServletRequest servletRequest){
		dormNumberForEdit = servletRequest.getParameter("dormNumber");
	}
	
	//宿舍信息更新
	@RequestMapping("/dormUpdate")
	public void dormUpdate(Dorm dorm){
		dormService.updateDorm(dorm);
	}
	
	//入住管理编辑页面
	@RequestMapping("/checkEdit")
	public String checkEdit(Model model){
		Student student = dormService.getStudentById(studentNumberForEdit);
		model.addAttribute("student", student);
		return "dormManage/checkEdit";
	}
	
	//入住管理编辑页面所需数据
	@RequestMapping("/checkEditHelp")
	public void checkEditHelp(ServletRequest servletRequest){
		studentNumberForEdit = servletRequest.getParameter("studentID");
	}
	
	//宿舍信息更新
	@RequestMapping("/checkUpdate")
	public void checkUpdate(Student student){
		dormService.updateStudent(student);
	}
	
	@RequestMapping("/handelDormApply")
	public String handleDormApply(Model model) {
		
		List<DormApplication> applyList = new ArrayList<DormApplication>();
		applyList = dormService.queryAllApply();
		int length = applyList.size();
		model.addAttribute("applyList", applyList);
		model.addAttribute("length", length);
		
		return "/dormManage/handelDormApply";
	}
	
	@RequestMapping("/updateStatus")
	public void updateStatus(@RequestParam("applyNumber") String applyNumber) {
		
		dormService.updateApply(applyNumber);
	}
}
