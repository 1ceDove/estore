package com.briup.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.ShopCartItem;
import com.briup.service.impl.ShopCartItemServiceImpl;

/**
 * 更新购物车功能
 */
@WebServlet("/user/UpdateShopCartServlet")
public class UpdateShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取购物车id和数量
		String shopId = request.getParameter("shopId");
		String num = request.getParameter("productNum");
		//2.调用service层，更新购物车
		ShopCartItemServiceImpl shopCartItemServiceImpl = new ShopCartItemServiceImpl();
		ShopCartItem sc = new ShopCartItem();
		sc.setId(Long.parseLong(shopId));
		sc.setNum(Integer.parseInt(num));
		shopCartItemServiceImpl.updateShopCartItem(sc);
		//3.写回响应
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("更新成功");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
