package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.EmpSalBiz;
import com.yl.dao.EmpSalDao;
import com.yl.dao.impl.EmpSalDaoImpl;
import com.yl.entity.EmpSal;
import com.yl.vo.EmpSalVo;

public class EmpSalBizImpl implements EmpSalBiz {
	private EmpSalDao dao = new EmpSalDaoImpl();
	@Override
	public List<EmpSal> findAll(int currentPage, int pageSize, EmpSalVo vo) {
		return null;
	}

	@Override
	public EmpSal findById(Object id) {
		return dao.queryById(id);
	}

	@Override
	public int save(EmpSal entity) {
		return dao.save(entity);
	}

	@Override
	public int del(Object id) {
		return dao.del(id);
	}

	@Override
	public int update(EmpSal entity) {
		return dao.update(entity);
	}

	@Override
	public int getTotalPage(int pageSize, EmpSalVo vo) {
		return 0;
	}

}
