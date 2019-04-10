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
					<td>${book.author }</td>
					<td>${book.press }</td>
					<td>
						<form action="BorrowBookServlet?bid=${book.bid }" method="post">
							<input type="submit" value="借阅"
								style="border: 0px; background-color: transparent; font-size: medium;">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="jspFoot.jsp"%>
</body>
</html>