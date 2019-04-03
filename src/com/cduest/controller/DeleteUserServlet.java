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
 * 删除用户的servlet
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
			request.setAttribute("tips", "删除成功！");
			request.getRequestDispatcher("allUsers.jsp").forward(request, response);
		}else {
			request.setAttribute("tips", "删除失败，请重试");
			request.getRequestDispatcher("allUsers.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
