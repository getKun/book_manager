package com.cduest.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cduest.dao.IAdministrators;
import com.cduest.dao.impl.AdminJdbc;
import com.cduest.model.Book;
import com.cduest.model.User;
import com.cduest.service.IAdminService;

/**
 * 管理员service层实现类
 * @author 1630720115
 *
 */
public class AdminSer implements IAdminService{
	
	IAdministrators admin=new AdminJdbc();
	User user=new User();

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

	//删除用户
	@Override
	public boolean deleteUser(User user) {

		boolean boo=admin.deleteUser(user);
		return boo;
	}

	//查询全部用户
	@Override
	public List<Object> queryAllUser() {

		ArrayList<Object> list=new ArrayList<Object>();
		list=(ArrayList<Object>) admin.queryAllUser();
		return list;
	}

	//查询全部图书
	@Override
	public List<Object> queryAllBook() {

		ArrayList<Object> list=new ArrayList<Object>();
		list=(ArrayList<Object>) admin.queryAllBook();
		return list;
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
