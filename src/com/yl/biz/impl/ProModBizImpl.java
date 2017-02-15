package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.ProModBiz;
import com.yl.dao.ProModDao;
import com.yl.dao.impl.ProModDaoImpl;
import com.yl.entity.ProMod;
import com.yl.vo.ProModVo;

public class ProModBizImpl implements ProModBiz {
	private ProModDao dao = new ProModDaoImpl();
	@Override
	public List<ProMod> findAll(int currentPage, int pageSize, ProModVo vo) {
		return dao.queryAll(currentPage, pageSize, vo);
	}

	@Override
	public ProMod findById(Object id) {
		return dao.queryById(id);
	}

	@Override
	public int save(ProMod entity) {
		return dao.save(entity);
	}

	@Override
	public int del(Object id) {
		return dao.del(id);
	}

	@Override
	public int update(ProMod entity) {
		return dao.update(entity);
	}

	@Override
	public int getTotalPage(int pageSize, ProModVo vo) {
		return (dao.getCount(vo) - 1) / pageSize + 1;
	}

}
