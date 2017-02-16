package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yl.dao.PriorityDao;
import com.yl.dao.ResultMapper;
import com.yl.entity.Priority;
import com.yl.vo.PriorityVo;

public class PriorityDaoImpl extends DbUtil implements PriorityDao {

	@Override
	public List<Priority> queryAll(int currentPage, int pageSize, PriorityVo vo) {
		String sql = "select * from priority";
		return super.excuteQuery(sql, map);
	}

	@Override
	public Priority queryById(Object id) {
		String sql = "select * from priority where priorityId = ?";
		List<Priority> list = super.excuteQuery(sql, map, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int save(Priority entity) {
		return 0;
	}

	@Override
	public int del(Object id) {
		return 0;
	}

	@Override
	public int update(Priority entity) {
		return 0;
	}

	@Override
	public int getCount(PriorityVo vo) {
		return 0;
	}
	
	ResultMapper<Priority> map = new ResultMapper<Priority>() {
		
		@Override
		public Priority resultMapping(ResultSet rs) {
			try {
				Priority entity = new Priority(rs.getInt("priorityId"), rs.getString("priorityName"));
				return entity;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
}
