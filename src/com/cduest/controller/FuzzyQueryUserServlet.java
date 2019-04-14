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
 * 模糊查询用户servlet
 * @author 1630720115
 *
 */
@WebServlet("/FuzzyQueryUserServlet")
public class FuzzyQueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//中文乱码处理
		request.setCharacterEncoding("UTF-8");
		String uid=request.getParameter("uid");
		IFuzzyQueryService ser=new FuzzyQuerySer();
		ArrayList<Object> list=ser.userFuzzyQuery(uid);
		if(list==null||list.size()==0) {
			//没有查询到用户
			request.getRequestDispatcher("fuzzy_query_user_null.jsp").forward(request, response);
		}else {
			request.setAttribute("fuzzy_user", list);
			request.getRequestDispatcher("AdminQueryUserServlet").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
