<%@page import="com.joshuait.entity.Users"%>
<%@page import="java.util.List"%>
<%@page import="com.joshuait.dao.UsersDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="add-user.jsp">注册用户</a>
	</div>
	<div style="color: blue">
		<%
			String msg = (String) request.getAttribute("msg");

			String userLogin = request.getParameter("userLogin");

			UsersDao userDao = new UsersDao();
			Users user = new Users();
			if (userLogin != null && !"".equals(userLogin.trim())) {
				user.setUserLogin(userLogin);
			}
			List<Users> usersList = userDao.Search(user);
		%>
		<%=msg%>
	</div>
	<div>
		<form action="index.jsp">
			登录名称：<input type="text" name="userLogin" value="<%=userLogin%>">
			<input type="submit" value="查询">
		</form>
	</div>
	<table>
		<tr>
			<td>#</td>
			<td>登录名称</td>
			<td>邮箱</td>
			<td>其他</td>
			<td>操作</td>
		</tr>
		<%
			for (Users u : usersList) {
		%>
		<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getUserLogin()%></td>
			<td><%=u.getUserEmail()%></td>
			<td><%=u.getUserStatus()%></td>
			<td>
				<a href="UserServlet?action=delete&id=<%=u.getId()%>">删除</a>
				<a href="user-edit.jsp?id=<%=u.getId()%>">编辑</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>