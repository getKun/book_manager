package com.cduest.service.impl;

import java.util.List;

import com.cduest.model.Book;
import com.cduest.model.User;
import com.cduest.service.IAdminService;

/**
 * 管理员service层实现类
 * @author 1630720115
 *
 */
public class AdminSer implements IAdminService{

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	//查询全部用户
	@Override
	public List<Object> queryAllUser() {

		
		return null;
	}

	@Override
	public List<Object> queryAllBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerJudge(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
