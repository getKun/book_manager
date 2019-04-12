package com.cduest.service.impl;

import java.util.ArrayList;

import com.cduest.dao.IPublicQueryBookDao;
import com.cduest.dao.impl.PublicQueryBookJdbc;
import com.cduest.model.User;
import com.cduest.service.IPublicQueryBookService;

/**
 * 查询全部已借出图书或某个用户已借出图书的service实现类
 * @author 1630720115
 * 
 *
 */
public class PublicQueryBookSer implements IPublicQueryBookService {

	private IPublicQueryBookDao dao=new PublicQueryBookJdbc();
	private ArrayList<Object> list;
	
	//查询全部已借出的图书
	@Override
	public ArrayList<Object> queryAllBorrowedBook() {
		
		list=dao.queryAllBorrowedBook();
		return list;
	}

	//查询某个用户借出的图书
	@Override
	public ArrayList<Object> queryUserBorrowedBook(User user) {
		
		list=dao.queryUserBorrowedBook(user);
		return list;
	}

}
