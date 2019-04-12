<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div style="float: right;">
	<table>
		<tr>
			<td>管理员 <a href="QueryAllBorrowedBookServlet">${sessionScope.admin.uid }</a></td>
			<td><a href="admin_login.jsp">退出登录</a></td>
			<td>
				<form action="AdminQueryBookServlet" method="post">
					<input type="submit" value="查询图书"
						style="border: 0px; background-color: transparent; font-size: medium;">
				</form>
			</td>
			<td>
				<form action="AdminQueryUserServlet" method="post">
					<input type="submit" value="查询用户"
						style="border: 0px; background-color: transparent; font-size: medium;">
				</form>
		</tr>
	</table>
</div><br>
<hr />