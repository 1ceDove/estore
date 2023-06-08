package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Order;
import com.briup.bean.OrderLine;
import com.briup.dao.OrderLineDao;
import com.briup.service.IOrderLineService;
import com.briup.util.MybatisSqlSessionFactory;
import com.briup.vo.ShopItemInfo;

public class OrderLineServiceImpl implements IOrderLineService{
	private OrderLineDao orderLineDao;
	private SqlSession sqlSession;
	{
		sqlSession = MybatisSqlSessionFactory.openSession();
		orderLineDao = sqlSession.getMapper(OrderLineDao.class);
	}
	
	@Override
	public void saveOrder(OrderLine order) {
		orderLineDao.saveOrder(order);
		sqlSession.commit();
	}

	@Override
	public void saveOrder(List<ShopItemInfo> list, Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delOrder(Long orderid) {
		orderLineDao.delOrder(orderid);
		sqlSession.commit();
	}

}
