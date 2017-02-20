package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.MessBiz;
import com.yl.dao.impl.MessDaoImpl;
import com.yl.dao.MessDao;
import com.yl.entity.Mess;
import com.yl.vo.MessVo;

public class MessBizImpl implements MessBiz {
	private MessDao dao = new MessDaoImpl();
	@Override
	public List<Mess> findAll(int currentPage, int pageSize, MessVo vo) {
		return dao.queryAll(currentPage, pageSize, vo);
	}

	@Override
	public Mess findById(Object id) {
		return dao.queryById(id);
	}

	@Override
	public int save(Mess entity) {
		return dao.save(entity);
	}

	@Override
	public int del(Object id) {
		return dao.del(id);
	}

	@Override
	public int update(Mess entity) {
		return 0;
	}

	@Override
	public int getTotalPage(int pageSize, MessVo vo) {
		return (dao.getCount(vo) - 1) / pageSize + 1;
	}

	@Override
	public List<Mess> findByEmpName(int currentPage, int pageSize, MessVo vo,
			String empName) {
		return dao.findByEmpName(currentPage, pageSize, vo, empName);
	}

	@Override
	public int getCount1(int pageSize ,MessVo vo, String empName) {
		return (dao.getCount1(vo, empName) - 1) / pageSize + 1;
	}

	@Override
	public int getCount2(int pageSize , MessVo vo, String empName) {
		return (dao.getCount2(vo, empName) - 1) / pageSize + 1;
	}

	@Override
	public List<Mess> findByEmpName1(int currentPage, int pageSize, MessVo vo,
			String empName) {
		return dao.findByEmpName1(currentPage, pageSize, vo, empName);
	}

	@Override
	public List<Mess> findByEmpName2(int currentPage, int pageSize, MessVo vo,
			String empName) {
		return dao.findByEmpName2(currentPage, pageSize, vo, empName);
	}

}
