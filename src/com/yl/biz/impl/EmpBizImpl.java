package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.EmpBiz;
import com.yl.dao.EmpDao;
import com.yl.dao.impl.EmpDaoImpl;
import com.yl.entity.Emp;
import com.yl.vo.EmpVo;

public class EmpBizImpl implements EmpBiz {
	private EmpDao dao = new EmpDaoImpl();
	@Override
	public List<Emp> findAll(int currentPage, int pageSize, EmpVo vo) {
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
	public int getTotalPage(int pageSize, EmpVo vo) {
		return (dao.getCount(vo) - 1) / pageSize + 1;
	}

	@Override
	public int register(Emp entity) {
		return dao.register(entity);
	}

	@Override
	public Emp findByEmpName(String empName) {
		return dao.findByEmpName(empName);
	}

}
