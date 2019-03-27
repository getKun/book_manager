package com.cduest.dao.impl;

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
 * 用户借书还书jdbc
 * @author 1630720115
 *
 */

public class UserBorrowBook implements IUserBorrowBook {

	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private JdbcUtil ju=new JdbcUtil();
	
	
	
	//借书
	/*
	 * 还缺少借书前判断书是否存在或借出的情况,预计在service层实现
	 * 或者只给用户查看可以借阅的图书，在用户点击查看所有图书之前
	 * 把已经在t_borrow中保存的图书剔除
	 * 
	 */
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
		
		return false;
	}

	//借书前判断书是否已借出
	@Override
	public boolean judgeBook(Book book) {

		String bid=book.getBid();
		con=ju.getConnection();
		String sql="SELECT UID FROM T_BORROW WHERE BID=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, bid);
			rs=ps.executeQuery();
			while(rs.next()) {
				//如果bid和uid同时存在，就证明书已被借出
				String dataUid=rs.getNString("uid");
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

}
