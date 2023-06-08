package com.briup.service;

import com.briup.bean.User;


public interface IUserService {
	/**
	 * 注册
	 * */
	public void registerUser(User user);
	/**
	 * 登陆
	 * */
	public  User loginUser(String name,String password);
	/**
	 * 用户名唯一验证
	 * */
	public  User getUserByName(String name);
	/**
	 * 修改用户信息
	 * */
	public void updateUserInfo(User user);
	
}