package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.User;
import com.briup.service.impl.OrderServiceImpl;
import com.briup.vo.OrderShopInfo;

/**
 * 展示订单功能
 */
@WebServlet("/user/ListConfirmListServlet")
public class ListConfirmListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取当前用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		//2.调用service层，查看当前用户的订单信息/订单详情/商品信息
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		Map<String, List<OrderShopInfo>> map = orderServiceImpl.listAllOrder(user.getId());
		//3.存储到范围对象中
		session.setAttribute("orders", map);
		//4.跳转到页面 user/confirmList.jsp
		response.sendRedirect("confirmList.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
