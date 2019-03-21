package com.cduest.dao;

import java.util.List;

import com.cduest.model.Book;
import com.cduest.model.User;

/**
 * ����Ա�ӿ�
 * @author 1630720115
 *
 */
public interface IAdministrators extends IUserLoginAndRegister{

	boolean addBook(Book book);
	
	boolean deleteBook(Book book);
	
	boolean deleteUser(User user);
	
	List<User> queryAllUser();
	
	List<Book> queryAllBook();
	
	
}
