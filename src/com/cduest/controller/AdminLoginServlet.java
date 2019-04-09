package com.cduest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cduest.model.User;
import com.cduest.service.IAdminService;
import com.cduest.service.impl.AdminSer;

/**
 * ����Ա��¼servlet
 * @author 1630720115
 *
 */
@WebServlet("/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//�������봦��
		request.setCharacterEncoding("UTF-8");
		String aid=request.getParameter("aid");
		String pwd=request.getParameter("pwd");
		//��Ϊ����Ա��¼���û���¼ʹ�õ���ͬһ���ӿڣ����������½�user����
		User user=new User(aid, pwd);
		IAdminService login=new AdminSer();
		boolean boo=login.login(user);
		if(boo) {
			//��¼�ɹ�����ת����Ա��ҳ
		}else {
			//��¼ʧ�ܣ�ˢ�µ�ǰҳ��
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
