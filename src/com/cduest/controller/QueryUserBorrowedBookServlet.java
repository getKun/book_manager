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
 * ��ѯĳ���û����ͼ���servlet
 * @author 1630720115
 *
 */
@WebServlet("/QueryUserBorrowedBookServlet")
public class QueryUserBorrowedBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ȡ���ڵ�¼servlet�д���session��user����
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
