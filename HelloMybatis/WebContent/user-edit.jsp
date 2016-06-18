<%@page import="com.joshuait.entity.Users"%>
<%@page import="java.util.List"%>
<%@page import="com.joshuait.dao.UsersDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改用户</title>
</head>
<body>
	<%
		Users user = (Users)request.getAttribute("user");
	%>

	<form action="UserServlet" method="POST">
		<input type="text" name="action" value="update">
		<input type="text" name="id" value="<%=user.getId()%>">
		 登录名称：<input type="text" name="userLogin" value="<%=user.getUserLogin()%>">
		密码：<input type="password" name="userPass" value="<%=user.getUserPass()%>">
		<input type="submit" value=" 提 交 ">
	</form>
</body>
</html>