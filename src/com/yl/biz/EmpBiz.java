package com.yl.biz;

import com.yl.entity.Emp;
import com.yl.vo.EmpVo;

/**
 *业务层接口
 * @author Mr.Yang
 *
 */
public interface EmpBiz extends BaseBiz<Emp, EmpVo>{
	/**
	 * 注册用户
	 * @param entity
	 * @return
	 */
	int register(Emp entity);
	
	/**
	 * 通过员工姓名查询员工信息
	 * @param empName
	 * @return
	 */
	Emp findByEmpName(String empName);
}
