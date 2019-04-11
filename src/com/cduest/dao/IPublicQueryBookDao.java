package com.cduest.dao;

import java.util.ArrayList;

import com.cduest.model.Book;
import com.cduest.model.User;

/**
 * 查询全部已借出图书或某个用户已借出图书的dao层接口
 * @author 1630720115
 *
 */
public interface IPublicQueryBookDao {

	ArrayList<Book> queryAllBorrowedBook();
	
	ArrayList<Book> queryUserBorrowedBook(User user);
}
