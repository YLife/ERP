package com.yl.dao;

import java.util.List;

/**
 * �������ͽӿ� �� ��dao��ӿ�
 * @author Mr.Yang
 * @param <T>
 *
 */
public interface BaseDao<E, T> {
	/**
	 * ��ҳ��ѯ���м�¼
	 * @param currentPage ��ǰҳ
	 * @param pageSize ҳ��С
	 * @param vo ������Ϣ
	 * @return ʵ����󼯺�
	 */
	List<E> queryAll(int currentPage , int pageSize , T vo);
	
	/**
	 * ͨ����Ų�ѯ��¼
	 * @param id ��� 
	 * @return ʵ�����
	 */
	E queryById(Object id);
	
	/**
	 * �����ݿ������һ����¼
	 * @param entity ʵ�����
	 * @return ��Ӱ�������
	 */
	int save(E entity);
	
	/**
	 * ɾ��һ����¼
	 * @param id ���
	 * @return ��Ӱ�������
	 */
	int del(Object id);
	
	/**
	 * �޸�һ����¼
	 * @param entity ʵ�����
	 * @return  ��Ӱ�������
	 */
	int update(E entity);
	
	/**
	 * ��ȡ��¼������
	 * @param vo ������Ϣ
	 * @return ������
	 */
	int getCount(T vo);
}
