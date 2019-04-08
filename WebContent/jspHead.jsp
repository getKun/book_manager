<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div style="float: right;">
	<table>
		<tr>
			<td><form action="QueryAllBookServlet" method="post">
					<input type="submit" value="图书借阅平台"
						style="border: 0px; background-color: transparent; font-size: medium;">
				</form></td>
			<td>你好，<a href="personal.jsp">${sessionScope.user.uid }</a>
			</td>
			<td><a href="index.jsp">退出登录</a></td>
		</tr>
	</table>
</div>
<br>
<hr />