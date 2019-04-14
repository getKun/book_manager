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
 * 管理员添加图书的servlet
 * @author 1630720115
 *
 */
@WebServlet("/AdminAddBookServlet")
public class AdminAddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//中文乱码处理
		request.setCharacterEncoding("UTF-8");
		String bid=request.getParameter("bid");
		String author=request.getParameter("author");
		String press=request.getParameter("press");
		Book book=new Book(bid, author, press);
		AdminSer add=new AdminSer();
		boolean boo=add.addBook(book);
		if(boo) {
			//添加成功！
			request.setAttribute("add", "添加成功！");
			request.getRequestDispatcher("AdminQueryBookServlet").forward(request, response);
		}else {}
			request.setAttribute("add", "添加失败！内容不能为空！");
			request.getRequestDispatcher("AdminQueryBookServlet").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
