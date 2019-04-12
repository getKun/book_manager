package com.cduest.service.impl;

import java.util.ArrayList;

import com.cduest.dao.IPublicQueryBookDao;
import com.cduest.dao.impl.PublicQueryBookJdbc;
import com.cduest.model.User;
import com.cduest.service.IPublicQueryBookService;

/**
 * ��ѯȫ���ѽ��ͼ���ĳ���û��ѽ��ͼ���serviceʵ����
 * @author 1630720115
 * 
 *
 */
public class PublicQueryBookSer implements IPublicQueryBookService {

	private IPublicQueryBookDao dao=new PublicQueryBookJdbc();
	private ArrayList<Object> list;
	
	//��ѯȫ���ѽ����ͼ��
	@Override
	public ArrayList<Object> queryAllBorrowedBook() {
		
		list=dao.queryAllBorrowedBook();
		return list;
	}

	//��ѯĳ���û������ͼ��
	@Override
	public ArrayList<Object> queryUserBorrowedBook(User user) {
		
		list=dao.queryUserBorrowedBook(user);
		return list;
	}

}
