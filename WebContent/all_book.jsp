<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询图书</title>
</head>
<body>
	<%@ include file="admin_jsp_head.jsp"%>
	<h3>收藏的全部图书</h3>
	<div style="float: left;">
		<table>
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
		<!-- 添加图书 -->
	</div><br>
	<%@ include file="jspFoot.jsp"%>
</body>
</html>