package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yl.dao.EmpTypeDao;
import com.yl.dao.ResultMapper;
import com.yl.entity.EmpType;
import com.yl.vo.EmpTypeVo;

public class EmpTypeDaoImpl extends DbUtil implements EmpTypeDao {

	@Override
	public List<EmpType> queryAll(int currentPage, int pageSize, EmpTypeVo vo) {
		return null;
	}

	@Override
	public EmpType queryById(Object id) {
		String sql = "select * from empType where typeId = ?";
		List<EmpType> list = super.excuteQuery(sql, map, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int save(EmpType entity) {
		return 0;
	}

	@Override
	public int del(Object id) {
		return 0;
	}

	@Override
	public int update(EmpType entity) {
		return 0;
	}

	@Override
	public int getCount(EmpTypeVo vo) {
		return 0;
	}
	
	ResultMapper<EmpType> map = new ResultMapper<EmpType>() {
		
		@Override
		public EmpType resultMapping(ResultSet rs) {
			try {
				EmpType entity = new EmpType(rs.getInt("typeId"), rs.getString("typeName"));
				return entity;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
}
