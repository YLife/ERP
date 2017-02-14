package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yl.dao.EmpSalTypeDao;
import com.yl.dao.ResultMapper;
import com.yl.entity.EmpSalType;
import com.yl.vo.EmpSalTypeVo;

public class EmpSalTypeDaoImpl extends DbUtil implements EmpSalTypeDao {

	@Override
	public List<EmpSalType> queryAll(int currentPage, int pageSize,
			EmpSalTypeVo vo) {
		String sql ="select * from salType where 1=1";
		sql = setCondition(vo, sql);
		sql += " limit ? , ?";
		return super.excuteQuery(sql, map, (currentPage - 1) * pageSize , pageSize);
	}
	
	private String setCondition(EmpSalTypeVo vo, String sql) {
		if (vo != null) {
			if (vo.getBegin() != null) {
				if (vo.getEnd() != null) {
					sql += " and salTypeDate between '"+vo.getBegin()+"' and '"+vo.getEnd()+"'";
				}else {
					sql += " and salTypeDate >= '"+vo.getBegin()+"'";
				}
			}else {
				if (vo.getEnd() != null) {
					sql += " and salTypeDate <= '"+vo.getEnd()+"'";
				}
			}
		}
		return sql;
	}
	@Override
	public EmpSalType queryById(Object id) {
		String sql = "select * from salType where salTypeId = ?";
		List<EmpSalType> list = super.excuteQuery(sql, map, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int save(EmpSalType entity) {
		String sql = "insert into salType values(? ,? ,?, ?, ?, ?, ?)";
		return super.excuteUpdate(sql, entity.getSalTypeId() , entity.getSalTypeName() , entity.getSalTypeAmount(), entity.getSalTypeRemark() , entity.getSalTypeDate() , entity.getSalTypeState() , entity.getSalTypePriority());
	}

	@Override
	public int del(Object id) {
		String sql = "delete from salType where salTypeId = ?";
		return super.excuteUpdate(sql, id);
	}

	@Override
	public int update(EmpSalType entity) {
		String sql = "update salType set salTypeName = ? , salTypeAmount = ? , salTypeRemark = ? , salTypeDate = ?, salTypeState = ? , salTypePriority = ? where salTypeId = ?";
		return super.excuteUpdate(sql , entity.getSalTypeName() , entity.getSalTypeAmount(), entity.getSalTypeRemark() , entity.getSalTypeDate() , entity.getSalTypeState() , entity.getSalTypePriority() , entity.getSalTypeId());
	}

	@Override
	public int getCount(EmpSalTypeVo vo) {
		String sql = "select * from salType";
		List<EmpSalType> list = super.excuteQuery(sql, map);
		return list.size();
	}
	ResultMapper<EmpSalType> map = new ResultMapper<EmpSalType>() {
		
		@Override
		public EmpSalType resultMapping(ResultSet rs) {
			try {
				EmpSalType entity = new EmpSalType(rs.getInt("salTypeId"), rs.getString("salTypeName"), rs.getString("salTypeAmount"), rs.getString("salTypeRemark"), rs.getDate("salTypeDate"), rs.getString("salTypeState"), rs.getString("salTypePriority"));
				return entity;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
}
