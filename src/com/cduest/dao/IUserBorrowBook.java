package com.cduest.dao;

import com.cduest.model.Book;
import com.cduest.model.User;

/**
 * �û����黹��dao��
 * @author 1630720115
 *
 */
public interface IUserBorrowBook {

	boolean borrowBook(User user,Book book);
	
	boolean returnBook(User user,Book book) ;
}
