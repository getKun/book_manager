package com.cduest.service.impl;

import com.cduest.dao.IUserBorrowBookDao;
import com.cduest.dao.IUserLoginAndRegisterDao;
import com.cduest.dao.impl.UserBorrowBookJdbc;
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

	//用户登录
	@Override
	public boolean login(User user) {

		String uid=user.getUid();
		String pwd=user.getPwd();
		//如果用户登录时输入的账号密码不为空时，调用dao层登录接口查看数据库中账户密码是否正确
		if(!uid.equals(null)&&!pwd.equals(null)&&!uid.equals("")&&!pwd.equals("")) {
			IUserLoginAndRegisterDao login=new UserLoginAndRegisterJdbc();
			boolean b=login.login(user);
			//返回值为true或false
			return b;
		}
		//账号密码为空，直接返回false
		return false;
	}

	//用户注册
	@Override
	public boolean register(User user) {

		String uid=user.getUid();
		String pwd=user.getPwd();
		if(!uid.equals(null)&&!pwd.equals(null)&&!uid.equals("")&&!pwd.equals("")) {
			//首先判断账号是否已被注册
			IUserLoginAndRegisterDao ser=new UserLoginAndRegisterJdbc();
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
				}else {
					//注册失败
					return false;
				}
			}
			
		}
		return false;
	}

	//借书
	@Override
	public boolean borrowBook(User user, Book book) {

		IUserBorrowBookDao borrow=new UserBorrowBookJdbc();
		boolean boo=borrow.judgeBook(book);
		//boo为true时，书已被借出
		if(boo) {
			//书已被借出，返回false
			return false;
		}else {
			//书未被借出，开始执行借书流程
			boolean b=borrow.borrowBook(user, book);
			//b的值为true或false,b为true时，借书成功
			return b;
		}
		
	}

	//还书
	@Override
	public boolean returnBook(User user, Book book) {
		// TODO Auto-generated method stub
		return false;
	}
}
