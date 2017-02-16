package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.ProFunBiz;
import com.yl.dao.ProFunDao;
import com.yl.dao.impl.ProFunDaoImpl;
import com.yl.entity.ProFun;
import com.yl.vo.ProFunVo;

public class ProFunBizImpl implements ProFunBiz {
	private ProFunDao dao = new ProFunDaoImpl();
	@Override
	public List<ProFun> findAll(int currentPage, int pageSize, ProFunVo vo) {
		return dao.queryAll(currentPage, pageSize, vo);
	}

	@Override
	public ProFun findById(Object id) {
		return dao.queryById(id);
	}

	@Override
	public int save(ProFun entity) {
		return dao.save(entity);
	}

	@Override
	public int del(Object id) {
		return dao.del(id);
	}

	@Override
	public int update(ProFun entity) {
		return dao.update(entity);
	}

	@Override
	public int getTotalPage(int pageSize, ProFunVo vo) {
		return (dao.getCount(vo) - 1) / pageSize + 1;
	}

}
