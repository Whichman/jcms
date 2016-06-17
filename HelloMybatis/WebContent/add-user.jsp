<%@page import="com.joshuait.entity.Users"%>
<%@page import="java.util.List"%>
<%@page import="com.joshuait.dao.UsersDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增用户</title>
</head>
<body>
	<form action="UserServlet" method="POST">
	<input type="text" name="action" value="adduser">
		登录名称。<input type = "text" name="userLogin">
		密码。 <input type = "password" name = "userPass">
		确认密码。 <input type = "password" name = "userPassConfirm">
		邮箱。 <input type = "text" name = "userEmail">
		<input type="submit" value="提交"> 
	</form>
</body>
</html>