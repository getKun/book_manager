package com.cduest.service.impl;

import com.cduest.dao.IUserLoginAndRegister;
import com.cduest.dao.impl.UserLoginAndRegisterJdbc;
import com.cduest.model.Book;
import com.cduest.model.User;
import com.cduest.service.IUserService;

/**
 * �û�service��ʵ����
 * @author 1630720115
 *
 */
public class UserSer implements IUserService{
	
	User user=new User();

	@Override
	public boolean login(User user) {

		String uid=user.getUid();
		String pwd=user.getPwd();
		//����û���¼ʱ������˺����벻Ϊ��ʱ������dao���¼�ӿڲ鿴���ݿ����˻������Ƿ���ȷ
		if(!uid.equals(null)&&!pwd.equals(null)) {
			IUserLoginAndRegister login=new UserLoginAndRegisterJdbc();
			boolean b=login.login(user);
			//����ֵΪtrue��false
			return b;
		}
		//�˺�����Ϊ�գ�ֱ�ӷ���false
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

}
