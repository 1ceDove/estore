package com.briup.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.User;
import com.briup.service.impl.UserServiceImpl;

/**
 * 1.异步请求用户名唯一 2.密码加密 3.中文乱码
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @throws IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String zip = request.getParameter("zip");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		User user = new User();
		user.setUsername(name);
		user.setPassword(password);
		user.setZip(zip);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		user.setDob(new Date());
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3);
		String path = "";
		try {
			userServiceImpl.registerUser(user);
			session.setAttribute("msg", "注册成功");
			path = "login.jsp";
		} catch (Exception e) {
			session.setAttribute("msg", "注册失败");
			path = "register.jsp";
		}
		response.sendRedirect(path);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
