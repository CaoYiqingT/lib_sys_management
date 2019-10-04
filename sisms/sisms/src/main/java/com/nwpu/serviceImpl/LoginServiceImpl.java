package com.nwpu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwpu.dao.ILoginDao;
import com.nwpu.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private ILoginDao loginDao;
	
	@Override
	public String login(String userName) {
		
		return loginDao.login(userName);
	}

	@Override
	public boolean isAdmin(String userName) {
		
		return loginDao.isAdmin(userName);
	}

	@Override
	public String getNameById(String studentID) {
		
		return loginDao.getNameById(studentID);
	}

	@Override
	public String getNotice() {
		
		return loginDao.getNotice();
	}
	public void resetPassword(String studentID){
		
	}

}
