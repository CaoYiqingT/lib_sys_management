package com.nwpu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwpu.dao.StudentRecordDao;
import com.nwpu.model.StudentRecord;
import com.nwpu.service.StudentRecordService;

@Service
public class StudentRecordServiceImpl implements StudentRecordService{
    
	@Autowired 
	private StudentRecordDao studentRecordDao;//学生DAO接口
	
	/**
     * 列出学生交易记录
     */
	public  List<StudentRecord> getStudentRecordList(String studentID) {
		//System.out.println("serviceimpl执行");
		//System.out.println(studentRecordDao.getStudentRecordList().get(0).getStudentID());
		return studentRecordDao.getStudentRecordList(studentID);
	}
	
	/*
	 * 根据学号查询学生交易记录
	 */
	public List<StudentRecord> getStudentRecordByStudentId(String check){
		return studentRecordDao.queryStudentRecordByStudentId(check);
	}
	
	/*
	 * 更新学生交易记录
	 */
	public void updateStudentRecordByKey(String key){
		studentRecordDao.updateStudentRecordByKey(key);
	}
	
	/*
	 * 发布收费信息
	 */
	public void insertStudentRecord(StudentRecord record){
		studentRecordDao.insertStudentRecord(record);
	}

	@Override
	public String queryStudentNameByID(String studentID) {
		
		return studentRecordDao.queryStudentNameByID(studentID);
	}

	@Override
	public List<StudentRecord> getStudentRecordListAll() {
		// TODO Auto-generated method stub
		return studentRecordDao.getStudentRecordListAll();
	}
	
}
