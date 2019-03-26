package com.cduest.main;

import java.util.ArrayList;
import java.util.List;

import com.cduest.dao.impl.AdminJdbc;
import com.cduest.dao.impl.UserBorrowBook;
import com.cduest.dao.impl.UserLoginAndRegisterJdbc;
import com.cduest.model.Book;
import com.cduest.model.User;

public class TheMainClass {

	public static void main(String[] args) {
//		UserLoginAndRegisterJdbc ulrj=new UserLoginAndRegisterJdbc();
//		User user=new User();
//		u.setUid("123");
//		u.setPwd("123");
//		boolean b=us.login(u);
//		System.out.println(b);
		
//		user.setUid("234");
//		user.setPwd("234");
//		boolean b=ulrj.register(user);
//		System.out.println(b);
		
//		user.setUid("456");
//		user.setPwd("456");
//		boolean b=ulrj.registerJudge(user);
//		System.out.println(b);
		
//		AdminJdbc aj=new AdminJdbc();
//		List<Object> list=aj.queryAllUser();
//		for (Object u : list) {
//			System.out.println(u.toString());
//		}
		
//		List<Object> list=aj.queryAllBook();
//		for (Object book : list) {
//			System.out.println(book.toString());
//		}
		UserBorrowBook ubb=new UserBorrowBook();
		User u=new User("123", "123");
		Book b=new Book("234", "234", "234");
		boolean b1=ubb.borrowBook(u, b);
		System.out.println(b1);
		
	}
}
