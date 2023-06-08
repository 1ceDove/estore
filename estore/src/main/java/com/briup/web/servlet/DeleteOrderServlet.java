package com.briup.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Order;
import com.briup.service.impl.OrderLineServiceImpl;
import com.briup.service.impl.OrderServiceImpl;

/**
 * 删除订单功能
 */
@WebServlet("/user/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取请求参数 订单编号orderid
		String orderid = request.getParameter("orderid");
		//2.根据订单编号删除订单信息
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		Order order = orderServiceImpl.findOrderByOrderid(orderid);
		orderServiceImpl.delOrder(orderid);
		//3.根据订单id删除订单详情信息
		OrderLineServiceImpl orderLineServiceImpl = new OrderLineServiceImpl();
		orderLineServiceImpl.delOrder(order.getId());
		//4.返回响应
		response.setContentType("text/plain;charse=utf-8");
		PrintWriter out = response.getWriter();
		out.println("删除成功");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
