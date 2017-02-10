package com.yl.biz;

import java.util.List;
/**
 * 创建泛型接口，简化业务层接口
 * @author Mr.Yang
 *
 * @param <E>
 * @param <T>
 */
public interface BaseBiz<E, T> {
	/**
	 * 查询指定页的记录
	 * @param currentPage 当前页
	 * @param pageSize 页大小
	 * @param vo 条件信息
	 * @return 实体对象集合 
	 */
	List<E> findAll(int currentPage , int pageSize , T vo);
	
	/**
	 * 通过编号查询记录
	 * @param id 编号 
	 * @return 实体对象
	 */
	E findById(Object id);
	
	/**
	 * 添加记录
	 * @param entity 实体对象
	 * @return 受影响的行
	 */
	int save(E entity);
	
	/**
	 * 删除记录
	 * @param id 编号
	 * @return 受影响的行
	 */
	int del(Object id);
	
	/**
	 * 更新记录
	 * @param entity
	 * @return 受影响的行
	 */
	int update(E entity);
	
	/**
	 * 获取总页数
	 * @param vo 条件信息
	 * @return 总页数
	 */
	int getTotalPage(int pageSize , T vo);
}
