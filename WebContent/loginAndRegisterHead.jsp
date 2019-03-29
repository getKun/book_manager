<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h4>你好，欢迎 &nbsp;&nbsp;&nbsp;
<% Date d=new Date();
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
		String now=date.format(d);
%> 
当前时间：<%=now%></h4> 
<hr />