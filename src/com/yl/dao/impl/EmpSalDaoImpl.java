package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yl.dao.EmpSalDao;
import com.yl.dao.ResultMapper;
import com.yl.entity.EmpSal;
import com.yl.entity.EmpSalState;
import com.yl.vo.EmpSalVo;

public class EmpSalDaoImpl extends DbUtil implements EmpSalDao {

	@Override
	public List<EmpSal> queryAll(int currentPage, int pageSize, EmpSalVo vo) {
		return null;
	}

	@Override
	public EmpSal queryById(Object id) {
		String sql = "select * from sal s left join salState s1 on s.salStateId = s1.salStateId where empId = ?";
		List<EmpSal> list = super.excuteQuery(sql, map, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int save(EmpSal entity) {
		String sql = "insert into sal values( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
		return super.excuteUpdate(sql, entity.getSalId() , entity.getBaseSal() , entity.getBonus() , entity.getFine() , entity.getOther() , entity.getSalType() , entity.getSalDate() , entity.getRemark() , entity.getEmpId() , entity.getSalState().getSalStateId());
	}

	@Override
	public int del(Object id) {
		String sql = "delete from sal where id = ?";
		return super.excuteUpdate(sql, id);
	}

	@Override
	public int update(EmpSal entity) {
		String sql = "update sal set baseSal = ? , bonus = ? , other = ? ,remark = ? , salStateId = ? where empId = ?";
		return super.excuteUpdate(sql, entity.getBaseSal() , entity.getBonus() , entity.getOther(), entity.getRemark() , entity.getSalState().getSalStateId(), entity.getEmpId());
	}

	@Override
	public int getCount(EmpSalVo vo) {
		return 0;
	}
	ResultMapper<EmpSal> map = new ResultMapper<EmpSal>() {
		
		@Override
		public EmpSal resultMapping(ResultSet rs) {
			try {
				EmpSal entity = new EmpSal(rs.getInt("salId"), rs.getDouble("baseSal"), rs.getDouble("bonus"), rs.getDouble("fine"), rs.getDouble("other"), rs.getString("salType"), rs.getDate("salDate"), rs.getString("remark"), rs.getInt("empId"), new EmpSalState(rs.getInt("salStateId"), rs.getString("salState")));
				return entity;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
}
