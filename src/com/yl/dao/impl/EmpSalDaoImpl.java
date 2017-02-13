package com.yl.dao.impl;

import java.util.List;

import com.yl.dao.EmpSalDao;
import com.yl.entity.EmpSal;
import com.yl.vo.EmpSalVo;

public class EmpSalDaoImpl extends DbUtil implements EmpSalDao {

	@Override
	public List<EmpSal> queryAll(int currentPage, int pageSize, EmpSalVo vo) {
		return null;
	}

	@Override
	public EmpSal queryById(Object id) {
		return null;
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
		String sql = "update sal baseSal = ? , bonus = ? , other = ? ,remark = ? where empId = ?";
		return super.excuteUpdate(sql, entity.getBaseSal() , entity.getBonus() , entity.getOther(), entity.getRemark() , entity.getEmpId());
	}

	@Override
	public int getCount(EmpSalVo vo) {
		return 0;
	}

}
