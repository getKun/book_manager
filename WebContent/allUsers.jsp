<%@page import="java.util.ArrayList"%>
<%@page import="com.cduest.service.impl.AdminSer"%>
<%@page import="com.cduest.service.IAdminService"%>
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
		<%=list %>
	</div>
	
	<div style="float: left;">
		<a href="#">新增用户</a>
	</div>
	<div style="float: left; margin-left: 5px;">
		<a href="#">删除用户</a>
	</div>
	<%@ include file="jspFoot.jsp" %>
</body>
</html>