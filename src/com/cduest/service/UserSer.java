package com.cduest.service;

import com.cduest.dao.IUserBorrowBook;
import com.cduest.dao.IUserLoginAndRegister;
import com.cduest.model.Book;
import com.cduest.model.User;

/**
 * �û�service��
 * @author 1630720115
 *
 */
public class UserSer implements IUserLoginAndRegister,IUserBorrowBook{

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerJudge(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrowBook(User user, Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean returnBook(User user, Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
