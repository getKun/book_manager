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
 * ��ѯȫ��ͼ���servlet
 * @author 1630720115
 *
 */

@WebServlet("/QueryAllBookServlet")
public class QueryAllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IAdminService admin=new AdminSer();
		ArrayList<Object> all_book_list=new ArrayList<Object>();
		all_book_list=(ArrayList<Object>) admin.queryAllBook();
		//�Ѵ��book�����list�������session
		request.setAttribute("allBook", all_book_list);
		//��תmain_page
		request.getRequestDispatcher("/main_page.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
