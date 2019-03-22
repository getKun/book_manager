package com.cduest.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cduest.dao.IUserBorrowBook;

import com.cduest.model.Book;
import com.cduest.model.User;
import com.cduest.utils.JdbcUtil;


/**
 * �û����黹��jdbc
 * @author 1630720115
 *
 */

public class UserBorrowBook implements IUserBorrowBook {

	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private JdbcUtil ju=new JdbcUtil();
	
	
	
	//����
	/*
	 * ��ȱ�ٽ���ǰ�ж����Ƿ���ڻ��������,Ԥ����service��ʵ��
	 * ����ֻ���û��鿴���Խ��ĵ�ͼ�飬���û�����鿴����ͼ��֮ǰ
	 * ���Ѿ���t_borrow�б����ͼ���޳�
	 * 
	 */
	@Override
	public boolean borrowBook(User user, Book book) {
		
		String uid=user.getUid();
		String bid=book.getBid();
		//��ȡ����ʱ��
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		String time=dateFormat.format(date);
		con=ju.getConnection();
		String sql="INSERT INTO T_BORROW VALUES(?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, bid);
			ps.setString(3, time);
			int i=ps.executeUpdate();
			if(i!=-1) {
				//����ɹ�������true
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean returnBook(User user, Book book) {
		
		return false;
	}

}
