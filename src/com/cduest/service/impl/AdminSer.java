package com.cduest.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cduest.dao.IAdministrators;
import com.cduest.dao.impl.AdminJdbc;
import com.cduest.model.Book;
import com.cduest.model.User;
import com.cduest.service.IAdminService;

/**
 * ����Աservice��ʵ����
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

	//ɾ���û�
	@Override
	public boolean deleteUser(User user) {

		boolean boo=admin.deleteUser(user);
		return boo;
	}

	//��ѯȫ���û�
	@Override
	public List<Object> queryAllUser() {

		ArrayList<Object> list=new ArrayList<Object>();
		list=(ArrayList<Object>) admin.queryAllUser();
		return list;
	}

	//��ѯȫ��ͼ��
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
