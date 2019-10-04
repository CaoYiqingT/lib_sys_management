package com.nwpu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwpu.dao.TextBookManageDao;
import com.nwpu.model.Book;
import com.nwpu.service.TextBookManageSevice;

@Service("textBookManageService")
public class TextBookManageServiceImpl implements TextBookManageSevice{

	@Autowired
	private TextBookManageDao textBookManageDao;
	
	@Override
	public List<Book> queryBook() {
		
		return textBookManageDao.queryBook();
	}

	@Override
	public void deleteBook(String ISBN) {
		
		textBookManageDao.deleteBook(ISBN);
	}
	
	@Override
	public void insertBook(Book book){
		
		textBookManageDao.insertBook(book);
	}

	@Override
	public Book queryBookByISBN(String ISBN) {
		
		return textBookManageDao.queryBookByISBN(ISBN);
	}

	@Override
	public void updateBook(Book book) {
	
		textBookManageDao.updateBook(book);
		
	}

	@Override
	public List<Book> queryBookByBookName(String bookName) {
		
		return textBookManageDao.queryBookByBookName(bookName);
	}

	
}
