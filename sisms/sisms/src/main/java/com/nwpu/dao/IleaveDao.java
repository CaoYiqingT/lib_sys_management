package com.nwpu.dao;

import java.util.List;

import com.nwpu.model.Student;
import com.nwpu.model.StudentRecord;

public interface IleaveDao {

	/*
	 * 查询离校学生
	 */
	List<Student> queryStudent(String leaveDate);
	
	/*
	 * 查询借阅图书
	 */
	List<Student> queryBorrow(String leaveDate);
	
	/*
	 * 根据学号找学生
	 */
	Student queryStudentByID(String studentID);
	
	/*
	 * 根据学号找学生未还书
	 */
	Student queryBorrowByID(String studentID);
	
	/*
	 * 根据学号查未缴款项
	 */
	List<StudentRecord> queryRecordByID(String studentID);
	
	/*
	 * 根据姓名查询学生
	 */
	List<Student> queryStudentBystuName(String studentName,String leaveDate);
	
	/*
	 * 根据姓名查询借书学生
	 */
	List<Student> queryBorrowStudentBystuName(String studentName,String leaveDate);
	
}
