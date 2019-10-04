package com.nwpu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwpu.dao.IleaveDao;
import com.nwpu.model.Student;
import com.nwpu.model.StudentRecord;
import com.nwpu.service.LeaveService;

@Service("leaveService")
public class LeaveServiceImpl implements LeaveService{

	@Autowired
	private IleaveDao leaveDao;
	
	@Override
	public List<Student> queryStudent(String leaveDate) {
		
		return leaveDao.queryStudent(leaveDate);
	}

	@Override
	public List<Student> queryBorrow(String leaveDate) {
		
		return leaveDao.queryBorrow(leaveDate);
	}

	@Override
	public Student queryStudentByID(String studentID) {
		
		return leaveDao.queryStudentByID(studentID);
	}

	@Override
	public Student queryBorrowByID(String studentID) {
		
		return leaveDao.queryBorrowByID(studentID);
	}

	@Override
	public List<StudentRecord> queryRecordByID(String studentID) {
		
		return leaveDao.queryRecordByID(studentID);
	}

	@Override
	public List<Student> queryStudentBystuName(String studentName, String leaveDate) {
		
		return leaveDao.queryStudentBystuName(studentName, leaveDate);
	}

	@Override
	public List<Student> queryBorrowStudentBystuName(String studentName, String leaveDate) {
		
		return leaveDao.queryBorrowStudentBystuName(studentName, leaveDate);
	}
}
