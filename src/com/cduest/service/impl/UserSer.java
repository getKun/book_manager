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

		String uid=user.getUid();
		String pwd=user.getPwd();
		if(!uid.equals(null)&&!pwd.equals(null)) {
			//�����ж��˺��Ƿ��ѱ�ע��
			IUserLoginAndRegister ser=new UserLoginAndRegisterJdbc();
			boolean b=ser.registerJudge(user);
			//bΪtrueʱ���˺��Ѵ���
			if(b) {
				return false;
			}else {
				//�˺Ų�����ʱ��ִ��ע������
				boolean boo=ser.register(user);
				if(boo) {
					//ע��ɹ�
					return true;
				}
			}
			
		}
		return false;
	}

	
	//�̳е��ж��˺��Ƿ���ڵķ������ֺϲ���ע��service��
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
