package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.EmpRoleBiz;
import com.yl.dao.EmpRoleDao;
import com.yl.dao.impl.EmpRoleDaoImpl;
import com.yl.entity.EmpRole;
import com.yl.vo.EmpRoleVo;

public class EmpRoleBizImpl implements EmpRoleBiz {
	private EmpRoleDao dao = new EmpRoleDaoImpl();
	@Override
	public List<EmpRole> findAll(int currentPage, int pageSize, EmpRoleVo vo) {
		return dao.queryAll(currentPage, pageSize, vo);
	}

	@Override
	public EmpRole findById(Object id) {
		return dao.queryById(id);
	}

	@Override
	public int save(EmpRole entity) {
		return dao.save(entity);
	}

	@Override
	public int del(Object id) {
		return dao.del(id);
	}

	@Override
	public int update(EmpRole entity) {
		return dao.update(entity);
	}

	@Override
	public int getTotalPage(int pageSize, EmpRoleVo vo) {
		return (dao.getCount(vo) - 1) / pageSize + 1;
	}

}
