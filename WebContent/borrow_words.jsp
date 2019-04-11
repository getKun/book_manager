<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书借阅系统</title>
</head>
<body>
	<%@ include file="jspHead.jsp" %>
	<div>
		${sessionScope.word }<br>
		<a href="QueryAllBookServlet">继续借书</a>
	</div>
	<%@ include file="jspFoot.jsp" %>
</body>
</html>