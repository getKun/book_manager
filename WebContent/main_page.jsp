<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书借阅平台</title>
</head>
<body>
	<%@ include file="jspHead.jsp"%>
	<div>
		<table>
			<tr>
				<td>书名</td>
				<td>作者</td>
				<td>出版社</td>
			</tr>
			<c:forEach items="${allBook }" var="book">
				<tr>
					<td>${book.bid }</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="jspFoot.jsp"%>
</body>
</html>