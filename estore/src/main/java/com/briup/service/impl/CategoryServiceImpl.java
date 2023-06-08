package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Category;
import com.briup.dao.CategoryDao;
import com.briup.service.ICategoryService;
import com.briup.util.MybatisSqlSessionFactory;

public class CategoryServiceImpl implements ICategoryService{
	private CategoryDao categoryDao;
	private SqlSession sqlSession;
	{
		sqlSession = MybatisSqlSessionFactory.openSession();
		categoryDao = sqlSession.getMapper(CategoryDao.class);
	}
	

	@Override
	public List<Category> listCategory() {
		List<Category> list = categoryDao.listCategory();
		return list;
	}

	@Override
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delCategory(Long categoryId) {
		// TODO Auto-generated method stub
		
	}

}
