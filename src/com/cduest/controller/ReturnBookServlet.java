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
 * 管理员确认用户还书的servlet
 * @author 1630720115
 *
 */
@WebServlet("/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//中文乱码处理
		request.setCharacterEncoding("UTF-8");
		String uid=request.getParameter("uid");
		String bid=request.getParameter("bid");
		System.out.println(uid+":"+bid);
		User user=new User(uid, "");
		Book book=new Book(bid, "", "");
		IUserService ser=new UserSer();
		boolean boo=ser.returnBook(user, book);
		if(boo) {
			request.setAttribute("ding", "还书成功！");
			request.getRequestDispatcher("return_book.jsp").forward(request, response);
		}else {
			request.setAttribute("ding", "还书失败！请重试，");
			request.getRequestDispatcher("return_book.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
