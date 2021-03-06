package com.cduest.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cduest.service.IAdminService;
import com.cduest.service.impl.AdminSer;


/**
 * 管理员查询图书的servlet
 * @author 1630720115
 *
 */
@WebServlet("/AdminQueryBookServlet")
public class AdminQueryBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IAdminService admin=new AdminSer();
		ArrayList<Object> list=(ArrayList<Object>) admin.queryAllBook();
		request.setAttribute("allBook", list);
		request.getRequestDispatcher("all_book.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
