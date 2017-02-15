package com.yl.biz;

import com.yl.entity.Emp;
import com.yl.vo.EmpVo;

/**
 *ҵ���ӿ�
 * @author Mr.Yang
 *
 */
public interface EmpBiz extends BaseBiz<Emp, EmpVo>{
	/**
	 * ע���û�
	 * @param entity
	 * @return
	 */
	int register(Emp entity);
	
	/**
	 * ͨ��Ա��������ѯԱ����Ϣ
	 * @param empName
	 * @return
	 */
	Emp findByEmpName(String empName);
}
