package com.cduest.dao;

import java.util.ArrayList;

import com.cduest.model.Book;
import com.cduest.model.User;

/**
 * ��ѯȫ���ѽ��ͼ���ĳ���û��ѽ��ͼ���dao��ӿ�
 * @author 1630720115
 *
 */
public interface IPublicQueryBookDao {

	ArrayList<Book> queryAllBorrowedBook();
	
	ArrayList<Book> queryUserBorrowedBook(User user);
}
