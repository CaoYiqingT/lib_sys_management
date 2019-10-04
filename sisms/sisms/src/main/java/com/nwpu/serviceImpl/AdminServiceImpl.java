package com.nwpu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwpu.dao.IAdminDao;
import com.nwpu.model.Student;
import com.nwpu.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private IAdminDao adminDao;

	@Override
	public void insertAdmin(Student student) {
		
		adminDao.insertAdmin(student);
	}

	@Override
	public List<Student> queryAdmin() {
		
		return adminDao.queryAdmin();
	}

	@Override
	public void deleteAdmin(String studentID) {
		
		adminDao.deleteAdmin(studentID);
	}

	@Override
	public void subNotice(String context) {
		// TODO Auto-generated method stub
		adminDao.subNotice(context);
	}
	
}
