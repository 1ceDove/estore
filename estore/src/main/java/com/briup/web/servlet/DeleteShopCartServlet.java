package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.service.impl.ShopCartItemServiceImpl;

/**
 * 删除购物车功能
 */
@WebServlet("/user/DeleteShopCartServlet")
public class DeleteShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取购物车id
		String shopId = request.getParameter("shopId");
		//2.调用service,根据id删除购物车信息
		ShopCartItemServiceImpl shopCartItemServiceImpl = new ShopCartItemServiceImpl();
		shopCartItemServiceImpl.deleteShopCartItem(Long.parseLong(shopId));
		//3.跳转到查询购物车的Servlet
		response.sendRedirect("ShowShopCartServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
