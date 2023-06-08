package com.briup.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Order;
import com.briup.bean.OrderLine;
import com.briup.bean.Product;
import com.briup.bean.User;
import com.briup.service.impl.OrderLineServiceImpl;
import com.briup.service.impl.OrderServiceImpl;
import com.briup.vo.ShopItemInfo;

/**
 * 提交订单功能
 */
@WebServlet("/user/ConfirmSubmitServlet")
public class ConfirmSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取收货人等信息
		String receiveName = request.getParameter("username");
		String receivePhone = request.getParameter("phone");
		String receiveAddress = request.getParameter("address");
		// 2.调用service层，将数据持久化到表中
		// 2.1 订单信息存储到订单表
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		Order order = new Order();
		// 订单编号
		UUID uuid = UUID.randomUUID();
		order.setOrderid(uuid.toString());
		// 订单状态(1表示支付 2表示未支付)
		order.setPaystatus(2);
		// 收货人姓名
		order.setReceivename(receiveName);
		// 收货人地址
		order.setReceiveaddress(receiveAddress);
		// 收货人电话
		order.setReceivephone(receivePhone);
		// 订单总价
		HttpSession session = request.getSession();
		double sum = (double) session.getAttribute("allPrices");
		order.setSum(sum);
		// 订单生成时间
		order.setDob(new Date());
		// 订单所属用户
		User user = (User) session.getAttribute("loginUser");
		order.setUser(user);
		orderServiceImpl.saveOrder(order);
		// 2.2 订单详情信息存储订单详情表
		OrderLineServiceImpl orderLineServiceImpl = new OrderLineServiceImpl();
		@SuppressWarnings("unchecked")
		List<ShopItemInfo> list = (List<ShopItemInfo>) session.getAttribute("confirms");
		for (ShopItemInfo info : list) {
			OrderLine orderLine = new OrderLine();
			orderLine.setNum(info.getNum());
			orderLine.setOrder(order);
			Product product = new Product();
			product.setId(info.getPid());
			orderLine.setProduct(product);
			orderLineServiceImpl.saveOrder(orderLine);
		}
		// 3.跳转到查看订单信息
		response.sendRedirect("ListConfirmListServlet");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
