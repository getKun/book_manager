package com.cduest.service;


import com.cduest.model.Book;
import com.cduest.model.User;

/**
 * �û�service��ӿ�
 * @author 1630720115
 *
 */
public interface IUserService {

	boolean login(User user);

	boolean register(User user);

	boolean borrowBook(User user, Book book);

	boolean returnBook(User user, Book book);

	
}
