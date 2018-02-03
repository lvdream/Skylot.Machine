/***********************************************************************
 * Module：SingletonObjectMapper.java
 * Author：rick.wang
 * Create Time:2015年4月17日 下午7:19:25
 * Update logs:
 *             comments:
 * Purpose:Defines the SingletonObjectMapper 
 ***********************************************************************/
package com.fangda.skylot.mathine.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ObjectMapper的单例类
 * @author rick.wang
 * @time 2015年4月17日 下午7:19:25
 */
public class SingletonObjectMapper {

	private static class SingletonHolder {
		private static final ObjectMapper INSTANCE = new ObjectMapper();
	}
	
	private SingletonObjectMapper() {
		
	}
	
	public static final ObjectMapper getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
