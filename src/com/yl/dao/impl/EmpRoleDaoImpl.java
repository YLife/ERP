package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yl.dao.EmpRoleDao;
import com.yl.dao.ResultMapper;
import com.yl.entity.EmpRole;
import com.yl.vo.EmpRoleVo;

public class EmpRoleDaoImpl extends DbUtil implements EmpRoleDao {

	@Override
	public List<EmpRole> queryAll(int currentPage, int pageSize, EmpRoleVo vo) {
		String sql ="select * from empRole limit ? , ?";
		return super.excuteQuery(sql, map, currentPage , pageSize);
	}

	@Override
	public EmpRole queryById(Object id) {
		String sql = "select * from empRole where roleId = ?";
		List<EmpRole> list = super.excuteQuery(sql, map, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int save(EmpRole entity) {
		String sql = "insert into empRole values(? , ?)";
		return super.excuteUpdate(sql, entity.getRoleId() , entity.getRoleName());
	}

	@Override
	public int del(Object id) {
		String sql = "delete * from where roleId = ?";
		return super.excuteUpdate(sql, id);
	}

	@Override
	public int update(EmpRole entity) {
		String sql = "update empRole set roleName = ? where roleId = ?";
		return super.excuteUpdate(sql, entity.getRoleName() , entity.getRoleId());
	}

	@Override
	public int getCount(EmpRoleVo vo) {
		String sql = "select * from empRole";
		List<EmpRole> list = super.excuteQuery(sql, map);
		return list.size();
	}
	ResultMapper<EmpRole> map = new ResultMapper<EmpRole>() {
		
		@Override
		public EmpRole resultMapping(ResultSet rs) {
			try {
				EmpRole entity = new EmpRole(rs.getInt("roleId"), rs.getString("roleName"));
				return entity;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	};
}
