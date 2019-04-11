package com.cduest.dao.impl;

import java.util.ArrayList;
import com.cduest.dao.IPublicQueryBookDao;
import com.cduest.model.Book;
import com.cduest.model.User;
import com.cduest.utils.JdbcUtil;

/**
 * 查询全部已借出图书或某个用户已借出图书的jdbc实现类
 * @author 1630720115
 * 
 *
 */
public class PublicQueryBookJdbc implements IPublicQueryBookDao {
	
	private JdbcUtil ju=new JdbcUtil();
	private ArrayList<Book> list=new ArrayList<Book>();
	

	//查询全部已借出的图书
	@Override
	public ArrayList<Book> queryAllBorrowedBook() {
		
		
		return null;
	}

	//查询某个用户借出的图书
	@Override
	public ArrayList<Book> queryUserBorrowedBook(User user) {
		
		
		return null;
	}

}
