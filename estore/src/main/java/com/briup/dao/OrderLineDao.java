package com.briup.dao;

import java.util.List;

import com.briup.bean.Order;
import com.briup.bean.OrderLine;
import com.briup.vo.ShopItemInfo;

public interface OrderLineDao {
	/**
	 * 保存订单明细
	 * */
	public void saveOrder(OrderLine order);
	/**
	 * 根据提交的商品保存订单明细
	 * */
	public void saveOrder(List<ShopItemInfo> list,Order order);
	/**
	 * 根据ID删除订单明细
	 * */
	public void delOrder(Long orderid);

}