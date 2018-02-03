package com.fangda.skylot.mathine.service;


import com.fangda.skylot.mathine.utils.Page;

import java.util.List;

/**
 * Created by Saul on 22/01/2017.
 * 配置通用服务接口
 *
 * @param <T> 实体对象
 * @param <F> 查询对象
 */
@SuppressWarnings("unused")
public interface IBaseService<T, F> {

    /**
     * 保存对象
     *
     * @param t 实体对象
     * @return 保存的条数
     */
    int add(T t) throws Exception;

    /**
     * 依据查询对象,删除对象
     *
     * @param obj 查询对象
     * @return 受到删除影响的条数
     */
    int delete(F obj) throws Exception;

    /**
     * 更新对象的所有信息,
     *
     * @param t 实体对象
     * @return 受到影响的条数
     */
    int update(T t) throws Exception;

    /**
     * 更新对象,依据查询对象和实体对象,只更新不为空的字段
     *
     * @param t    实体对象
     * @param find 查找对象
     * @return 受到影响的条数
     */
    int update(T t, F find) throws Exception;

    /**
     * 查询单独对象,依据序号
     *
     * @param id 查询对象
     * @return 实体对象
     */
    T query(int id) throws Exception;

    /**
     * 查询单独对象,依据查询对象
     *
     * @param find 查询对象
     * @return 实体对象
     */
    T query(F find) throws Exception;

    /**
     * 查询所有对象,依据查询对象
     *
     * @param find 查询对象
     * @return List<T></>
     */
    List<T> queryForAll(F find) throws Exception;

    /**
     * 查询所有对象,且附加分页,依据查询对象
     *
     * @param find 查询对象
     * @param page 分页对象
     * @return 对象`集合
     */
    List<T> queryForAll(F find, Page page) throws Exception;
}
