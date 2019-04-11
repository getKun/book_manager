package com.cduest.service.impl;

import com.cduest.dao.IUserBorrowBookDao;
import com.cduest.dao.IUserLoginAndRegisterDao;
import com.cduest.dao.impl.UserBorrowBookJdbc;
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

	//�û���¼
	@Override
	public boolean login(User user) {

		String uid=user.getUid();
		String pwd=user.getPwd();
		//����û���¼ʱ������˺����벻Ϊ��ʱ������dao���¼�ӿڲ鿴���ݿ����˻������Ƿ���ȷ
		if(!uid.equals(null)&&!pwd.equals(null)&&!uid.equals("")&&!pwd.equals("")) {
			IUserLoginAndRegisterDao login=new UserLoginAndRegisterJdbc();
			boolean b=login.login(user);
			//����ֵΪtrue��false
			return b;
		}
		//�˺�����Ϊ�գ�ֱ�ӷ���false
		return false;
	}

	//�û�ע��
	@Override
	public boolean register(User user) {

		String uid=user.getUid();
		String pwd=user.getPwd();
		if(!uid.equals(null)&&!pwd.equals(null)&&!uid.equals("")&&!pwd.equals("")) {
			//�����ж��˺��Ƿ��ѱ�ע��
			IUserLoginAndRegisterDao ser=new UserLoginAndRegisterJdbc();
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
				}else {
					//ע��ʧ��
					return false;
				}
			}
			
		}
		return false;
	}

	//����
	@Override
	public boolean borrowBook(User user, Book book) {

		IUserBorrowBookDao borrow=new UserBorrowBookJdbc();
		boolean boo=borrow.judgeBook(book);
		//booΪtrueʱ�����ѱ����
		if(boo) {
			//���ѱ����������false
			return false;
		}else {
			//��δ���������ʼִ�н�������
			boolean b=borrow.borrowBook(user, book);
			//b��ֵΪtrue��false,bΪtrueʱ������ɹ�
			return b;
		}
		
	}

	//����
	@Override
	public boolean returnBook(User user, Book book) {
		// TODO Auto-generated method stub
		return false;
	}
}
