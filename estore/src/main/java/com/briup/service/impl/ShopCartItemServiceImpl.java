package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.ShopCartItem;
import com.briup.dao.ShopCartItemDao;
import com.briup.service.IShopCartItemService;
import com.briup.util.MybatisSqlSessionFactory;
import com.briup.vo.ShopItemInfo;

public class ShopCartItemServiceImpl implements IShopCartItemService {
	private ShopCartItemDao shopCartItemDao;
	private SqlSession sqlSession;
	{
		sqlSession = MybatisSqlSessionFactory.openSession();
		shopCartItemDao = sqlSession.getMapper(ShopCartItemDao.class);
	}

	@Override
	public void saveShopCartItem(ShopCartItem sc) {
		shopCartItemDao.saveShopCartItem(sc);
		sqlSession.commit();
	}

	@Override
	public void deleteShopCartItem(long id) {
		shopCartItemDao.deleteShopCartItem(id);
		sqlSession.commit();
	}

	@Override
	public void updateShopCartItem(ShopCartItem sc) {
		shopCartItemDao.updateShopCartItem(sc);
		sqlSession.commit();
	}

	@Override
	public List<ShopItemInfo> listItemByUserId(long uid) {
		return shopCartItemDao.listItemByUserId(uid);
	}

	@Override
	public List<ShopItemInfo> listItemByIds(String ids) {
		return shopCartItemDao.listItemByIds(ids);
	}

	@Override
	public ShopCartItem getShopCartItem(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShopCartItem ShopCartItemByUserIdAndProductId(long uid, long pid) {
		return shopCartItemDao.ShopCartItemByUserIdAndProductId(uid, pid);
	}

}
