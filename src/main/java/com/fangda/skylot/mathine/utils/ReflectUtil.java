package com.fangda.skylot.mathine.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 反射工具类
 * @author rick.wang
 * @time 2015年6月4日 下午9:46:37
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class ReflectUtil {
	/**
	 * 获取泛型类型
	 * @param clazz
	 * @return
	 */
	public static Class getSuperClassGenricType(Class clazz){
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * 获取泛型类型
	 * @param clazz
	 * @param index
	 * @return
	 */
	public static Class getSuperClassGenricType(Class clazz, int index){
	    Type genType = clazz.getGenericSuperclass();
	    if (!(genType instanceof ParameterizedType)) {
	      return Object.class;
	    }
	    Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
	    if ((index >= params.length) || (index < 0)) {

	      return Object.class;
	    }
	    if (!(params[index] instanceof Class)) {
	      return Object.class;
	    }
	    return ((Class)params[index]);
	 }
	
	/**
	 * 获取注解
	 * @param obj
	 * @param annotationClass
	 * @return
	 */
	public static Annotation getAnnotation(Object obj ,Class annotationClass){
		return obj.getClass().getAnnotation(annotationClass);
	}
	
	/**
	 * 获取注解类型
	 * @param method
	 * @param annotationClass
	 * @return
	 */
	public static Annotation getAnnotation(Method method ,Class annotationClass){
		return method.getAnnotation(annotationClass);
	}
	
	/**
	 * 通过名称获取方法
	 * @param obj
	 * @param name
	 * @param types
	 * @return 返回方法，如果异常，返回空
	 */
	public static Method getMethodByName(Object obj,String name ,Class... types){
		try {
			return  obj.getClass().getMethod(name,types);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

}
