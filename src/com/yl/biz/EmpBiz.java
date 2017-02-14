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
}
