package com.cduest.service;

import java.util.List;
import com.cduest.model.Book;
import com.cduest.model.User;

/**
 * 管理员service层接口
 * @author 1630720115
 *
 */
public interface IAdminService{

	boolean addBook(Book book);

	boolean deleteBook(Book book);

	boolean deleteUser(User user);

	List<Object> queryAllUser();

	List<Object> queryAllBook();

	boolean login(User user);

	boolean register(User user);
	
}
