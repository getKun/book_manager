<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询用户</title>
</head>
<body>
	<%@ include file="admin_jsp_head.jsp" %>
	<h3>已注册的全部用户</h3>
	<div style="float: left;">
		<table>
			<tr>
				<td>用户名</td>
				<td>密码</td>
			</tr>
			<c:forEach items="${allUser }" var="user">
				<tr>
					<td>${user.uid }</td>
					<td>${user.pwd }</td>
					<td>
						<form action="DeleteUserServlet?uid=${user.uid }" method="post"
							onsubmit="return confirm('确定删除这个账号吗？');">
							<input type="submit" value="删除"
								style="border: 0px; background-color: transparent; font-size: medium;">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		${tips }
	</div>
	<div style="float: right;">
		<!-- 添加用户 -->
	</div><br>
	<%@ include file="jspFoot.jsp" %>
</body>
</html>