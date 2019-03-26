package com.cduest.dao.impl;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cduest.dao.IUserLoginAndRegister;

import com.cduest.model.User;
import com.cduest.utils.JdbcUtil;

/**
 * �û���¼ע��jdbc
 * @author 1630720115
 *
 */
public class UserLoginAndRegisterJdbc implements IUserLoginAndRegister {

	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private JdbcUtil ju=new JdbcUtil();
	
	//��¼
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
				//������ݿ���uid��Ӧ���������û����������һ��ʱ����¼�ɹ�������true
				if(dataUid.equals(uid)&&dataPwd.equals(pwd)) {
					return true;
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				//����
				ju.close(con, ps, rs);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return false;
	}

	//ע��
	@Override
	public boolean register(User user) {
		
		String uid=user.getUid();
		String pwd=user.getPwd();
		con=ju.getConnection();
		String sql="INSERT INTO T_USER VALUES(?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, pwd);
			int i=ps.executeUpdate();
			if(i!=-1) {
				//ע��ɹ�������true
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

	//ע��ǰ�ж��˺��Ƿ����
	@Override
	public boolean registerJudge(User user) {
		
		String uid=user.getUid();
		con=ju.getConnection();
		String sql="SELECT UID FROM T_USER WHERE UID=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, uid);
			rs=ps.executeQuery();
			while(rs.next()) {
				String dataUid=rs.getNString("uid");
				if(dataUid.equals(uid)) {
					//���˺��Ѵ��� ����Ϊtrue 
					return true;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
