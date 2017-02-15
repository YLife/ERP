package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.ProStateBiz;
import com.yl.dao.ProStateDao;
import com.yl.dao.impl.ProStateDaoImpl;
import com.yl.entity.ProState;
import com.yl.vo.ProStateVo;

public class ProStateBizImpl implements ProStateBiz {
	private ProStateDao dao = new ProStateDaoImpl();
	@Override
	public List<ProState> findAll(int currentPage, int pageSize, ProStateVo vo) {
		return null;
	}

	@Override
	public ProState findById(Object id) {
		return dao.queryById(id);
	}

	@Override
	public int save(ProState entity) {
		return 0;
	}

	@Override
	public int del(Object id) {
		return 0;
	}

	@Override
	public int update(ProState entity) {
		return 0;
	}

	@Override
	public int getTotalPage(int pageSize, ProStateVo vo) {
		return 0;
	}

}
