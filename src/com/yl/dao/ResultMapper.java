package com.yl.dao;

import java.sql.ResultSet;

/**
 * 将结果集的一行记录映射为一个实体
 * @author Mr.Yang
 * @param <E>
 *
 */
public interface ResultMapper<E> {
	E resultMapping(ResultSet rs);
}
