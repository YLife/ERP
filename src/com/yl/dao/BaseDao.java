package com.yl.dao;

import java.util.List;

/**
 * 创建泛型接口 ， 简化dao层接口
 * @author Mr.Yang
 * @param <T>
 *
 */
public interface BaseDao<E, T> {
	/**
	 * 分页查询所有记录
	 * @param currentPage 当前页
	 * @param pageSize 页大小
	 * @param vo 条件信息
	 * @return 实体对象集合
	 */
	List<E> queryAll(int currentPage , int pageSize , T vo);
	
	/**
	 * 通过编号查询记录
	 * @param id 编号 
	 * @return 实体对象
	 */
	E queryById(Object id);
	
	/**
	 * 向数据库中添加一条记录
	 * @param entity 实体对象
	 * @return 受影响的行数
	 */
	int save(E entity);
	
	/**
	 * 删除一条记录
	 * @param id 编号
	 * @return 受影响的行数
	 */
	int del(Object id);
	
	/**
	 * 修改一条记录
	 * @param entity 实体对象
	 * @return  受影响的行数
	 */
	int update(E entity);
	
	/**
	 * 获取记录总条数
	 * @param vo 条件信息
	 * @return 总条数
	 */
	int getCount(T vo);
}
