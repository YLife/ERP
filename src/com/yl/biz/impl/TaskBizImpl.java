package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.TaskBiz;
import com.yl.dao.TaskDao;
import com.yl.dao.impl.TaskDaoImpl;
import com.yl.entity.Task;
import com.yl.vo.TaskVo;

public class TaskBizImpl implements TaskBiz {
	private TaskDao dao = new TaskDaoImpl();
	@Override
	public List<Task> findAll(int currentPage, int pageSize, TaskVo vo) {
		return dao.queryAll(currentPage, pageSize, vo);
	}

	@Override
	public Task findById(Object id) {
		return dao.queryById(id);
	}

	@Override
	public int save(Task entity) {
		return dao.save(entity);
	}

	@Override
	public int del(Object id) {
		return dao.del(id);
	}

	@Override
	public int update(Task entity) {
		return dao.update(entity);
	}

	@Override
	public int getTotalPage(int pageSize, TaskVo vo) {
		return (dao.getCount(vo) - 1) / pageSize + 1;
	}

}
