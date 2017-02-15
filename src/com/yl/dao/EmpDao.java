package com.yl.dao;

import com.yl.entity.Emp;
import com.yl.vo.EmpVo;

public interface EmpDao extends BaseDao<Emp, EmpVo>{
	/**
	 * 注册用户
	 * @param entity
	 * @return
	 */
	int register(Emp entity);
	
	/**
	 * 根据员工名字查询员工信息
	 * @param empName
	 * @return
	 */
	Emp findByEmpName(String empName);
}
