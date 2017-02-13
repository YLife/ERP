package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.EmpTypeBiz;
import com.yl.dao.EmpTypeDao;
import com.yl.dao.impl.EmpTypeDaoImpl;
import com.yl.entity.EmpType;
import com.yl.vo.EmpTypeVo;

public class EmpTypeBizImpl implements EmpTypeBiz {
	private EmpTypeDao dao = new EmpTypeDaoImpl();
	@Override
	public List<EmpType> findAll(int currentPage, int pageSize, EmpTypeVo vo) {
		return null;
	}

	@Override
	public EmpType findById(Object id) {
		return dao.queryById(id);
	}

	@Override
	public int save(EmpType entity) {
		return 0;
	}

	@Override
	public int del(Object id) {
		return 0;
	}

	@Override
	public int update(EmpType entity) {
		return 0;
	}

	@Override
	public int getTotalPage(int pageSize, EmpTypeVo vo) {
		return 0;
	}

}
