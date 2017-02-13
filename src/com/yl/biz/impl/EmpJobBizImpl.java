package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.EmpJobBiz;
import com.yl.dao.EmpJobDao;
import com.yl.dao.impl.EmpJobDaoImpl;
import com.yl.entity.EmpJob;
import com.yl.vo.EmpJobVo;

public class EmpJobBizImpl implements EmpJobBiz {
	private EmpJobDao dao = new EmpJobDaoImpl();
	@Override
	public List<EmpJob> findAll(int currentPage, int pageSize, EmpJobVo vo) {
		return dao.queryAll(currentPage, pageSize, vo);
	}

	@Override
	public EmpJob findById(Object id) {
		return dao.queryById(id);
	}

	@Override
	public int save(EmpJob entity) {
		return dao.save(entity);
	}

	@Override
	public int del(Object id) {
		return dao.del(id);
	}

	@Override
	public int update(EmpJob entity) {
		return dao.update(entity);
	}

	@Override
	public int getTotalPage(int pageSize, EmpJobVo vo) {
		return (dao.getCount(vo) - 1) / pageSize + 1;
	}

}
