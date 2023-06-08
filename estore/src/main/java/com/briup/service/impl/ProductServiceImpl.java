package com.briup.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Product;
import com.briup.dao.ProductDao;
import com.briup.service.IProductService;
import com.briup.util.MybatisSqlSessionFactory;

public class ProductServiceImpl implements IProductService {
	private ProductDao productDao;
	private SqlSession sqlSession;
	{
		sqlSession = MybatisSqlSessionFactory.openSession();
		productDao = sqlSession.getMapper(ProductDao.class);
	}

	@Override
	public List<Product> listAllProduct() {
		return productDao.listAllProduct();
	}

	@Override
	public Product selectProductById(long productId) {
		return productDao.selectProductById(productId);
	}

	@Override
	public List<Product> listHostProducet() {
		return productDao.listAllProduct();
	}

	@Override
	public List<Product> listProductByCategoryId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listProductByCategoryDetailId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> listPublish() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCateInfoByProductId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listProductBykeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
