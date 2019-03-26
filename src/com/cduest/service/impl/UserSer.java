package com.cduest.service.impl;

import com.cduest.dao.IUserLoginAndRegister;
import com.cduest.dao.impl.UserLoginAndRegisterJdbc;
import com.cduest.model.Book;
import com.cduest.model.User;
import com.cduest.service.IUserService;

/**
 * 用户service层实现类
 * @author 1630720115
 *
 */
public class UserSer implements IUserService{
	
	User user=new User();

	@Override
	public boolean login(User user) {

		String uid=user.getUid();
		String pwd=user.getPwd();
		//如果用户登录时输入的账号密码不为空时，调用dao层登录接口查看数据库中账户密码是否正确
		if(!uid.equals(null)&&!pwd.equals(null)) {
			IUserLoginAndRegister login=new UserLoginAndRegisterJdbc();
			boolean b=login.login(user);
			//返回值为true或false
			return b;
		}
		//账号密码为空，直接返回false
		return false;
	}

	@Override
	public boolean register(User user) {

		String uid=user.getUid();
		String pwd=user.getPwd();
		if(!uid.equals(null)&&!pwd.equals(null)) {
			//首先判断账号是否已被注册
			IUserLoginAndRegister ser=new UserLoginAndRegisterJdbc();
			boolean b=ser.registerJudge(user);
			//b为true时，账号已存在
			if(b) {
				return false;
			}else {
				//账号不存在时，执行注册流程
				boolean boo=ser.register(user);
				if(boo) {
					//注册成功
					return true;
				}
			}
			
		}
		return false;
	}

	
	//继承的判断账号是否存在的方法，现合并在注册service中
	@Override
	public boolean registerJudge(User user) {

		
		return false;
	}

	@Override
	public boolean borrowBook(User user, Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean returnBook(User user, Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean judgeBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

}
