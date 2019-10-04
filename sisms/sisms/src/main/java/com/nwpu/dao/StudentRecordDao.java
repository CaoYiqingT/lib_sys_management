package com.nwpu.dao;

import java.util.List;

import com.nwpu.model.StudentRecord;

public interface StudentRecordDao {
	/*
	 * 查询集合
	 */
	List<StudentRecord> getStudentRecordList(String studentID);
	
	List<StudentRecord> getStudentRecordListAll();
	
	/*
	 * 根据学生学号查询交易记录
	 */
	List<StudentRecord> queryStudentRecordByStudentId(String check);
	
	/*
	 * 学生点击缴费后从缴费通知中删除，添加到交易记录中
	 */
	void updateStudentRecordByKey(String key);
	
	/*
	 * 发布收费信息（Insert）
	 */
	void insertStudentRecord(StudentRecord record);

	
	/*
	 * 根据学号查姓名
	 */
	String queryStudentNameByID(String studentID);
}
