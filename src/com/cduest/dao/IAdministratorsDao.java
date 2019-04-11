package com.cduest.dao;

import java.util.List;

import com.cduest.model.Book;
import com.cduest.model.User;

/**
 * 管理员接口
 * @author 1630720115
 *
 */
public interface IAdministratorsDao{

	boolean addBook(Book book);
	
	boolean deleteBook(Book book);
	
	boolean deleteUser(User user);
	
	List<Object> queryAllUser();
	
	List<Object> queryAllBook();

	boolean login(User user);

	boolean register(User user);
	
	
}
