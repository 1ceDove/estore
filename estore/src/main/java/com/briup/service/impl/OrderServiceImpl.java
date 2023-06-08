package com.briup.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Order;
import com.briup.dao.OrderDao;
import com.briup.service.IOrderService;
import com.briup.util.MybatisSqlSessionFactory;
import com.briup.vo.OrderShopInfo;

public class OrderServiceImpl implements IOrderService {
	private OrderDao orderDao;
	private SqlSession sqlSession;
	{
		sqlSession = MybatisSqlSessionFactory.openSession();
		orderDao = sqlSession.getMapper(OrderDao.class);
	}

	@Override
	public void saveOrder(Order order) {
		orderDao.saveOrder(order);
		sqlSession.commit();
	}

	@Override
	public void updateOrderStatus(String orderid) {
		orderDao.updateOrderStatus(orderid);
		sqlSession.commit();
	}

	@Override
	public void delOrder(String orderid) {
		orderDao.delOrder(orderid);
		sqlSession.commit();
	}

	@Override
	public Map<String, List<OrderShopInfo>> listAllOrder(Long uid) {
		Map<String, List<OrderShopInfo>> map = new LinkedHashMap<>();
		// 1.根据用户id查询所有的订单、订单详情、商品
		List<OrderShopInfo> listAllOrder = orderDao.listAllOrder(uid);
		// 2.按照订单编号进行分组 001-牙刷 001-牙膏
		for (OrderShopInfo info : listAllOrder) {
			String orderid = info.getOrderid();
			if (map.containsKey(orderid)) {
				List<OrderShopInfo> list = map.get(orderid);
				list.add(info);
				map.put(orderid, list);
			} else {
				ArrayList<OrderShopInfo> list = new ArrayList<OrderShopInfo>();
				list.add(info);
				map.put(orderid, list);
			}
		}
		return map;
	}

	@Override
	public Order findOrderById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findOrderByOrderid(String orderid) {
		return orderDao.findOrderByOrderid(orderid);
	}

}
