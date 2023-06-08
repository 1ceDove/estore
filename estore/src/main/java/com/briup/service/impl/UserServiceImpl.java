package com.briup.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.User;
import com.briup.dao.UserDao;
import com.briup.service.IUserService;
import com.briup.util.Md5Util;
import com.briup.util.MybatisSqlSessionFactory;

public class UserServiceImpl implements IUserService {
	private UserDao userDao;
	private SqlSession sqlSession;
	{
		sqlSession = MybatisSqlSessionFactory.openSession();
		userDao = sqlSession.getMapper(UserDao.class);
	}

	@Override
	public void registerUser(User user) {
		String username = user.getUsername();
		if (username != null && !"".equals(username)) {
			user.setPassword(Md5Util.md5(user.getPassword()));
			userDao.registerUser(user);
			sqlSession.commit();
		} else {
			throw new RuntimeException("用户名无效");
		}
	}

	@Override
	public User loginUser(String name, String password) {
		User user = null;
		user = userDao.loginUser(name, Md5Util.md5(password));
		if (user != null) {
			return user;
		} else {
			throw new RuntimeException("用户不存在");
		}
	}

	@Override
	public User getUserByName(String name) {
		if (name != null && !"".equals(name)) {
			User user = userDao.getUserByName(name);
			return user;
		} else {
			throw new RuntimeException("参数为空");
		}
	}

	@Override
	public void updateUserInfo(User user) {
		// TODO Auto-generated method stub

	}

}
