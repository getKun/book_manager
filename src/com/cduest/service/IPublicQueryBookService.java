package com.cduest.service;

import java.util.ArrayList;

import com.cduest.model.Book;
import com.cduest.model.User;

/**
 * ��ѯȫ���ѽ��ͼ���ĳ���û��ѽ��ͼ���service��ӿ�
 * @author 1630720115
 *
 */
public interface IPublicQueryBookService {

	ArrayList<Book> queryAllBorrowedBook();
	
	ArrayList<Book> queryUserBorrowedBook(User user);
}
