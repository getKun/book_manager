package com.cduest.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cduest.dao.IUser;
import com.cduest.model.User;
import com.cduest.utils.JdbcUtil;

/**
 * 用户登录注册jdbc
 * @author 49520
 *
 */
public class UserJdbc implements IUser {

	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private JdbcUtil ju=new JdbcUtil();
	
	//登录
	@Override
	public boolean login(User user) {
		
		String uid=user.getUid();
		String pwd=user.getPwd();
		con=ju.getConnection();
		String sql="SELECT UID,PWD FROM T_USER WHERE UID=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, uid);
			rs=ps.executeQuery();
			while(rs.next()) {
				String dataUid=rs.getNString("uid");
				String dataPwd=rs.getNString("pwd");
				//如果数据库中uid对应的密码与用户输入的密码一致时，登录成功，返回true
				if(dataUid.equals(uid)&&dataPwd.equals(pwd)) {
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

	//注册
	@Override
	public boolean register(User user) {
		
		String uid=user.getUid();
		String pwd=user.getPwd();
		
		return false;
	}

	@Override
	public boolean registerJudge(User user) {
		
		return false;
	}

}
