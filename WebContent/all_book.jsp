<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询图书</title>
</head>
<body style="background: #E6E6FA">
	<%@ include file="admin_jsp_head.jsp"%>
	<h3>收藏的全部图书</h3>
	<div style="float: left;">
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
						<form action="AdminDeleteBookServlet?bid=${book.bid }"
							method="post" onsubmit="return confirm('确定删除这本书吗？');">
							<input type="submit" value="删除"
								style="border: 0px; background-color: transparent; font-size: medium;">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	${point }
	<div style="float: right;">
		<h4>添加图书</h4>
		<form action="AdminAddBookServlet" method="post">
			<table>
				<tr>
					<td>书名</td>
					<td><input type="text" name="bid"></td>
				</tr>
				<tr>
					<td>作者</td>
					<td><input type="text" name="author"></td>
				</tr>
				<tr>
					<td>出版社</td>
					<td><input type="text" name="press"></td>
				</tr>
				<tr>
					<td>${add }</td>
					<td><input type="submit" value="添加"></td>
				</tr>
			</table>
		</form>
	</div><br>
	<div style="float: right;">
		<form action="FuzzyQueryBookServlet" method="post">
			查询图书<input type="text" name="bid">
			<input type="submit" value="查询">
		</form>
		<table>
			<tr>
				<td>书名</td>
				<td>作者</td>
				<td>出版社</td>
			</tr>
			<c:forEach items="${fuzzy_book }" var="b">
				<tr>
					<td>${b.bid }</td>
					<td>${b.author }</td>
					<td>${b.press }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<%@ include file="jspFoot.jsp"%>
</body>
</html>