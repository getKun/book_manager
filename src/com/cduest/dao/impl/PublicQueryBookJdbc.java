package com.cduest.dao.impl;

import java.util.ArrayList;
import com.cduest.dao.IPublicQueryBookDao;
import com.cduest.model.Book;
import com.cduest.model.User;
import com.cduest.utils.JdbcUtil;

/**
 * ��ѯȫ���ѽ��ͼ���ĳ���û��ѽ��ͼ���jdbcʵ����
 * @author 1630720115
 * 
 *
 */
public class PublicQueryBookJdbc implements IPublicQueryBookDao {
	
	private JdbcUtil ju=new JdbcUtil();
	private ArrayList<Book> list=new ArrayList<Book>();
	

	//��ѯȫ���ѽ����ͼ��
	@Override
	public ArrayList<Book> queryAllBorrowedBook() {
		
		
		return null;
	}

	//��ѯĳ���û������ͼ��
	@Override
	public ArrayList<Book> queryUserBorrowedBook(User user) {
		
		
		return null;
	}

}
