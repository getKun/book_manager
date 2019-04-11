package com.cduest.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.cduest.dao.IAdministratorsDao;
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
	
	private IAdministratorsDao admin=new AdminJdbc();

	//添加图书
	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	//删除图书
	@Override
	public boolean deleteBook(Book book) {

		boolean boo=admin.deleteBook(book);
		//boo为true时，删除成功
		return boo;
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

	//管理员登录
	@Override
	public boolean login(User user) {

		String aid=user.getUid();
		String pwd=user.getPwd();
		//如果用户登录时输入的账号密码不为空时，调用dao层登录接口查看数据库中账户密码是否正确
		if(!aid.equals(null)&&!pwd.equals(null)&&!aid.equals("")&&!pwd.equals("")) {
			boolean b=admin.login(user);
			//返回值为true或false,b为true时,登录成功
			return b;
		}
		//账号密码为空，直接返回false
		return false;
	}

	
	//添加管理员
	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return false;
	}


}
