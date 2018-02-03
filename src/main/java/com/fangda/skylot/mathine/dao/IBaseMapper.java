package com.fangda.skylot.mathine.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基础泛型,定义基本SQL操作
 * Created by Saul on 21/01/2017.
 *
 * @param <T,F> T 实体对象,F 查询条件对象
 */
@SuppressWarnings("MybatisMapperInXmlInspection")
public interface IBaseMapper<T, F> {

    /**
     * 基础统计数量
     *
     * @param example 具体对象
     * @return 返回数量,
     */
    int countByExample(F example);

    /**
     * 基础删除对象
     *
     * @param example 具体对象
     * @return 返回删除的条数
     */
    int deleteByExample(F example);

    /**
     * 依据对象的序号信息,删除对象
     *
     * @param id 对象的序号信息
     * @return 返回删除的条数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 基础的插入对象
     *
     * @param record 实体对象定义
     * @return 返回掺入的条数
     */
    int insert(T record);

    /**
     * 批量更新对象
     *
     * @param recordList
     * @return
     */
    int sqlBatchInsert(@Param("recordList") List<T> recordList);

    /**
     * 不插入空值的新增方法
     *
     * @param record 实体对象定义
     * @return 返回掺入的条数
     */
    int insertSelective(T record);

    /**
     * 基础的查询方法
     *
     * @param example 此处是查询条件,可以附加分页,结合countByExample一起使用
     * @return 列表对象
     */
    List<T> selectByExample(F example);

    /**
     * 依据对象的序号信息,获取当前对象
     *
     * @param cdId 序号信息
     * @return 当前对象
     */
    T selectByPrimaryKey(Integer cdId);

    /**
     * 依据对象的序号信息,获取当前对象
     *
     * @param cdId 序号信息
     * @return 当前对象
     */
    T selectByPrimaryKey(String cdId);

    /**
     * 依据对象主体,和查询信息,更新不为空的对象属性
     *
     * @param record  待更新的主体对象
     * @param example 查询信息
     * @return 更新的条数
     */
    int updateByExampleSelective(@Param("record") T record, @Param("example") F example);

    /**
     * 依据对象主体,和查询信息,所有的对象属性
     *
     * @param record  待更新的主体对象
     * @param example 查询信息
     * @return 更新的条数
     */
    int updateByExample(@Param("record") T record, @Param("example") F example);

    /**
     * 依据对象主体,和查询信息,所有的对象属性,更新大字段对象
     *
     * @param record  待更新的主体对象
     * @param example 查询信息
     * @return 更新的条数
     */
    @SuppressWarnings("unused")
    int updateByPrimaryKeyWithBLOBs(@Param("record") T record, @Param("example") F example);

    /**
     * 依据对象包含的序号信息,更新其他属性,只更新不为空的属性
     *
     * @param record 待更新的主体对象
     * @return 更新的条数
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 依据对象包含的序号信息,更新其他属性,更新所有的属性
     *
     * @param record 待更新的主体对象
     * @return 更新的条数
     */
    int updateByPrimaryKey(T record);

}
