package com.briup.service.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Category;
import com.briup.bean.CategoryDetail;
import com.briup.dao.CategoryDao;
import com.briup.dao.CategoryDetailDao;
import com.briup.service.ICategoryDetailService;
import com.briup.util.MybatisSqlSessionFactory;

public class CategoryDetailServiceImpl implements ICategoryDetailService{
	private CategoryDao categoryDao;
	private CategoryDetailDao categoryDetailDao;
	private SqlSession sqlSession;
	{
		sqlSession = MybatisSqlSessionFactory.openSession();
		categoryDao = sqlSession.getMapper(CategoryDao.class);
		categoryDetailDao = sqlSession.getMapper(CategoryDetailDao.class);
	}
	

	@Override
	public Map<Category, List<CategoryDetail>> listCategoryDetail() {
		//map集合key 一级分类  value 二级分类
		//1.创建map
		Map<Category,List<CategoryDetail>> map = new TreeMap<Category,List<CategoryDetail>>();
		//2.查询所有的一级分类
		List<Category> list = categoryDao.listCategory();
		for(Category c:list) {
			//3.根据一级分类id查询二级分类
			List<CategoryDetail> categoryDetailList = categoryDetailDao.getCategoryDetailsByCategoryId(c.getId());
			map.put(c, categoryDetailList);
		}
		return map;
	}

	@Override
	public List<CategoryDetail> getCategoryDetailsByCategoryId(long id) {
		List<CategoryDetail> list = categoryDetailDao.getCategoryDetailsByCategoryId(id);
		return list;
	}

	@Override
	public void saveCategoryDetail(CategoryDetail category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delCategoryDetail(Long categoryDetailId) {
		// TODO Auto-generated method stub
		
	}

}
