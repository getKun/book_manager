<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的主页</title>
</head>
<body>
	<%@include file="jspHead.jsp" %>

	<div>
		<h4>我已借阅的图书</h4>
		<table>
			<tr>
				<td>书名</td>
				<td>借书日期</td>
			</tr>
			<c:forEach items="${UserBorrowedBook }" var="book">
				<tr>
					<td>${book.bid }</td>
					<td>${book.date }</td>
					<td>
						<!-- 还书选项 -->
						<form action="QueryUserBorrowedBookServlet" method="post"
							onsubmit="return confirm('请把图书还回图书馆后由管理员确认还书');">
							<input type="submit" value="还书"
								style="border: 0px; background-color: transparent; font-size: medium;">

						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<%@include file="jspFoot.jsp" %>
</body>
</html>