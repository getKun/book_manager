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
 * �û������servlet
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
		//booΪtrueʱ������ɹ�����ת�ɹ�ҳ��
		if(boo) {
			//ҳ��Ի�
			request.getSession().setAttribute("word", "ԤԼ�ɹ�����ƾ����ID��24Сʱ�ڵ�ͼ��ݽ�������ͼ��");
			request.getRequestDispatcher("borrow_words.jsp").forward(request, response);
		}else {
			//����ʧ�ܣ���תʧ��ҳ��
			request.getSession().setAttribute("word", "ԤԼʧ��(�� �㧥 ��;)�ã����ѱ������������ԭ��������");
			request.getRequestDispatcher("borrow_words.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
