package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.PriorityBiz;
import com.yl.dao.PriorityDao;
import com.yl.dao.impl.PriorityDaoImpl;
import com.yl.entity.Priority;
import com.yl.vo.PriorityVo;

public class PriorityBizImpl implements PriorityBiz {
	private PriorityDao dao = new PriorityDaoImpl();
	@Override
	public List<Priority> findAll(int currentPage, int pageSize, PriorityVo vo) {
		return dao.queryAll(currentPage, pageSize, vo);
	}

	@Override
	public Priority findById(Object id) {
		return dao.queryById(id);
	}

	@Override
	public int save(Priority entity) {
		return dao.save(entity);
	}

	@Override
	public int del(Object id) {
		return dao.del(id);
	}

	@Override
	public int update(Priority entity) {
		return dao.update(entity);
	}

	@Override
	public int getTotalPage(int pageSize, PriorityVo vo) {
		return (dao.getCount(vo) - 1) / pageSize + 1;
	}

}
