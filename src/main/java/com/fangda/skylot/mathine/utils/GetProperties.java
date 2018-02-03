package com.fangda.skylot.mathine.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/***********************************************************************
 * Module: AppUtils.java <br>
 * Author: gs <br>
 * Create Time: 2015年6月25日 <br>
 * Update logs:<br>
 *             update by rick.wang at 2016/04/01
 * Purpose:
 * 
 ***********************************************************************/
public class GetProperties {

	/**
	 * 获取App相关参数的方法
	 * 
	 * @param key
	 * @return
	 */
	public static String getAppUtils(String key) {
		return getProperties("client/shiro-client-default.properties", key);
	}

	/**
	 * 读取配置文件的公用方法
	 * 
	 * @param path
	 *            路径地址
	 * @param key
	 *            需要读取参数的key值
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getProperties(String path, String key) {
		String value = null;
		InputStream ins = null;
		try {
			Class cls = GetProperties.class;
			ClassLoader loader = cls.getClassLoader();

			ins = loader.getResourceAsStream(path);
			Properties prop = new Properties();

			prop.load(ins);// 从流中获取数据
			value = prop.getProperty(key);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return value;
	}
}
