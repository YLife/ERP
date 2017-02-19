package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.FileBiz;
import com.yl.dao.FileDao;
import com.yl.dao.impl.FileDaoImpl;
import com.yl.entity.Files;
import com.yl.vo.FileVo;

public class FileBizImpl implements FileBiz {
	private FileDao dao = new FileDaoImpl();
	
	@Override
	public List<Files> findAll(int currentPage, int pageSize, FileVo vo) {
		return dao.queryAll(currentPage, pageSize, vo);
	}

	@Override
	public Files findById(Object id) {
		return dao.queryById(id);
	}

	@Override
	public int save(Files entity) {
		return dao.save(entity);
	}

	@Override
	public int del(Object id) {
		return dao.del(id);
	}

	@Override
	public int update(Files entity) {
		return dao.update(entity);
	}

	@Override
	public int getTotalPage(int pageSize, FileVo vo) {
		return (dao.getCount(vo) - 1) / pageSize + 1;
	}

}
