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
	public int borrowBook(User user, Book book) {

		/*
		 * �������л�ʵ��dao��ӿڵ���������
		 * 1.�ж��û��Ƿ�����δ�黹��ͼ�飬ÿλ�û�����ֻ�ܽ�һ����
		 * 2.�ж��û�ԤԼ�����Ƿ��ѱ����
		 * 3.ִ��ԤԼ����
		 */
		IUserBorrowBookDao borrow = new UserBorrowBookJdbc();
		boolean boo=borrow.judgeUserBorrowedBook(user);
		if(boo) {
			//�û�����δ�黹
			return 0;
		}else {
			//�û�û��δ�黹���飬��ʼ�ж����Ƿ񱻽��
			boolean bo=borrow.judgeBook(book);
			if(bo) {
				//�鱻���������1
				return 1;
			}else {
				//��δ�������ִ�н�������
				boolean b=borrow.borrowBook(user, book);
				if(b) {
					//����ɹ�������2
					return 2;
				}else {
					//����ʧ��
					return 3;
				}
			}
			
		}
		
		
	}

	//����
	@Override
	public boolean returnBook(User user, Book book) {

		IUserBorrowBookDao dao=new UserBorrowBookJdbc();
		boolean boo=dao.returnBook(user, book);
		return boo;
	}
}
