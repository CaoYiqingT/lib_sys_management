package com.nwpu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwpu.dao.IDormDao;
import com.nwpu.model.Dorm;
import com.nwpu.model.DormApplication;
import com.nwpu.model.Student;
import com.nwpu.service.DormService;

/*
 * DormService实现类
 */
@Service("dormService")
public class DormServiceImpl implements DormService{

	@Autowired
	IDormDao dormDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.nwpu.service.DormService#insertDorm(com.nwpu.model.Dorm)
	 */
	public void insertDorm(Dorm dorm) {
		
		dormDao.insertDorm(dorm);
	}

	/*
	 * (non-Javadoc)
	 * @see com.nwpu.service.DormService#selectDorm()
	 */
	@Override
	public List<Dorm> selectDorm() {
		
		return dormDao.selectDorm();
	}

	@Override
	public List<Student> queryStudent() {
		
		return dormDao.queryStudent();
	}

	@Override
	public void deleteDorm(String dormNumber) {
		
		dormDao.deleteDorm(dormNumber);
	}

	@Override
	public List<DormApplication> queryApply(String studentID) {
		
		return dormDao.queryApply(studentID);
	}

	@Override
	public void insertApply(DormApplication dormApplication) {
		
		dormDao.insertApply(dormApplication);
	}

	@Override
	public List<Student> queryStudentById(String studentID) {
		
		return dormDao.queryStudentById(studentID);
	}

	@Override
	public Student getStudentById(String studentID) {
		// TODO Auto-generated method stub
		return dormDao.getStudentById(studentID);
	}

	@Override
	public List<Student> queryStudentByDrom(String dormNumber) {
		// TODO Auto-generated method stub
		return dormDao.queryStudentByDrom(dormNumber);
	}

	@Override
	public Dorm queryDormByDormNumber(String dormNumber) {
		
		return dormDao.queryDormByDormNumber(dormNumber);
	}

	@Override
	public void updateDorm(Dorm dorm) {
		dormDao.updateDorm(dorm);
		
	}

	@Override
	public void updateStudent(Student student) {
		dormDao.updateStudent(student);
		
	}

	@Override
	public List<DormApplication> queryAllApply() {
		
		return dormDao.queryAllApply();
	}

	@Override
	public void updateApply(String applyNumber) {
		
		dormDao.updateApply(applyNumber);
	}
	
}
