package com.briup.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.briup.bean.Order;
import com.briup.config.AlipayConfig;
import com.briup.service.impl.OrderServiceImpl;

/**
 * 订单结算功能
 */
@WebServlet("/user/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取订单编号 orderid
		String orderid = request.getParameter("orderid");
		request.getSession().setAttribute("orderid", orderid);
		//2.创建支付宝客户端
		AlipayClient client = AlipayConfig.getAlipayClient();
		//3.设置参数
		//创建支付宝请求对象
		AlipayTradePagePayRequest payRequest = new AlipayTradePagePayRequest();
		//创建支付宝请求模型对象
		AlipayTradePagePayModel model = new AlipayTradePagePayModel();
		//设置订单编号
		model.setOutTradeNo(orderid);
		//设置订单名称
		model.setSubject("书籍订单");
		//设置产品码
		model.setProductCode("FAST_INSTANT_TRADE_PAY");
		//设置订单内容
		model.setBody(System.currentTimeMillis()+"");
		//设置订单总价
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		Order order = orderServiceImpl.findOrderByOrderid(orderid);
		model.setTotalAmount(order.getSum()+"");
		//将请求模型对象设置给请求对象
		payRequest.setBizModel(model);
		//给请求对象设置回调地址
		payRequest.setReturnUrl(AlipayConfig.return_url);
		//4.发送请求，接收结果
		try {
			String body = client.pageExecute(payRequest).getBody();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(body);
			out.flush();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
