package com.yl.dao;

import com.yl.entity.Emp;
import com.yl.vo.EmpVo;

public interface EmpDao extends BaseDao<Emp, EmpVo>{
	/**
	 * ×¢²áÓÃ»§
	 * @param entity
	 * @return
	 */
	int register(Emp entity);
}
