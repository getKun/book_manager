package com.cduest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.cduest.model.User;
import com.cduest.service.IUserService;
import com.cduest.service.impl.UserSer;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//中文乱码处理
		request.setCharacterEncoding("UTF-8");
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		User user=new User(uid, pwd);
		IUserService login=new UserSer();
		boolean b=login.login(user);
		//b为true时，登录成功
		if(b) {
			//登陆成功，跳转QueryUserBorrowedBookServlet查询尚未归还的图书
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("QueryUserBorrowedBookServlet").forward(request, response);
			
		}else {
			//登录失败，刷新当前页面
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
