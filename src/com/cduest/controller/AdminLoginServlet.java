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
 * 管理员登录servlet
 * @author 1630720115
 *
 */
@WebServlet("/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//中文乱码处理
		request.setCharacterEncoding("UTF-8");
		String aid=request.getParameter("aid");
		String pwd=request.getParameter("pwd");
		//因为管理员登录与用户登录使用的是同一个接口，所以这里新建user对象
		User user=new User(aid, pwd);
		IAdminService login=new AdminSer();
		boolean boo=login.login(user);
		if(boo) {
			//登录成功，跳转管理员主页
		}else {
			//登录失败，刷新当前页面
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
