package com.briup.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Product;
import com.briup.bean.ShopCartItem;
import com.briup.bean.User;
import com.briup.service.impl.ShopCartItemServiceImpl;

/**
 * 商品加购功能
 */
@WebServlet("/user/AddShopCartServlet")
public class AddShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取当前用户，加购商品id,加购数量
		String productId = request.getParameter("productId");
		String productNum = request.getParameter("productNum");
		User user = (User) request.getSession().getAttribute("loginUser");
		//2.判断当前用户是否已经加购过该商品
		ShopCartItemServiceImpl shopCartItemServiceImpl = new ShopCartItemServiceImpl();
		ShopCartItem sc = shopCartItemServiceImpl.ShopCartItemByUserIdAndProductId(user.getId(), Long.parseLong(productId));
		if(sc != null) {
			//2.1 如果加购过，更新商品数量
			int totalNum = sc.getNum()+Integer.parseInt(productNum);
			sc.setNum(totalNum);
			shopCartItemServiceImpl.updateShopCartItem(sc);
		}else {
			//2.2 如果未加购过，保存加购信息
			sc = new ShopCartItem();
			sc.setNum(Integer.parseInt(productNum));
			sc.setUser(user);
			Product product = new Product();
			product.setId(Long.parseLong(productId));
			sc.setProduct(product);
			shopCartItemServiceImpl.saveShopCartItem(sc);
		}
		//3.返回响应 加购成功
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("加购成功");
		out.flush();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
