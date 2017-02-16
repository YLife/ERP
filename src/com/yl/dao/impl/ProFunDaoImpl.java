package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yl.dao.ProFunDao;
import com.yl.dao.ResultMapper;
import com.yl.entity.Emp1;
import com.yl.entity.FunPriority;
import com.yl.entity.Pro1;
import com.yl.entity.ProFun;
import com.yl.entity.ProMod1;
import com.yl.vo.ProFunVo;

public class ProFunDaoImpl extends DbUtil implements ProFunDao {

	@Override
	public List<ProFun> queryAll(int currentPage, int pageSize, ProFunVo vo) {
		String sql = "select * from fun f left join emp e on f.empId = e.empId left join (`mod` m left join pro p on m.proId = p.proId) on f.modId = m.modId left join funPriority f2 on f.funPriorityId = f2.funPriorityId where 1=1";
		sql = setCondition(vo, sql);
		sql += " limit ? , ?";
		return super.excuteQuery(sql, map, (currentPage - 1) * pageSize, pageSize);
	}

	private String setCondition(ProFunVo vo, String sql) {
		if (vo != null) {
			if (vo.getFunName() != null) {
				sql += " and funName like '%"+vo.getFunName()+"%'";				
			}
		}
		return sql;
	}

	@Override
	public ProFun queryById(Object id) {
		String sql = "select * from fun f left join emp e on f.empId = e.empId left join (`mod` m left join pro p on m.proId = p.proId) on f.modId = m.modId left join funPriority f2 on f.funPriorityId = f2.funPriorityId where funId = ?";
		List<ProFun> list = super.excuteQuery(sql, map, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int save(ProFun entity) {
		String sql = "insert into fun values(? ,? ,? ,? ,? , ?, ?)";
		return super.excuteUpdate(sql, entity.getFunId() , entity.getFunName() , entity.getMod1().getModId() , entity.getEmp1().getEmpId() , entity.getFunPriority().getFunPriorityId() , entity.getCreateDate() , entity.getRemark());
	}

	@Override
	public int del(Object id) {
		String sql ="delete from fun where funId = ?";
		return super.excuteUpdate(sql, id);
	}

	@Override
	public int update(ProFun entity) {
		String sql ="update fun set funName = ?, modId = ? ,empId = ? , funPriorityId = ? ,funCreateDate = ? , funRemark = ? where funId = ?";
		return super.excuteUpdate(sql, entity.getFunName() , entity.getMod1().getModId() , entity.getEmp1().getEmpId() , entity.getFunPriority().getFunPriorityId() , entity.getCreateDate() , entity.getRemark(), entity.getFunId());
	}

	@Override
	public int getCount(ProFunVo vo) {
		String sql = "select * from fun f left join emp e on f.empId = e.empId left join (`mod` m left join pro p on m.proId = p.proId) on f.modId = m.modId left join funPriority f2 on f.funPriorityId = f2.funPriorityId";
		List<ProFun> list = super.excuteQuery(sql, map);
		return list.size();
	}
	ResultMapper<ProFun> map = new ResultMapper<ProFun>() {
		
		@Override
		public ProFun resultMapping(ResultSet rs) {
			try {
				ProMod1 proMod1 = new ProMod1(rs.getInt("modId"), rs.getString("modName"), new Pro1(rs.getInt("proId"), rs.getString("proName")));
				ProFun entity = new ProFun(rs.getInt("funId"), rs.getString("funName"), proMod1, new Emp1(rs.getInt("empId"), rs.getString("empName")), new FunPriority(rs.getInt("funPriorityId"), rs.getString("funPriorityName")), rs.getDate("createDate"), rs.getString("funRemark"));
				return entity;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
}
