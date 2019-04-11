package com.cduest.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cduest.service.IPublicQueryBookService;
import com.cduest.service.impl.PublicQueryBookSer;


/**
 * 查询全部已借出图书的servlet
 * @author 1630720115
 *
 */
@WebServlet("/QueryAllBorrowedBookServlet")
public class QueryAllBorrowedBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IPublicQueryBookService ser=new PublicQueryBookSer();
		ArrayList<Object> list=ser.queryAllBorrowedBook();
		request.setAttribute("AllBorrowedBook", list);
		request.getRequestDispatcher("admin_personal.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
