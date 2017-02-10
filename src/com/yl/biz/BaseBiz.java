package com.yl.biz;

import java.util.List;
/**
 * �������ͽӿڣ���ҵ���ӿ�
 * @author Mr.Yang
 *
 * @param <E>
 * @param <T>
 */
public interface BaseBiz<E, T> {
	/**
	 * ��ѯָ��ҳ�ļ�¼
	 * @param currentPage ��ǰҳ
	 * @param pageSize ҳ��С
	 * @param vo ������Ϣ
	 * @return ʵ����󼯺� 
	 */
	List<E> findAll(int currentPage , int pageSize , T vo);
	
	/**
	 * ͨ����Ų�ѯ��¼
	 * @param id ��� 
	 * @return ʵ�����
	 */
	E findById(Object id);
	
	/**
	 * ��Ӽ�¼
	 * @param entity ʵ�����
	 * @return ��Ӱ�����
	 */
	int save(E entity);
	
	/**
	 * ɾ����¼
	 * @param id ���
	 * @return ��Ӱ�����
	 */
	int del(Object id);
	
	/**
	 * ���¼�¼
	 * @param entity
	 * @return ��Ӱ�����
	 */
	int update(E entity);
	
	/**
	 * ��ȡ��ҳ��
	 * @param vo ������Ϣ
	 * @return ��ҳ��
	 */
	int getTotalPage(int pageSize , T vo);
}
