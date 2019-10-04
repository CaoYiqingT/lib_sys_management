package com.nwpu.dao;

public interface ILoginDao {

	/*
	 * 登录获取密码
	 */
	String login(String userName);
	
	/*
	 * 获取用户信息
	 */
	boolean isAdmin(String userName);
	
	/*
	 * 获取用户名
	 */
	String getNameById(String studentID);
	
	/*
	 * 获取公告
	 */
	String getNotice();
	/*
	 * 重置密码
	 */
	void resetPassword(String studentID);
	
}
