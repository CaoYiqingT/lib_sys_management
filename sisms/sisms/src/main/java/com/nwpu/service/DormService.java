package com.nwpu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nwpu.model.Dorm;
import com.nwpu.model.DormApplication;
import com.nwpu.model.Student;

public interface DormService {

	/*
	 * 增加宿舍
	 */
	void insertDorm(Dorm dorm);
	
	/*
	 * 查询宿舍
	 */
	List<Dorm> selectDorm();
	
	/*
	 * 入住信息查询
	 */
	List<Student> queryStudent();
	
	/*
	 * 删除宿舍
	 */
	void deleteDorm(String dormNumber);
	
	/*
	 * 学生宿舍申请查询
	 */
	List<DormApplication> queryApply(String studentID);
	
	/*
	 * 添加宿舍申请
	 */
	void insertApply(DormApplication dormApplication);
	
	/*
	 * 根据学号查询学生
	 */
	List<Student> queryStudentById(String studentID);
	
	/*
	 * 查询单个学生
	 */
	Student getStudentById(String studentID);
	
	/*
	 * 查询宿舍成员
	 */
	List<Student> queryStudentByDrom(String dormNumber);
	
	/*
	 * 查询单个宿舍
	 */
	Dorm queryDormByDormNumber(String dormNumber);
	
	/*
	 * 更新宿舍
	 */
	
	void updateDorm(Dorm dorm);
	
	/*
	 * 更新学生信息
	 */
	void updateStudent(Student student);
	
	/*
	 * 查询所有申请
	 */
	List<DormApplication> queryAllApply();
	
	/*
	 * 更新申请状态
	 */
	void updateApply(String applyNumber);
}
