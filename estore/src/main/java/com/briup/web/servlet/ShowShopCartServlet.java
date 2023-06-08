package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.User;
import com.briup.service.impl.ShopCartItemServiceImpl;
import com.briup.vo.ShopItemInfo;

/**
 * 查看购物车功能
 */
@WebServlet("/user/ShowShopCartServlet")
public class ShowShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取当前登录的用户信息（登录者）
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		//2.根据用户id查询购物详情
		ShopCartItemServiceImpl shopCartItemServiceImpl = new ShopCartItemServiceImpl();
		List<ShopItemInfo> list = shopCartItemServiceImpl.listItemByUserId(user.getId());
		//3.存储到范围对象中
		session.setAttribute("shopItemInfos", list);
		//4.跳转到展示购物车的页面 user/shopCart.jsp
		response.sendRedirect("shopCart.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
