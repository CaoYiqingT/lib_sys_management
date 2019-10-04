package com.nwpu.dao;

import java.util.List;

import com.nwpu.model.Book;

public interface TextBookManageDao {

	/*
	 * 查询教材
	 */
	List<Book> queryBook();
	
	/*
	 * 删除教材
	 */
	void deleteBook(String ISBN);
	
	/*
	 * 添加教材
	 */
	void insertBook(Book book);
	
	/*
	 * 查询某本教材 by ISBN
	 */
	Book queryBookByISBN(String ISBN);
	
	/*
	 * 更新教材信息
	 */
	void updateBook(Book book);
	
	/*
	 * 模糊查询教材 by bookName
	 */
	List<Book> queryBookByBookName(String bookName);
}
