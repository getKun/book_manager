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
		int i=borrow.borrowBook(user, book);
		//booΪtrueʱ������ɹ�����ת�ɹ�ҳ��
		if(i==0) {
			//ҳ��Ի�,i=0ʱ���û�������δ�黹��ͼ�飬ԤԼʧ��
			request.getSession().setAttribute("word", "ԤԼʧ�ܣ���������δ�黹��ͼ�飡");
			request.getRequestDispatcher("borrow_words.jsp").forward(request, response);
		}else if(i==1){
			//����ʧ�ܣ�i=1ʱ�����ѱ������ԤԼʧ��
			request.getSession().setAttribute("word", "ԤԼʧ��(�� �㧥 ��;)�ã����ѱ������");
			request.getRequestDispatcher("borrow_words.jsp").forward(request, response);
		}else if(i==2) {
			//����ɹ�
			request.getSession().setAttribute("word", "ԤԼ�ɹ�����ƾ����ID,��ͼ��ݽ�����ԤԼ��ͼ��");
			request.getRequestDispatcher("borrow_words.jsp").forward(request, response);
		}else if(i==3) {
			//ϵͳ����������
			request.getSession().setAttribute("word", "ϵͳ����������");
			request.getRequestDispatcher("borrow_words.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
