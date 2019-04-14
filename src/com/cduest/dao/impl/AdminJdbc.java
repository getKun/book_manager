package com.cduest.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cduest.dao.IAdministratorsDao;
import com.cduest.model.Book;
import com.cduest.model.User;
import com.cduest.utils.JdbcUtil;



/**
 * 管理员jdbc
 * @author 1630720115
 *
 */
public class AdminJdbc implements IAdministratorsDao{
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private JdbcUtil ju=new JdbcUtil();
	private ArrayList<Object> list=new ArrayList<Object>();

	
	//管理员登录
	@Override
	public boolean login(User user) {
		
		String aid=user.getUid();
		String pwd=user.getPwd();
		con=ju.getConnection();
		String sql="SELECT AID,PWD FROM T_ADMIN WHERE AID=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, aid);
			rs=ps.executeQuery();
			while(rs.next()) {
				String dataAid=rs.getNString("aid");
				String dataPwd=rs.getNString("pwd");
				//如果数据库中aid对应的密码与管理员输入的密码一致时，登录成功，返回true
				if(dataAid.equals(aid)&&dataPwd.equals(pwd)) {
					return true;
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				//关流
				ju.close(con, ps, rs);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return false;
	}

	
	//添加管理员
	@Override
	public boolean register(User user) {
		
		String aid=user.getUid();
		String pwd=user.getPwd();
		con=ju.getConnection();
		String sql="INSERT INTO T_ADMIN VALUES(?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, aid);
			ps.setString(2, pwd);
			int i=ps.executeUpdate();
			if(i!=-1) {
				//管理员添加成功，返回true
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
	
	//管理员添加图书
	@Override
	public boolean addBook(Book book) {
		
		String bid=book.getBid();
		String author=book.getAuthor();
		String press=book.getPress();
		con=ju.getConnection();
		String sql="INSERT INTO T_BOOK VALUES(?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, bid);
			ps.setString(2, author);
			ps.setString(3, press);
			int i=ps.executeUpdate();
			if(i!=-1) {
				//图书添加成功，返回true
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

	//删除图书
	@Override
	public boolean deleteBook(Book book) {
		
		String bid=book.getBid();
		con=ju.getConnection();
		String sql="DELETE FROM T_BOOK WHERE BID=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, bid);
			int i=ps.executeUpdate();
			if(i!=-1) {
				//删除成功，返回true
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
		
		//删除失败
		return false;
		
	}

	//删除用户
	@Override
	public boolean deleteUser(User user) {
		
		String uid=user.getUid();
		con=ju.getConnection();
		String sql="DELETE FROM T_USER WHERE UID=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, uid);
			int i=ps.executeUpdate();
			if(i!=-1) {
				//删除成功，返回true
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

	//查询全部用户
	@Override
	public List<Object> queryAllUser() {
		
		con=ju.getConnection();
		String sql="SELECT UID,PWD FROM T_USER";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				//把查询到的数据取出，存放到user对象中，再把user对象存入list对象
				String dataUid=rs.getNString("uid");
				String dataPwd=rs.getNString("pwd");
				User user=new User(dataUid, dataPwd);
				list.add(user);
				
			}
			return list;
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
		
		return null;
	}

	//查询全部图书
	@Override
	public List<Object> queryAllBook() {
		
		con=ju.getConnection();
		String sql="SELECT BID,AUTHOR,PRESS FROM T_BOOK";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				String dataBid=rs.getNString("bid");
				String dataAuthor=rs.getNString("author");
				String dataPress=rs.getNString("press");
				Book book=new Book(dataBid, dataAuthor, dataPress);
				list.add(book);
				
			}
			return list;
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
		
		return null;
	}



	
}
