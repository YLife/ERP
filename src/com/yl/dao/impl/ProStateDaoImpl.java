package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yl.dao.ProStateDao;
import com.yl.dao.ResultMapper;
import com.yl.entity.ProState;
import com.yl.vo.ProStateVo;

public class ProStateDaoImpl extends DbUtil implements ProStateDao {

	@Override
	public List<ProState> queryAll(int currentPage, int pageSize, ProStateVo vo) {
		return null;
	}

	@Override
	public ProState queryById(Object id) {
		String sql = "select * from proState where proStateId = ?";
		List<ProState> list = super.excuteQuery(sql, map, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int save(ProState entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int del(Object id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ProState entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount(ProStateVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	ResultMapper<ProState> map = new ResultMapper<ProState>() {
		
		@Override
		public ProState resultMapping(ResultSet rs) {
			try {
				ProState entity = new ProState(rs.getInt("proStateId"), rs.getString("proState"));
				return entity;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
}
