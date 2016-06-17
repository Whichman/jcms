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
		String action = request.getParameter("action");
		if ("adduser".equals(action)) {
			addUser(request, response);
		}else if ("delete".equals(action)) {
			deleteUser(request, response);
		}if ("update".equals(action)) {
			updateUser(request, response);
		}
	
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡҳ�洫�ݹ���������
		String userLogin = request.getParameter("userLogin");
		String userPass = request.getParameter("userPass");
		String userPassConfirm = request.getParameter("userPassConfirm");
		String userEmail = request.getParameter("userEmail");

		// �������ݵ����ݿ�
		UsersDao userDao = new UsersDao();
		Users user = new Users();
		user.setUserLogin(userLogin);
		user.setUserPass(userPass);
		user.setUserEmail(userEmail);
		user.setUserRegistered(new Date());
		Random r = new Random();
		user.setUserActivationKey(r.nextLong() + "");
		user.setUserStatus(1);
		// ��������
		userDao.insert(user);
		// Ctrl + Shift + o ���ٵ���
		// ת����index.jspҳ��
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		request.setAttribute("msg", "�û�ע��ɹ�");
		rd.forward(request, response);

		System.out.println(userLogin + "-" + userPass + "-" + userPassConfirm + "-" + userEmail);
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡҳ�洫�ݹ���������
		String id = request.getParameter("id");

		// �������ݵ����ݿ�
		UsersDao userDao = new UsersDao();
		
		// ɾ������
		userDao.delete(Integer.parseInt(id));
		// Ctrl + Shift + o ���ٵ���
		// ת����index.jspҳ��
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		request.setAttribute("msg", "�û�ע��ɹ�");
		rd.forward(request, response);

		System.out.println(id);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡҳ�洫�ݹ���������
		String id = request.getParameter("id");
		String userLogin = request.getParameter("userLogin");
		String userPass = request.getParameter("userPass");
		String userPassConfirm = request.getParameter("userPassConfirm");
		String userEmail = request.getParameter("userEmail");

		// �������ݵ����ݿ�
		UsersDao userDao = new UsersDao();
		Users user = new Users();
		user.setId(Integer.parseInt(id));
		user.setUserLogin(userLogin);
		user.setUserPass(userPass);
		user.setUserEmail(userEmail);
		// ��������
		userDao.update(user);
		// Ctrl + Shift + o ���ٵ���
		// ת����index.jspҳ��
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		request.setAttribute("msg", "�û�ע��ɹ�");
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