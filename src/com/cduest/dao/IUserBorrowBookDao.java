package com.cduest.dao;

import com.cduest.model.Book;
import com.cduest.model.User;

/**
 * �û����黹��dao��
 * @author 1630720115
 *
 */
public interface IUserBorrowBookDao {

	boolean borrowBook(User user,Book book);
	
	boolean returnBook(User user,Book book) ;
	
	boolean judgeBook(Book book);
	
	boolean judgeUserBorrowedBook(User user);
}
