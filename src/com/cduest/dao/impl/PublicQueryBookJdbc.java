package com.cduest.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cduest.dao.IPublicQueryBookDao;
import com.cduest.model.Borrow;
import com.cduest.model.User;
import com.cduest.utils.JdbcUtil;

/**
 * ��ѯȫ���ѽ��ͼ���ĳ���û��ѽ��ͼ���jdbcʵ����
 * @author 1630720115
 * 
 *
 */
public class PublicQueryBookJdbc implements IPublicQueryBookDao {
	
	private JdbcUtil ju=new JdbcUtil();
	private ArrayList<Object> list=new ArrayList<Object>();
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	//��ѯȫ���ѽ����ͼ��
	@Override
	public ArrayList<Object> queryAllBorrowedBook() {
		
		con=ju.getConnection();
		String sql="SELECT * FROM T_BORROW";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				String uid=rs.getString("borrowUid");
				String bid=rs.getString("borrowBid");
				String date=rs.getString("borrowDate");
				Borrow borrow=new Borrow(uid, bid, date);
				list.add(borrow);
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

	//��ѯĳ���û������ͼ��
	@Override
	public ArrayList<Object> queryUserBorrowedBook(User user) {
		
		
		return null;
	}

}
