package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.EmpWorkCaseBiz;
import com.yl.dao.EmpWorkCaseDao;
import com.yl.dao.impl.EmpWorkCaseDaoImpl;
import com.yl.entity.Emp;
import com.yl.vo.EmpWorkCaseVo;

public class EmpWorkCaseBizImpl implements EmpWorkCaseBiz {
	EmpWorkCaseDao dao = new EmpWorkCaseDaoImpl();
	@Override
	public List<Emp> findAll(int currentPage, int pageSize, EmpWorkCaseVo vo) {
		return dao.queryAll(currentPage, pageSize, vo);
	}

	@Override
	public Emp findById(Object id) {
		return dao.queryById(id);
	}

	@Override
	public int save(Emp entity) {
		return dao.save(entity);
	}

	@Override
	public int del(Object id) {
		return dao.del(id);
	}

	@Override
	public int update(Emp entity) {
		return dao.update(entity);
	}

	@Override
	public int getTotalPage(int pageSize, EmpWorkCaseVo vo) {
		return (dao.getCount(vo) - 1) / pageSize + 1;
	}

}
