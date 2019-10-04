package com.nwpu.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nwpu.model.Book;
import com.nwpu.model.Dorm;
import com.nwpu.model.Student;
import com.nwpu.service.StudentService;

@Controller
@RequestMapping("/studentManage")
public class StudentManageController {

	static String stuIDForEdit="";
	static String infoForQuery="";
	static String flagForQuery="";
	@Autowired
	private StudentService stuService;
	
	//新生数据导入与导出页面
	@RequestMapping("/newStuInfo")
	public String newStuInfo(Model model) {
		
		List<Student> stuList = new ArrayList<Student>();
		stuList = stuService.queryStudent();
		model.addAttribute("stuList", stuList);
		int size = stuList.size();
		model.addAttribute("size", size);
		
		return "/studentManage/newStuIfo";
	}
	
	
	//新生管理（原编制学号）页面
	@RequestMapping("/setStuID")
	public String setStudentID(Model model) {
		List<Student> firstList = new ArrayList<Student>();
		List<Student> stuList = new ArrayList<Student>();
		
		firstList = stuService.queryStudent();
		
		for(Student student : firstList){
			if(student.getDormNumber().equals("waitForSet")){
				stuList.add(student);
			}
		}
		model.addAttribute("stuList", stuList);
		int size = stuList.size();
		model.addAttribute("size", size);
		return "/studentManage/setStuID";
	}
	
	//插入学生信息
	@RequestMapping("/insertStudent")
	public void insertStudent(Student student) {
		
		int size = stuService.queryStudent().size();
		student.setStudentID(String.valueOf(size + 1));
		student.setDormNumber("waitForSet");
		student.setClassID("waitForSet");
		student.setStaySchool(false);
		student.setLeaveDate("2019-8-30");
		student.setAdmin(false);
		stuService.insertStudent(student);
	}
	
	//添加学生信息页面
	@RequestMapping("/addStudent")
	public String addStudent() {
		
		return "studentManage/newStuAdd";
	}
	
	
	//一键编制页面
	@RequestMapping("/setIDps")
	public String setIDps() {
		
		return "/studentManage/setIDps";
	}
	
	//删除学生信息功能
	@RequestMapping("/deleteStudent")
	public void deleteStudent(ServletRequest servletRequest){
		String studentID = servletRequest.getParameter("studentID");
		stuService.deleteStudent(studentID);
	}
	
	//批量删除学生信息功能
	@RequestMapping("/deleteAll")
	public void deleteAll(@RequestParam("deleteData") String[] param1) {
		
		for(int i = 0; i < param1.length; i++){
			stuService.deleteStudent(param1[i]);
		}
	}
	
	//学生信息编辑页面
	@RequestMapping("/stuEdit")
	public String stuEdit(Model model){
		
		Student student = stuService.queryStudentBystuID(stuIDForEdit);
		model.addAttribute("student", student);
		return "studentManage/stuEdit";
	}
	
	//学生信息编辑页面所需数据
	@RequestMapping("/stuEditHelp")
	public void stuEditHelp(ServletRequest servletRequest){
		
		stuIDForEdit = servletRequest.getParameter("studentID");
	}
	
	//更新学生信息
	@RequestMapping("/updateStudent")
	public void updateStudent(Student student){
		stuService.updateStudent(student);
	}
	
	//学生信息查询功能
	@RequestMapping("/Query")
	public String Query( Model model){
		String queryData = infoForQuery;
		String flag = flagForQuery;

		List<Student> studentList = new ArrayList<Student>();	
		if(queryData.equals("")){
			studentList = stuService.queryStudent();
		}else{
			//按学生姓名模糊查询
			List<Student> firstList = stuService.queryStudentBystuName(infoForQuery);
			if(!(firstList.isEmpty())){
				studentList = firstList;
			}
			
			//按学号精确查询
			Student student = stuService.queryStudentBystuID(infoForQuery);
			if(!(student == null)){
				studentList.add(student);
			}
			
			//均未查询到结果
			if(studentList.isEmpty()){
				studentList = stuService.queryStudent();
			}
		}
		
		if(flag.equals("2")){
			List<Student> another = new ArrayList<Student>();
			for(Student student : studentList){
				if(student.getDormNumber().equals("waitForSet")){
					another.add(student);
				}
			}
			studentList = another;
		}

		int length = studentList.size();
		model.addAttribute("stuList", studentList);
		model.addAttribute("size", length);
		
		if(flag.equals("1")){
			return "studentManage/newStuIfo";
		}
		else {
			return "studentManage/setStuID";
		}
		
	}
	
