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
 * ɾ���û���servlet
 * @author 1630720115
 *
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid=request.getParameter("uid");
		User user=new User(uid, "");
		IAdminService delete=new AdminSer();
		boolean boo=delete.deleteUser(user);
		if(boo) {
			request.setAttribute("tips", "ɾ���ɹ���");
			request.getRequestDispatcher("allUsers.jsp").forward(request, response);
		}else {
			request.setAttribute("tips", "ɾ��ʧ�ܣ�������");
			request.getRequestDispatcher("allUsers.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
