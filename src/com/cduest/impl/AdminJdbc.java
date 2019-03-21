package com.cduest.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cduest.dao.IAdministrators;
import com.cduest.model.Book;
import com.cduest.model.User;
import com.cduest.utils.JdbcUtil;

/**
 * ����Աjdbc
 * @author 1630720115
 *
 */
public class AdminJdbc implements IAdministrators{
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private JdbcUtil ju=new JdbcUtil();
	private List<Object> list=new ArrayList<Object>();

	
	//����Ա��¼
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
				//������ݿ���aid��Ӧ�����������Ա���������һ��ʱ����¼�ɹ�������true
				if(dataAid.equals(aid)&&dataPwd.equals(pwd)) {
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

	
	//��ӹ���Ա
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
				//����Ա��ӳɹ�������true
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

	
	//��ӹ���Աǰ�ж��Ƿ�������ͬ�Ĺ���Ա�˻�,������
	@Override
	public boolean registerJudge(User user) {
		
		return false;
	}

	
	//����Ա���ͼ��
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
				//ͼ����ӳɹ�������true
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

	//ɾ��ͼ��
	@Override
	public boolean deleteBook(Book book) {
		return false;
		
	}

	//ɾ���û�
	@Override
	public boolean deleteUser(User user) {
		return false;
		
	}

	//��ѯȫ���û�
	@Override
	public List<Object> queryAllUser() {
		
		con=ju.getConnection();
		String sql="SELECT UID,PWD FROM T_USER";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				//�Ѳ�ѯ��������ȡ������ŵ�user�����У��ٰ�user�������list����
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

	//��ѯȫ��ͼ��
	@Override
	public List<Object> queryAllBook() {
		return null;
	}



	
}
