package com.yl.dao;

import com.yl.entity.Emp;
import com.yl.vo.EmpVo;

public interface EmpDao extends BaseDao<Emp, EmpVo>{
	/**
	 * ע���û�
	 * @param entity
	 * @return
	 */
	int register(Emp entity);
	
	/**
	 * ����Ա�����ֲ�ѯԱ����Ϣ
	 * @param empName
	 * @return
	 */
	Emp findByEmpName(String empName);
}
