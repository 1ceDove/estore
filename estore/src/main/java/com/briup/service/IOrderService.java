package com.briup.service;

import java.util.List;
import java.util.Map;

import com.briup.bean.Order;
import com.briup.vo.OrderShopInfo;



public interface IOrderService {
	/**
	 * 保存订单
	 * */
	public void saveOrder(Order order);
	
	/**
	 * 更新订单状态为已支付
	 * @param orderid
	 */
	public void updateOrderStatus(String orderid);
	/**
	 * 根据订单编号删除订单
	 * */
	public void delOrder(String orderid);
	
	/**
	 * 查找用户所有订单
	 * */
	public Map<String,List<OrderShopInfo>> listAllOrder(Long uid);
	
	/**
	 * 根据主键id查找订单
	 * */
	public Order findOrderById(Long id);
	/**
	 * 根据订单编号查找订单
	 * */
	public Order findOrderByOrderid(String orderid);
}