package com.cduest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cduest.model.Book;
import com.cduest.model.User;
import com.cduest.service.IUserService;
import com.cduest.service.impl.UserSer;

/**
 * 用户借书的servlet
 * @author 1630720115
 *
 */
@WebServlet("/BorrowBookServlet")
public class BorrowBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bid=request.getParameter("bid");
		User user=(User) request.getSession().getAttribute("user");
		Book book=new Book(bid, "", "");
		IUserService borrow=new UserSer();
		boolean boo=borrow.borrowBook(user, book);
		//boo为true时，借书成功，跳转成功页面
		if(boo) {
			request.getRequestDispatcher("borrow_success.jsp").forward(request, response);
		}else {
			//借书失败，跳转失败页面
			request.getRequestDispatcher("borrow_fail.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
