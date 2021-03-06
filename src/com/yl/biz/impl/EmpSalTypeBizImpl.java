package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.EmpSalTypeBiz;
import com.yl.dao.EmpSalTypeDao;
import com.yl.dao.impl.EmpSalTypeDaoImpl;
import com.yl.entity.EmpSalType;
import com.yl.vo.EmpSalTypeVo;

public class EmpSalTypeBizImpl implements EmpSalTypeBiz {
	private EmpSalTypeDao dao = new EmpSalTypeDaoImpl();
	@Override
	public List<EmpSalType> findAll(int currentPage, int pageSize,
			EmpSalTypeVo vo) {
		return dao.queryAll(currentPage, pageSize, vo);
	}

	@Override
	public EmpSalType findById(Object id) {
		return dao.queryById(id);
	}

	@Override
	public int save(EmpSalType entity) {
		return dao.save(entity);
	}

	@Override
	public int del(Object id) {
		return dao.del(id);
	}

	@Override
	public int update(EmpSalType entity) {
		return dao.update(entity);
	}

	@Override
	public int getTotalPage(int pageSize, EmpSalTypeVo vo) {
		return (dao.getCount(vo) - 1) / pageSize + 1;
	}

}
