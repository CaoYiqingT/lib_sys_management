package com.nwpu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nwpu.model.Student;
import com.nwpu.service.AdminService;

/*
 * 管理员控制类
 */
@Controller
@RequestMapping("/adminManage")
public class AdminManageController {

	@Autowired
	private AdminService adminService;
	
	/*
	 * 管理员添加页面跳转
	 */
	@RequestMapping("/adminAdd")
	public String adminAdd() {
		
		return "adminManage/admin-add";
	}
	
	/*
	 * 管理员页面
	 */
	@RequestMapping("/adminRole")
	public String adminRole(Model model) {
		
		List<Student> adminList = new ArrayList<Student>();
		adminList = adminService.queryAdmin();
		model.addAttribute("adminList", adminList);
		int size = adminList.size();
		model.addAttribute("size", size);
		
		return "adminManage/admin-role";
	}
	
	@RequestMapping("/addAdmin")
	public void addAdmin(Student student) {
		
		student.setAdmin(true);
		//System.out.println(student.toString());
		
		adminService.insertAdmin(student);
	}
	
	@RequestMapping("/deleteAdmin")
	public void deleteAdmin(@RequestParam("deleteData") String[] deleteData) {
		
		for(int i = 0; i < deleteData.length; i++) {
			adminService.deleteAdmin(deleteData[i]);
			//System.out.println(deleteData[i]);
		}
	}
	
	@RequestMapping("/editAtt")
	public String editAtt() {
		
		return  "adminManage/editAtt";
	}
	
	@RequestMapping("/sub")
	public void sub(@RequestParam("context") String context) {
		
		//String context = request.getAttribute("context").toString();
		System.out.println(context);
		adminService.subNotice(context);
	}
}
