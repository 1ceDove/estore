package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.service.impl.ShopCartItemServiceImpl;
import com.briup.vo.ShopItemInfo;

/**
 * 确认订单功能
 */
@WebServlet("/user/ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取购物项ids  1,2
		String ids = request.getParameter("shopInfoId");
		//2.调用service,根据购物项id查询购物项以及商品信息
		ShopCartItemServiceImpl shopCartItemServiceImpl = new ShopCartItemServiceImpl();
		List<ShopItemInfo> list = shopCartItemServiceImpl.listItemByIds(ids);
		//3.计算总价
		double total = 0.0;
		for(ShopItemInfo info:list) {
			total += info.getNum()*info.getPrice();
		}
		//4.存储到范围对象中
		HttpSession session = request.getSession();
		session.setAttribute("confirms", list);
		session.setAttribute("allPrices", total);
		//5.跳转到user/confirm.jsp
		response.sendRedirect("confirm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
