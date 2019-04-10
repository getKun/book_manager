package com.cduest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cduest.model.Book;
import com.cduest.service.IAdminService;
import com.cduest.service.impl.AdminSer;

/**
 * 管理员删除图书servlet
 * @author 1630720115
 *
 */
@WebServlet("/AdminDeleteBookServlet")
public class AdminDeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bid=request.getParameter("bid");
		Book book=new Book(bid, "", "");
		IAdminService delete=new AdminSer();
		//boo为true时，删除成功
		boolean boo=delete.deleteBook(book);
		if(boo) {
			request.setAttribute("point", "删除成功！");
			request.getRequestDispatcher("AdminQueryBookServlet").forward(request, response);
		}else {
			request.setAttribute("point", "删除失败(￣_￣|||)，请重试");
			request.getRequestDispatcher("AdminQueryBookServlet").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
