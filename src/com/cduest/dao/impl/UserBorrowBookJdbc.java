package com.cduest.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cduest.dao.IUserBorrowBookDao;

import com.cduest.model.Book;
import com.cduest.model.User;
import com.cduest.utils.JdbcUtil;



/**
 * �û����黹��jdbc
 * @author 1630720115
 *
 */

public class UserBorrowBookJdbc implements IUserBorrowBookDao {

	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private JdbcUtil ju=new JdbcUtil();
	
	
	
	//����
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

	//����
	@Override
	public boolean returnBook(User user, Book book) {
		
		String uid=user.getUid();
		String bid=book.getBid();
		con=ju.getConnection();
		String sql="DELETE FROM T_BORROW WHERE BORROWUID=? AND BORROWBID=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, bid);
			int i=ps.executeUpdate();
			if(i!=-1) {
				//����ɹ�
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ju.close(con, ps, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	//����ǰ�ж����Ƿ��ѽ��
	@Override
	public boolean judgeBook(Book book) {

		String bid=book.getBid();
		con=ju.getConnection();
		String sql="SELECT BORROWUID FROM T_BORROW WHERE BORROWBID=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, bid);
			rs=ps.executeQuery();
			while(rs.next()) {
				//���bid��uidͬʱ���ڣ���֤�����ѱ����
				String dataUid=rs.getNString("borrowUid");
				//uid��Ϊ�գ�˵�����ѱ����������true
				if(!dataUid.equals(null)) {
					return true;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ju.close(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��δ�����
		return false;
	}

	//�û�����ǰ�ж��Ƿ���δ�����飬ÿλ�û�����ֻ�ܽ�һ��
	@Override
	public boolean judgeUserBorrowedBook(User user) {

		
		return false;
	}

}
