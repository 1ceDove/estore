package com.briup.dao;

import java.util.List;

import com.briup.bean.ShopCartItem;
import com.briup.vo.ShopItemInfo;

public interface ShopCartItemDao {
	
	/**
	 * 保存购物详情
	 */
	public void saveShopCartItem(ShopCartItem sc);
	
	/**
	 * 根据购物车详情id删除指定购物车详情
	 * @param id 购物车详情id
	 */
	public void deleteShopCartItem(long id);
	/**
	 * 更新购物车详情
	 * 只更新购物车中产品数量
	 */
	public void updateShopCartItem(ShopCartItem sc);
	/**
	 * 根据用户id查询所有的购物详情
	 * @param uid 用户id
	 * @return 购物详情展示信息
	 */
	public List<ShopItemInfo> listItemByUserId(long uid);

	public List<ShopItemInfo> listItemByIds(String ids);
	
	public ShopCartItem getShopCartItem(long id);
	
	/**
	 * 根据用户id以及商品id查询购物详情
	 * @param uid 用户id pid 商品id
	 * @return 购物详情展示信息
	 */
	public ShopCartItem ShopCartItemByUserIdAndProductId(long uid,long pid);
}
