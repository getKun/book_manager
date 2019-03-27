package com.cduest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cduest.dao.IUserLoginAndRegister;
import com.cduest.model.User;
import com.cduest.service.IUserService;
import com.cduest.service.impl.UserSer;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//中文乱码处理
		request.setCharacterEncoding("UTF-8");
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		User user=new User(uid, pwd);
		IUserService reg=new UserSer();
		boolean b=reg.register(user);
		if(b) {
			//注册成功,把user对象存入session
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			//跳转main_page
			request.getRequestDispatcher("main_page.jsp").forward(request, response);
			
		}else {
			//注册失败，刷新当前页面
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
