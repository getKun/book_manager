package com.cduest.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cduest.model.User;
import com.cduest.service.IPublicQueryBookService;
import com.cduest.service.impl.PublicQueryBookSer;

/**
 * 查询某个用户借出图书的servlet
 * @author 1630720115
 *
 */
@WebServlet("/QueryUserBorrowedBookServlet")
public class QueryUserBorrowedBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//取出在登录servlet中存入session的user对象
		User user=(User) request.getSession().getAttribute("user");
		IPublicQueryBookService ser=new PublicQueryBookSer();
		ArrayList<Object> list=ser.queryUserBorrowedBook(user);
		request.setAttribute("UserBorrowedBook", list);
		request.getRequestDispatcher("personal.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
