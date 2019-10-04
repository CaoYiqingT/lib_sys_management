package com.nwpu.dao;

import java.util.List;

import com.nwpu.model.Student;

public interface IAdminDao {

	/*
	 * 新增管理员
	 */
	void insertAdmin(Student student);
	
	/*
	 * 查询管理员
	 */
	List<Student> queryAdmin();
	
	/*
	 * 删除管理员
	 */
	void deleteAdmin(String studentID);
	
	/*
	 * 发布公告
	 */
	void subNotice(String context);
}
