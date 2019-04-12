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
 * 用户借书还书jdbc
 * @author 1630720115
 *
 */

public class UserBorrowBookJdbc implements IUserBorrowBookDao {

	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private JdbcUtil ju=new JdbcUtil();
	
	
	
	//借书
	@Override
	public boolean borrowBook(User user, Book book) {
		
		String uid=user.getUid();
		String bid=book.getBid();
		//获取借书时间
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
				//借书成功，返回true
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//还书
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
				//还书成功
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

	//借书前判断书是否已借出
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
				//如果bid和uid同时存在，就证明书已被借出
				String dataUid=rs.getNString("borrowUid");
				//uid不为空，说明书已被借出，返回true
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
		//书未被借出
		return false;
	}

	//用户借书前判断是否有未还的书，每位用户至多只能借一本
	@Override
	public boolean judgeUserBorrowedBook(User user) {

		
		return false;
	}

}
