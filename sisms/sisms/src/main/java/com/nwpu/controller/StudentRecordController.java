package com.nwpu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.nwpu.model.StudentRecord;
import com.nwpu.service.StudentRecordService;

@Controller
@RequestMapping("/static")
public class StudentRecordController {

	@Autowired
	private StudentRecordService studentRecordService;

	/*
	 * 列出学生交易记录(admin)
	 */
	@RequestMapping("/paymentManage_admin/list")
	public String getSelectStudent(Model model) {
		//System.out.println("controller运行");

		List<StudentRecord> stuList = studentRecordService.getStudentRecordListAll();

		model.addAttribute("stuList", stuList);

		//System.out.println(stuList.get(1).getIsPay());
		// return "redirect:http://localhost:8080/simss/index.jsp";
		return "/paymentManage_admin/tradingRecord";
	}
	
	/*
	 * 列出学生交易记录(student)
	 */
	@RequestMapping("/paymentManage_student/list")
	public String getSelectStudent_S(Model model, HttpServletRequest request) {
		//System.out.println("controller运行");

		String studentID = request.getSession().getAttribute("userName").toString();
		List<StudentRecord> stuList = studentRecordService.getStudentRecordList(studentID);

		model.addAttribute("stuList", stuList);

		//System.out.println("test");
		// return "redirect:http://localhost:8080/simss/index.jsp";
		return "/paymentManage_student/tradingRecord";
	}
	
	/*
	 * 列出学生缴费通知（student）
	 */
	@RequestMapping("/paymentManage_student/Info")
	public String getStudentRecordInfo(Model model, HttpServletRequest request) {
		//System.out.println("controller运行");

		String studentID = request.getSession().getAttribute("userName").toString();
		List<StudentRecord> stuList = studentRecordService.getStudentRecordList(studentID);

		model.addAttribute("stuList", stuList);

		//System.out.println("test");
		// return "redirect:http://localhost:8080/simss/index.jsp";
		return "/paymentManage_student/paymentInfo";
	}
	
	/*
	 * 根据学生学号查询交易记录
	 */
	@GetMapping("/paymentManage_admin/tradingRecord")
	public String queryStudentRecordByStudentId(String check, Model model){
		//System.out.println("查询");
		//System.out.println(check);
		if(check == ""){
			List<StudentRecord> stuList = studentRecordService.getStudentRecordListAll();
			model.addAttribute("stuList", stuList);
			return "/paymentManage_admin/tradingRecord";
		}
		else{
			List<StudentRecord> stuList = studentRecordService.getStudentRecordByStudentId(check);
			model.addAttribute("stuList", stuList);
			return "/paymentManage_admin/tradingRecord";
		}
	}


	/*
	 * 更新学生交易记录（即确认缴费）
	 */
	@GetMapping("/paymentManage_student/update")
	public String deleteStudentRecordByKey(HttpServletRequest request, Model model){
		
		String studentID = request.getSession().getAttribute("userName").toString();
		String key = request.getParameter("payNumber");
		//System.out.println(key);
		studentRecordService.updateStudentRecordByKey(key);
		List<StudentRecord> stuList = studentRecordService.getStudentRecordList(studentID);
		model.addAttribute("stuList", stuList);
		
		return "/paymentManage_student/paymentInfo";
	}
	
	/*
	 * 发布收费信息
	 */
	@PostMapping("/paymentManage_admin/insert")
	public String insertStudentRecord(Model model, StudentRecord record){
		
		String firstID, lastID;
		String[] temp = record.getStudentID().split("-");
		if(temp.length > 1) {
			firstID = temp[0];
			lastID = temp[1];
			int i = 0;
			do {
				record.setStudentID(firstID);
				Date now = new Date(); 
				SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
				record.setPayNumber(ft.format(now) + i);
				record.setStudentName(queryStudentNameByID(record.getStudentID()));
				studentRecordService.insertStudentRecord(record);
				firstID = String.valueOf((Integer.valueOf(firstID) + 1));
				i++;
			}while(!firstID.equals(lastID));
		}else {
			Date now = new Date(); 
			SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
			record.setPayNumber(ft.format(now));
			record.setStudentName(queryStudentNameByID(record.getStudentID()));
			studentRecordService.insertStudentRecord(record);

		}

		List<StudentRecord> stuList = studentRecordService.getStudentRecordListAll();
		model.addAttribute("stuList", stuList);
		
		return "/paymentManage_admin/otherPayment";
	}
	
	/*
	 * 显示已发布缴费通知（admin）
	 */
	@RequestMapping("/paymentManage_admin/other")
	public String sendStudentRecordInfo(Model model) {
		//System.out.println("controller运行");

		List<StudentRecord> stuList = studentRecordService.getStudentRecordListAll();

		model.addAttribute("stuList", stuList);

		//System.out.println("test");
		// return "redirect:http://localhost:8080/simss/index.jsp";
		return "/paymentManage_admin/otherPayment";
	}
	
	
	public String queryStudentNameByID(String studentID) {
		
		return studentRecordService.queryStudentNameByID(studentID);
	}
	
	/*
	 @RequestMapping("/test") 
	 public String test(Model model)
	 { 
		 String s = "test";
		 model.addAttribute("a", s);
		 System.out.println("执行!");
		return "index";
	 }
	 */
	 

	/*
	 * @RequestMapping(value = "myTest1") public void
	 * getInfo1(@RequestParam(required=false) String account,String pwd){
	 * System.out.println("账号是："+account); System.out.println("密码是："+pwd); }
	 */
}
