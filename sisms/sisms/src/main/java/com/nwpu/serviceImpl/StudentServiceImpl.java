package com.nwpu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwpu.dao.IStudentDao;
import com.nwpu.model.Dorm;
import com.nwpu.model.Student;
import com.nwpu.service.StudentService;

@Service("stuService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	private IStudentDao stuDao;
	
	public String queryEmailByID(String studentID){
		return stuDao.queryEmailByID(studentID);
	}
	
	@Override
	public List<Student> queryStudent() {
		
		return stuDao.queryStudent();
	}

	@Override
	public void insertStudent(Student student) {
		
		stuDao.insertStudent(student);
	}

	@Override
	public void deleteStudent(String studentID) {
		stuDao.deleteStudent(studentID);
		
	}

	@Override
	public Student queryStudentBystuID(String studentID) {
		
		return stuDao.queryStudentBystuID(studentID);
	}

	@Override
	public void updateStudent(Student student) {
		stuDao.updateStudent(student);
		
	}

	@Override
	public List<Student> queryStudentBystuName(String studentName) {
		
		return stuDao.queryStudentBystuName(studentName);
	}

	@Override
	public List<Student> queryNewStudent() {
		
		return stuDao.queryNewStudent();
	}

	@Override
	public List<Dorm> queryFemaleDorm() {
		
		return stuDao.queryFemaleDorm();
	}

	@Override
	public List<Student> queryNewStudentFemale() {
		
		return stuDao.queryNewStudentFemale();
	}

	@Override
	public List<Student> queryNewStudentMale() {
		
		return stuDao.queryNewStudentMale();
	}

	@Override
	public List<Dorm> queryMaleDorm() {
		
		return stuDao.queryMaleDorm();
	}

	@Override
	public void updateDorm(Dorm dorm) {
		
		stuDao.updateDorm(dorm);
	}

	

}
