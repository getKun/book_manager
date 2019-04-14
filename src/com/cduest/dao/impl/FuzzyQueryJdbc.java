package com.cduest.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cduest.dao.IFuzzyQueryDao;
import com.cduest.model.Book;
import com.cduest.model.User;
import com.cduest.utils.JdbcUtil;

/**
 * 模糊查询的jdbc实现类
 * @author 49520
 *
 */
public class FuzzyQueryJdbc implements IFuzzyQueryDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private JdbcUtil ju=new JdbcUtil();
	private ArrayList<Object> list=new ArrayList<Object>();
	
	//模糊查询用户
	@Override
	public ArrayList<Object> userFuzzyQuery(String uid) {
		
		con=ju.getConnection();
		String sql="SELECT * FROM T_USER WHERE UID LIKE ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+uid+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				String dataUid=rs.getString("uid");
				String dataPwd=rs.getString("pwd");
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

	//模糊查询图书
	@Override
	public ArrayList<Object> bookFuzzyQuery(String bid) {
		
		con=ju.getConnection();
		String sql="SELECT * FROM T_BOOK WHERE BID LIKE ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+bid+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				String dataBid=rs.getString("bid");
				String dataAuthor=rs.getString("author");
				String dataPress=rs.getString("press");
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
