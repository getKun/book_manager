package com.cduest.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.cduest.dao.IAdministratorsDao;
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
	
	private IAdministratorsDao admin=new AdminJdbc();

	//���ͼ��
	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	//ɾ��ͼ��
	@Override
	public boolean deleteBook(Book book) {

		boolean boo=admin.deleteBook(book);
		//booΪtrueʱ��ɾ���ɹ�
		return boo;
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

	//����Ա��¼
	@Override
	public boolean login(User user) {

		String aid=user.getUid();
		String pwd=user.getPwd();
		//����û���¼ʱ������˺����벻Ϊ��ʱ������dao���¼�ӿڲ鿴���ݿ����˻������Ƿ���ȷ
		if(!aid.equals(null)&&!pwd.equals(null)&&!aid.equals("")&&!pwd.equals("")) {
			boolean b=admin.login(user);
			//����ֵΪtrue��false,bΪtrueʱ,��¼�ɹ�
			return b;
		}
		//�˺�����Ϊ�գ�ֱ�ӷ���false
		return false;
	}

	
	//��ӹ���Ա
	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return false;
	}


}
