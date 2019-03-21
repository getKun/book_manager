package com.cduest.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cduest.dao.IAdministrators;
import com.cduest.model.Book;
import com.cduest.model.User;
import com.cduest.utils.JdbcUtil;

/**
 * 管理员jdbc
 * @author 1630720115
 *
 */
public class AdminJdbc implements IAdministrators{
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private JdbcUtil ju=new JdbcUtil();

	
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

	@Override
	public boolean registerJudge(User user) {
		
		return false;
	}

	@Override
	public boolean addBook(Book book) {
		return false;
		
	}

	@Override
	public boolean deleteBook(Book book) {
		return false;
		
	}

	@Override
	public boolean deleteUser(User user) {
		return false;
		
	}

	@Override
	public List<User> queryAllUser() {
		return null;
	}

	@Override
	public List<Book> queryAllBook() {
		return null;
	}



	
}
