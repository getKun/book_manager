<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员登录</title>
</head>
<body>
	<div>

		<h1>你好，管理员</h1>
		<form action="AdminLogin" method="post">
			账号<input type="text" name="aid"> <br>
			密码<input type="password" name="pwd"><br> 
			<input type="submit" value="登录">
		</form>

	</div>
	<%@ include file="jspFoot.jsp" %>
</body>
</html>