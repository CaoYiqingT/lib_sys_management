package com.nwpu.service;

import java.util.List;

import com.nwpu.model.StudentRecord;

public interface StudentRecordService {
	public List<StudentRecord> getStudentRecordList(String studentID);
	
	public List<StudentRecord> getStudentRecordListAll();
	
	public List<StudentRecord> getStudentRecordByStudentId(String check);
	
	public String toString();
	
	public void updateStudentRecordByKey(String key);
	
	public void insertStudentRecord(StudentRecord record);
	
	/*
	 * 根据学号查姓名
	 */
	String queryStudentNameByID(String studentID);
}
