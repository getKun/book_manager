package com.cduest.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cduest.dao.IUser;
import com.cduest.model.User;
import com.cduest.utils.JdbcUtil;

/**
 * �û���¼ע��jdbc
 * @author 49520
 *
 */
public class UserJdbc implements IUser {

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
		
		return false;
	}

	@Override
	public boolean registerJudge(User user) {
		
		return false;
	}

}
