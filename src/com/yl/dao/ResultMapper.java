package com.yl.dao;

import java.sql.ResultSet;

/**
 * ���������һ�м�¼ӳ��Ϊһ��ʵ��
 * @author Mr.Yang
 * @param <E>
 *
 */
public interface ResultMapper<E> {
	E resultMapping(ResultSet rs);
}
