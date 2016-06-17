package com.joshuait.web;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joshuait.dao.UsersDao;
import com.joshuait.entity.Users;

/**
 * Servlet implementation class UserService
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 读取页面传递过来的数据
		String userLogin = request.getParameter("userLogin");
		String userPass = request.getParameter("userPass");
		String userPassConfirm = request.getParameter("userPassConfirm");
		String userEmail = request.getParameter("userEmail");

		// 保存数据到数据库
		UsersDao userDao = new UsersDao();
		Users user = new Users();
		user.setUserLogin(userLogin);
		user.setUserPass(userPass);
		user.setUserEmail(userEmail);
		user.setUserRegistered(new Date());
		Random r = new Random();
		user.setUserActivationKey(r.nextLong() + "");
		user.setUserStatus(1);
		// 保存数据
		userDao.insert(user);
		// Ctrl + Shift + o 快速导包
		// 转发到index.jsp页面
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		request.setAttribute("msg", "用户注册成功");
		rd.forward(request, response);

		System.out.println(userLogin + "-" + userPass + "-" + userPassConfirm + "-" + userEmail);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
