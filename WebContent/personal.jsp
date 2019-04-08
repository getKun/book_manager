<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的主页</title>
</head>
<body>
	<%@include file="jspHead.jsp" %>
	
		<div>
			<h4>我的个人信息</h4>
			账号：${sessionScope.user.uid }<br>
			密码：${sessionScope.user.pwd }<br>
		</div>
	
	<%@include file="jspFoot.jsp" %>
</body>
</html>