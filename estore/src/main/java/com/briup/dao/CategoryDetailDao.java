package com.briup.dao;

import java.util.List;

import com.briup.bean.CategoryDetail;

public interface CategoryDetailDao {

	/**
	 * 根据一级菜单的Id获取二级菜单
	 */
	public List<CategoryDetail> getCategoryDetailsByCategoryId(long id);

	/**
	 * 保存二级菜单
	 */
	public void saveCategoryDetail(CategoryDetail category);

	/**
	 * 删除二级菜单
	 */
	public void delCategoryDetail(Long categoryDetailId);

}