package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.service.impl.OrderServiceImpl;

/**
 * 更新支付状态
 */
@WebServlet("/user/PaySuccessServlet")
public class PaySuccessServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取订单编号
		String orderid = (String) req.getSession().getAttribute("orderid");
		// 2.更新支付状态
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		orderServiceImpl.updateOrderStatus(orderid);
		// 3.跳转到user/confirmSuccess.jsp
		resp.sendRedirect("confirmSuccess.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
