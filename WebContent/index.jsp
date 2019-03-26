<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>请登录</title>
</head>
<body>
	
	<h1>登录</h1>
	<form action="LoginServlet" method="post">
		账号<input type="text" name="uid">
		<a href="#">没有账号？点我注册</a><br>
		密码<input type="password" name="pwd"><br>
		<input type="submit"  value="登录">
	</form>
	
	
</body>
</html>