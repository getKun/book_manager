<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div style="float: right;">
	<table>
		<tr>
			<td>你好，<a href="QueryUserBorrowedBookServlet">${sessionScope.user.uid }</a></td>
			<td><a href="QueryAllBookServlet">图书借阅平台</a></td>
			<td><a href="index.jsp">退出登录</a></td>
		</tr>
	</table>
</div>
<br>
<hr />