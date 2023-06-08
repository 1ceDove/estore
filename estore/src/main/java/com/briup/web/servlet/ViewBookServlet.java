package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Product;
import com.briup.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ViewBookServlet
 */
@WebServlet("/ViewBookServlet")
public class ViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId = request.getParameter("productId");
		ProductServiceImpl productServiceImpl = new ProductServiceImpl();
		Product productInfo = productServiceImpl.selectProductById(Long.parseLong(productId));
		HttpSession session = request.getSession();
		if (session.getAttribute("productInfo") != null)
			session.removeAttribute("productInfo");
		session.setAttribute("productInfo", productInfo);
		response.sendRedirect("viewBook.jsp");
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
