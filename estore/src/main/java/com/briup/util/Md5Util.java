package com.briup.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * .加密工具类
 * 
 * @author 刘斌
 *
 */
public class Md5Util {
	private static String slot = "briup";

	public static String md5(String password) {

		byte[] digest = null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(slot.getBytes());
		digest = md.digest(password.getBytes());
		return new BigInteger(1, digest).toString(16).toUpperCase();
	}
}
