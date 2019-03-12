package com.cduest.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbc������
 * @author 49520
 *
 */
public class JdbcUtil {
	
	//��������
	static {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��ȡ����
	public  Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mall", "root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	//�ر���Դ
	public  void close(Connection con,PreparedStatement ps,ResultSet rs) throws SQLException {
		
		if(rs!=null) {
			rs.close();
		}
		if(ps!=null) {
			ps.close();
		}
		if(con!=null) {
			con.close();
		}
	}
}



