package com.nwpu.dao;

import java.util.List;

import com.nwpu.model.Dorm;
import com.nwpu.model.Student;

public interface IStudentDao {

	
	/*
	 * 查询邮箱
	 */
	String queryEmailByID(String studentID);
	
	/*
	 * 查询学生
	 */
	List<Student> queryStudent();
	
	/*
	 * 插入学生
	 */
	void insertStudent(Student student);
	
	/*
	 * 删除学生
	 */
	void deleteStudent(String studentID);
	
	/*
	 * 查询特定学生 by studentID
	 */
	Student queryStudentBystuID(String studentID);
	
	/*
	 * 更新学生信息
	 */
	void updateStudent(Student student);
	
	/*
	 * 查询特定学生 by studentName
	 */
	List<Student> queryStudentBystuName(String studentName);
	
	/*
	 * 查询新生
	 */
	List<Student> queryNewStudent();
	
	/*
	 * 查询非管理员男宿舍
	 */
	List<Dorm> queryFemaleDorm();
	
	/*
	 * 查询新生女生
	 */
	List<Student> queryNewStudentFemale();
	
	/*
	 * 查询新生男生
	 */
	List<Student> queryNewStudentMale();
	
	/*
	 * 查询非管理员女宿舍
	 */
	List<Dorm> queryMaleDorm();
	
	/*
	 * 宿舍状态更新
	 */
	void updateDorm(Dorm dorm);
}
