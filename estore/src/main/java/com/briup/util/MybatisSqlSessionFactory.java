package com.briup.util;
/**
 * 基本封装
 * @author niurui
 *
 */

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	
	private static SqlSessionFactory getsqlSessionFactory() {
		if(sqlSessionFactory == null) {
			try {
				//1.读取配置文件mybatis-config.xml,获取字节输入流
				InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
				//2.创建sqlSessionFactory工厂对象
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		//3.返回sqlSessionFactory对象
		return  sqlSessionFactory;
	}
	
	public static SqlSession openSession() {
		return openSession(false);
	}
	
	public static SqlSession openSession(boolean autoCommit) {
		return getsqlSessionFactory().openSession(autoCommit);
	}
}
