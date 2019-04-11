<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>请登录</title>
</head>
<body>

<!-- 当前页面仅用于测试登录注册功能，不代表最终样式 -->

<%@ include file="loginAndRegisterHead.jsp" %>
	
	<div>
	
		<h1>登录</h1>
		<form action="login" method="post">
			账号<input type="text" name="uid">
			<a href="register.jsp">没有账号？点我注册</a><br>
			密码<input type="password" name="pwd"><br>
			<input type="submit"  value="登录">
		</form>
		
	</div>

	<!-- 使用表单跳转管理员登录页面 -->
	<div style="float: right; position: absolute; bottom: 0px;">
	<hr />
		<form action="admin_login.jsp">
			<input type="submit" value="图书借阅平台"
				style="border: 0px; background-color: transparent; font-size: medium;">
			author:1630720115
		</form>
	</div>

</body>
</html>