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
		int i=borrow.borrowBook(user, book);
		//boo为true时，借书成功，跳转成功页面
		if(i==0) {
			//页面对话,i=0时，用户还有尚未归还的图书，预约失败
			request.getSession().setAttribute("word", "预约失败，您还有尚未归还的图书！");
			request.getRequestDispatcher("borrow_words.jsp").forward(request, response);
		}else if(i==1){
			//借书失败，i=1时，书已被借出，预约失败
			request.getSession().setAttribute("word", "预约失败(っ °Д °;)っ，书已被借出！");
			request.getRequestDispatcher("borrow_words.jsp").forward(request, response);
		}else if(i==2) {
			//借书成功
			request.getSession().setAttribute("word", "预约成功，请凭您的ID,到图书馆借走您预约的图书");
			request.getRequestDispatcher("borrow_words.jsp").forward(request, response);
		}else if(i==3) {
			//系统错误，请重试
			request.getSession().setAttribute("word", "系统错误，请重试");
			request.getRequestDispatcher("borrow_words.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
