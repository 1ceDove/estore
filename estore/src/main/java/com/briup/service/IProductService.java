package com.briup.service;

import java.util.List;
import java.util.Set;

import com.briup.bean.Product;


public interface IProductService {
	/**
	 * 获取所有商品
	 * */
	public List<Product> listAllProduct();
	/**
	 * 根据商品ID获取商品
	 * */
	public Product selectProductById(long productId);
	/**
	 * 获取热卖商品
	 * */
	public List<Product> listHostProducet();
	
	/**
	 * 根据一级菜单ID获取商品
	 * */
	public List<Product> listProductByCategoryId(long id);
	/**
	 * 根据二级菜单ID获取商品
	 * */
	public List<Product> listProductByCategoryDetailId(long id);
	/**
	 * 获取出版社信息
	 * */
	public Set<String> listPublish();
	/**
	 * 根据商品ID获取商品信息
	 * */
	public Product getProductById(long id);
	/**
	 * 根据商品ID获取类别信息
	 * */
	public List<String> getCateInfoByProductId(long id);
	/**
	 * 根据商品名字keyword获取商品信息
	 * */
	public List<Product> listProductBykeyword(String keyword);
}