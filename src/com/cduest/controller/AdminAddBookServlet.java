package com.cduest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cduest.model.Book;
import com.cduest.service.impl.AdminSer;

/**
 * ����Ա���ͼ���servlet
 * @author 1630720115
 *
 */
@WebServlet("/AdminAddBookServlet")
public class AdminAddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//�������봦��
		request.setCharacterEncoding("UTF-8");
		String bid=request.getParameter("bid");
		String author=request.getParameter("author");
		String press=request.getParameter("press");
		Book book=new Book(bid, author, press);
		AdminSer add=new AdminSer();
		boolean boo=add.addBook(book);
		if(boo) {
			//��ӳɹ���
			request.setAttribute("add", "��ӳɹ���");
			request.getRequestDispatcher("AdminQueryBookServlet").forward(request, response);
		}else {}
			request.setAttribute("add", "���ʧ�ܣ����ݲ���Ϊ�գ�");
			request.getRequestDispatcher("AdminQueryBookServlet").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
