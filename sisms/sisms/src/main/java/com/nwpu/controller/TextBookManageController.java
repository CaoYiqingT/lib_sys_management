package com.nwpu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nwpu.dao.TextBookManageDao;
import com.nwpu.model.Book;
import com.nwpu.service.TextBookManageSevice;

/*
 * 教材管理控制类
 */
@Controller
@RequestMapping("/textBookManage")
public class TextBookManageController {
	
	//所编辑教材的ISBN
	static String ISBNForEdit="";
	//所查询的信息内容
	static String infoForQuery="";
	//申请查询的页面
	static String flagForQuery="";
	
	@Autowired
	private TextBookManageSevice textBookManageService;
	
	//教材信息页面
	@RequestMapping("/jcInformation")
	public String jcInformation(Model model) {
		
		List<Book> bookList = new ArrayList<Book>();
		bookList = textBookManageService.queryBook();
		int length = bookList.size();
		model.addAttribute("bookList", bookList);
		model.addAttribute("length", length);
		return "textbookManage/jcinformation";
	}
	
	//教材信息页面
	@RequestMapping("/BookInformation")
	public String bookInformation(Model model) {
		
		List<Book> bookList = new ArrayList<Book>();
		bookList = textBookManageService.queryBook();
		int length = bookList.size();
		model.addAttribute("bookList", bookList);
		model.addAttribute("length", length);
		return "textbookManage/bookinformation";
	}
	
	//教材审定页面
	@RequestMapping("/jcCheck")
	public String jcCheck(Model model) {
		
		List<Book> bookList = new ArrayList<Book>();
		bookList = textBookManageService.queryBook();
		int length = bookList.size();
		model.addAttribute("bookList", bookList);
		model.addAttribute("length", length);
		
		return "textbookManage/jccheck";
	}
	
	//教材征订页面
	@RequestMapping("/jcPurchase")
	public String jcPurchase(Model model){
		List<Book> bookList = new ArrayList<Book>();
		bookList = textBookManageService.queryBook();
		int length = bookList.size();
		//根据征订学期有无计算数量
		int num = 0;
		for(Book book : bookList){
			if(book.getSemeter()!=null){
				num++;
			}
		}
		model.addAttribute("bookList", bookList);
		model.addAttribute("length", length);
		model.addAttribute("num", num);
		return "textbookManage/jcpurchase";
	}
	
	//教材发放页面
	@RequestMapping("/jcProvide")
	public String jcProvide(Model model){
		List<Book> bookList = new ArrayList<Book>();
		bookList = textBookManageService.queryBook();
		int length = bookList.size();
		//根据是否发放有无计算数量
		int num = 0;
		for(Book book : bookList){
			if(book.getProviding()!=null){
				num++;
			}
		}
		model.addAttribute("bookList", bookList);
		model.addAttribute("length", length);
		model.addAttribute("num", num);
		return "textbookManage/jcprovide";
	}
	
	//教材编辑页面
	@RequestMapping("/jcEdit")
	public String jcEdit(Model model){
		
		System.out.println(ISBNForEdit);
		Book book = textBookManageService.queryBookByISBN(ISBNForEdit);
		model.addAttribute("book", book);
		return "textbookManage/jc-edit";
	}
	
	//教材编辑页面所需数据
	@RequestMapping("/jcEditHelp")
	public void jcEditHelp(ServletRequest servletRequest){
		
		ISBNForEdit = servletRequest.getParameter("ISBN");
	}
	
	
	//教材添加页面
	@RequestMapping("/jcAdd")
	public String jcAdd(){
		
		return "textbookManage/jc-add";
	}
	
	//教材删除功能
	@RequestMapping("/textDelete")
	public void jcDelete(ServletRequest servletRequest) {
	
		String ISBN = servletRequest.getParameter("ISBN");
		textBookManageService.deleteBook(ISBN);
	}
	
	//教材添加功能
	@RequestMapping("/textAdd")
	public void textAdd(Book book){
		if(book.getSemeter().equals("")){
			book.setSemeter(null);
		}
		if(book.getProviding().equals("")){
			book.setProviding(null);
		}
		textBookManageService.insertBook(book);
	}
	
	//教材更新功能
	@RequestMapping("/textUpdate")
	public void textUpdate(Book book){
		if(book.getSemeter().equals("")){
			book.setSemeter(null);
		}
		
		textBookManageService.updateBook(book);
	}
	
	//教材查询功能
	@RequestMapping("/Query")
	public String Query( Model model){
		String queryData = infoForQuery;
		String flag = flagForQuery;

		List<Book> bookList = new ArrayList<Book>();	
		if(queryData.equals("")){
			bookList = textBookManageService.queryBook();
		}else{
			//按名称模糊查询
			List<Book> firstList = textBookManageService.queryBookByBookName(queryData);
			if(!(firstList.isEmpty())){
				bookList = firstList;
			}
			
			//按ISBN精确查询
			Book book = textBookManageService.queryBookByISBN(queryData);
			if(!(book == null)){
				bookList.add(book);
			}
			
			//均未查询到结果
			if(bookList.isEmpty()){
				bookList = textBookManageService.queryBook();
			}
		}

		int length = bookList.size();
		System.out.println(length);
		model.addAttribute("bookList", bookList);
		model.addAttribute("length", length);
		
		//征订页面数量
		if(flag.equals("3")){
			int num = 0;
			for(Book book : bookList){
				if(book.getSemeter()!=null){
					num++;
				}
			}
			model.addAttribute("num", num);
		}
		
		//发放页面数量
		if(flag.equals("4")){
			int num = 0;
			for(Book book : bookList){
				if(book.getProviding()!=null){
					num++;
				}
			}
			model.addAttribute("num", num);
		}
		if(flag.equals("1")){
			return "textbookManage/jcinformation";
		}
		else if(flag.equals("2")){
			return "textbookManage/jccheck";
		}
		else if(flag.equals("3")){
			return "textbookManage/jcpurchase";
		}else{
			return "textbookManage/jcprovide";
		}
	}
	
	//提供教材查询功能所需数据
	@RequestMapping("/QueryHelp")
	public void QueryHelp(ServletRequest request){
		infoForQuery = request.getParameter("info");
		flagForQuery = request.getParameter("flag");		
	}
	
	//教材批量删除功能
	@RequestMapping("/deleteAll")
	public void deleteAll(@RequestParam("deleteData") String[] param1) {
		
		for(int i = 0; i < param1.length; i++){
			textBookManageService.deleteBook(param1[i]);
		}
	}

}
