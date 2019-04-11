<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员主页</title>
</head>
<body>
	<%@ include file="admin_jsp_head.jsp"%>
	<div>
		<h4>现在仍被借出的图书</h4>
		<table>
			<tr>
				<td>用户ID</td>
				<td>书名</td>
				<td>借出日期</td>
			</tr>
			<c:forEach items="${AllBorrowedBook }" var="msg">
				<tr>
					<td>${msg.uid }</td>
					<td>${msg.bid }</td>
					<td>${msg.date }</td>
					<td>
						<form action="">
							<!-- 还书选项 -->
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="jspFoot.jsp"%>
</body>
</html>