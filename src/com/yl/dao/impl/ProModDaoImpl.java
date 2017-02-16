package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yl.dao.ProModDao;
import com.yl.dao.ResultMapper;
import com.yl.entity.Emp1;
import com.yl.entity.ModPriority;
import com.yl.entity.Pro1;
import com.yl.entity.ProMod;
import com.yl.entity.ProMod1;
import com.yl.vo.ProModVo;

public class ProModDaoImpl extends DbUtil implements ProModDao {

	@Override
	public List<ProMod> queryAll(int currentPage, int pageSize, ProModVo vo) {
		String sql = "select * from `mod` m left join pro p on m.proId = p.proId left join modPriority m1 on m.modPriorityId = m1.modPriorityId left join emp e on m.empId = e.empId where 1=1";
		sql = this.setCondition(vo, sql);
		sql += " limit ? ,?";
		return super.excuteQuery(sql, map, (currentPage - 1) * pageSize , pageSize);
	}
	
	private String setCondition(ProModVo vo, String sql) {
		if (vo != null) {
			if (vo.getBegin() != null ) {
				if (vo.getEnd() != null) {
					sql += " and modCreateDate between '"+vo.getBegin()+"' and '"+vo.getEnd()+"'";
				}else {
					sql += " and modCreateDate >= '"+vo.getBegin()+"'";					
				}
			}else {
				if (vo.getEnd() != null) {
					sql += " and modCreateDate <= '"+vo.getEnd()+"'";
				}
			}
		}
		return sql;
	}
	
	@Override
	public ProMod queryById(Object id) {
		String sql = "select * from `mod` m left join pro p on m.proId = p.proId left join modPriority m1 on m.modPriorityId = m1.modPriorityId left join emp e on m.empId = e.empId where modId = ?";
		List<ProMod> list = super.excuteQuery(sql, map, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int save(ProMod entity) {
		String sql = "insert into `mod` values(? , ? , ? , ? , ? , ? , ?, ?)";
		return super.excuteUpdate(sql, entity.getModId() , entity.getModName() , entity.getPro1().getProId() , entity.getEmp1().getEmpId() , entity.getModPriority().getModPriorityId() , entity.getCreateDate() , entity.getEndDate() , entity.getRemark());
	}

	@Override
	public int del(Object id) {
		String sql = "delete from `mod` where modId = ?";
		return super.excuteUpdate(sql, id);
	}

	@Override
	public int update(ProMod entity) {
		String sql = "update `mod` set modName = ? , proId = ? , empId = ? , modPriorityId = ? , modCreateDate = ? , modEndDate = ? , modRemark = ? where modId = ?";
		return super.excuteUpdate(sql , entity.getModName() , entity.getPro1().getProId() , entity.getEmp1().getEmpId() , entity.getModPriority().getModPriorityId() , entity.getCreateDate() , entity.getEndDate() , entity.getRemark() , entity.getModId() );
	}

	@Override
	public int getCount(ProModVo vo) {
		String sql = "select * from `mod` m left join pro p on m.proId = p.proId left join modPriority m1 on m.modPriorityId = m1.modPriorityId left join emp e on m.empId = e.empId";
		List<ProMod> list = super.excuteQuery(sql, map);
		return list.size();
	}
	ResultMapper<ProMod> map = new ResultMapper<ProMod>() {
		
		@Override
		public ProMod resultMapping(ResultSet rs) {
			try {
				Pro1 pro1 = new Pro1(rs.getInt("proId"), rs.getString("proName"));
				Emp1 emp1 = new Emp1(rs.getInt("empId"), rs.getString("empName"));
				ModPriority modPriority = new ModPriority(rs.getInt("modPriorityId"), rs.getString("modPriorityName"));
				ProMod entity = new ProMod(rs.getInt("modId"), rs.getString("modName"), pro1, emp1, modPriority, rs.getDate("modCreateDate"), rs.getDate("modEndDate"), rs.getString("modRemark"));
				return entity;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
	
	@Override
	public List<ProMod1> findAlls() {
		String sql = "select * from `mod` m left join pro p on m.proId = p.proId";
		return super.excuteQuery(sql, map1);
	}
	
	ResultMapper<ProMod1> map1 = new ResultMapper<ProMod1>() {
		
		@Override
		public ProMod1 resultMapping(ResultSet rs) {
			try {
				ProMod1 entity = new ProMod1(rs.getInt("modId"), rs.getString("modName"), new Pro1(rs.getInt("proId"), rs.getString("proName")));
				return entity;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
}
