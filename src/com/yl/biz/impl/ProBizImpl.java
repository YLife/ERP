package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.ProBiz;
import com.yl.dao.ProDao;
import com.yl.dao.impl.ProDaoImpl;
import com.yl.entity.Pro;
import com.yl.entity.Pro1;
import com.yl.vo.ProVo;

public class ProBizImpl implements ProBiz {
	ProDao dao = new ProDaoImpl();
	@Override
	public List<Pro> findAll(int currentPage, int pageSize, ProVo vo) {
		return dao.queryAll(currentPage, pageSize, vo);
	}

	@Override
	public Pro findById(Object id) {
		return dao.queryById(id);
	}

	@Override
	public int save(Pro entity) {
		return dao.save(entity);
	}

	@Override
	public int del(Object id) {
		return dao.del(id);
	}

	@Override
	public int update(Pro entity) {
		return dao.update(entity);
	}

	@Override
	public int getTotalPage(int pageSize, ProVo vo) {
		return (dao.getCount(vo) - 1) / pageSize + 1;
	}

	@Override
	public List<Pro1> findPro1s() {
		return dao.queryPro1s();
	}

}
