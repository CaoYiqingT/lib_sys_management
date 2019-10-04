package com.nwpu.dao;

import java.util.List;

import com.nwpu.model.Book;

public interface TextBookManageDao {

	/*
	 * ��ѯ�̲�
	 */
	List<Book> queryBook();
	
	/*
	 * ɾ���̲�
	 */
	void deleteBook(String ISBN);
	
	/*
	 * ��ӽ̲�
	 */
	void insertBook(Book book);
	
	/*
	 * ��ѯĳ���̲� by ISBN
	 */
	Book queryBookByISBN(String ISBN);
	
	/*
	 * ���½̲���Ϣ
	 */
	void updateBook(Book book);
	
	/*
	 * ģ����ѯ�̲� by bookName
	 */
	List<Book> queryBookByBookName(String bookName);
}