	//提供学生信息查询功能所需数据
	@RequestMapping("/QueryHelp")
	public void QueryHelp(ServletRequest request){
		infoForQuery = request.getParameter("info");
		flagForQuery = request.getParameter("flag");		
	}

	/*@RequestMapping("/queryNewStu")
	public void queryNewStudent(Model model) {
		
		List<Student> stuList = new ArrayList<Student>();
		stuList = stuService.queryNewStudent();
		model.addAttribute("stuList", stuList);
		int size = stuList.size();
		model.addAttribute("size", size);
		
		return "/studentManage";
	}*/

	@RequestMapping("/setStuIdPre")
	public void setStuID(ServletRequest request) {
		
		String prefix = request.getParameter("prefix");
		//System.out.println(prefix);
		List<Student> stuList = new ArrayList<Student>();
		stuList = stuService.queryNewStudent();
		//int size = stuList.size();
		String newID;
		for(int j = 0; j < stuList.size(); j++) {
			int i = j + 1;
			if(i < 10) {
				newID = prefix + "000" + String.valueOf(i);
			}else if(i < 100){
				newID = prefix + "00" + String.valueOf(i);
			}else if(i < 1000) {
				newID = prefix + "0" + String.valueOf(i);
			}else {
				newID = prefix + String.valueOf(i);
			}
			stuList.get(j).setStudentID(newID);
			stuService.updateStudent(stuList.get(j));
			
		}
	}
	
	/*
	 * 批量分配班级宿舍
	 */
	@RequestMapping("/setDormClass")
	public void setDormClass() {
		
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");//可以方便地修改日期格式
		String year = dateFormat.format(now);
		int temp = Integer.valueOf(year) % 100;
		String classPrefix = String.valueOf(temp);
		//System.out.println("test");
		List<Student> stuList = new ArrayList<Student>();
		stuList = stuService.queryNewStudent();
		int size = stuList.size();
		
		int classNumber = 1, j = 1;
		
		//以25人一班为规则，分配班级
		for(Student student : stuList) {
			if(size > 10) {
				for(int i = 0; i < 25; i++) {
					if(classNumber < 10) {
						student.setClassID(classPrefix + "00" + classNumber); 
						size--;
					} else if (classNumber < 100) {
						student.setClassID(classPrefix + "0" + classNumber);
						size--;
					} else {
						student.setClassID(classPrefix + classNumber);
						size--;
					}
				}
				if(size > 10) {
					classNumber++;
				}
			}else {
				student.setClassID(classPrefix + "00" + j);
				if(j < classNumber){
					j++;
				}else {
					j = 1;
				}
			}
		}
		
		//更新数据
		for(Student student : stuList) {
			stuService.updateStudent(student);
		}
				
		//根据宿舍类型分配给学生宿舍
		
		List<Dorm> dormListGirl = new ArrayList<Dorm>();
		List<Dorm> dormListBoy = new ArrayList<Dorm>();
		dormListGirl = stuService.queryFemaleDorm();
		dormListBoy = stuService.queryMaleDorm();
		
		List<Student> stuListGirl = new ArrayList<Student>();
		List<Student> stuListBoy = new ArrayList<Student>();
		stuListGirl = stuService.queryNewStudentFemale();
		stuListBoy = stuService.queryNewStudentMale();
		int sizeGirl = stuListGirl.size();
		int sizeBoy = stuListBoy.size();
		
		//标记已经分配到哪个学生,先分配女生
		int flagGirl = 0;
		if(sizeGirl != 0) {
			
			for(Dorm dorm : dormListGirl) {
				for(int h = 0; h < dorm.getDormKind(); h++) {
					stuListGirl.get(flagGirl).setDormNumber(dorm.getDormNumber());
					if(flagGirl >= sizeGirl-1) {
						break;
					}else {
						flagGirl++;
					}
				}
				dorm.setFull(true);
				stuService.updateDorm(dorm);
				if(flagGirl >= sizeGirl-1) {
					break;
				}
			}
			
			for(Student student : stuListGirl) {
				stuService.updateStudent(student);
			}
		}
		
		//分配男生
		int flagBoy = 0;
		
		if(sizeBoy != 0) {
			
			for(Dorm dorm : dormListBoy) {
				for(int h = 0; h < dorm.getDormKind(); h++) {
					stuListBoy.get(flagBoy).setDormNumber(dorm.getDormNumber());
					if(flagBoy >= sizeBoy-1) {
						break;
					}else {
						flagBoy++;
					}
				}
				dorm.setFull(true);
				stuService.updateDorm(dorm);
				if(flagBoy >= sizeBoy-1) {
					break;
				}
			}
			
			for(Student student : stuListBoy) {
				stuService.updateStudent(student);
			}
		}
		
		
		
	}
}
