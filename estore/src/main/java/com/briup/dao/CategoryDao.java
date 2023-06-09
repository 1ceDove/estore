package com.briup.dao;

import java.util.List;

import com.briup.bean.Category;

/**
 * 一级菜单
 * */
public interface CategoryDao {

	/**
	 * 获取所有的一级菜单
	 * */
	public List<Category> listCategory();
	/**
	 * 保存一级菜单
	 * */
	public void saveCategory(Category category);
	/**
	 * 删除一级菜单
	 * */
	public void delCategory(Long categoryId);
}