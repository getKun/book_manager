<%@page import="java.util.ArrayList"%>
<%@page import="com.cduest.service.impl.AdminSer"%>
<%@page import="com.cduest.service.IAdminService"%>
<%@page import="com.cduest.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>全部用户</title>
</head>
<body>
	<%@ include file="jspHead.jsp" %>
	<h3>已注册的全部用户</h3>
	<div>
		<%	
			IAdminService admin=new AdminSer();
			ArrayList<Object> list=new ArrayList<Object>();
			list=(ArrayList<Object>) admin.queryAllUser();
		%>
		
		<table border="1">
			<tr>
				<th>账号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
				<th>密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			</tr>
			<%
				for(int i=0;i<list.size();i++){
					User user=(User)list.get(i);
			%>
			<tr>
				<td><%=user.getUid() %></td>
				<td><%=user.getPwd() %></td>
				<td><a href="DeleteUserServlet?uid=<%=user.getUid() %>" onclick="confirm('确定删除该用户?')">删除</a></td>
			</tr>
				<%	} %>
		</table>
	</div>
	<div>
		${tips }<br>
	</div>
	<%@ include file="jspFoot.jsp" %>
</body>
</html>