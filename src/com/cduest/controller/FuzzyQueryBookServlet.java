package com.cduest.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cduest.service.IFuzzyQueryService;
import com.cduest.service.impl.FuzzyQuerySer;

/**
 * 模糊查询图书的servlet
 * @author 1630720115
 *
 */
@WebServlet("/FuzzyQueryBookServlet")
public class FuzzyQueryBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//中文乱码处理
				request.setCharacterEncoding("UTF-8");
				String bid=request.getParameter("bid");
				IFuzzyQueryService ser=new FuzzyQuerySer();
				ArrayList<Object> list=ser.bookFuzzyQuery(bid);
				if(list==null||list.size()==0) {
					//没有查询到图书
					request.getRequestDispatcher("fuzzy_query_book_null.jsp").forward(request, response);
				}else {
					request.setAttribute("fuzzy_book", list);
					request.getRequestDispatcher("AdminQueryBookServlet").forward(request, response);
				}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
