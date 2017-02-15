package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yl.dao.ProDao;
import com.yl.dao.ResultMapper;
import com.yl.entity.Client;
import com.yl.entity.Emp;
import com.yl.entity.EmpJob;
import com.yl.entity.EmpRole;
import com.yl.entity.EmpSal;
import com.yl.entity.EmpSalState;
import com.yl.entity.EmpType;
import com.yl.entity.Priority;
import com.yl.entity.Pro;
import com.yl.entity.Pro1;
import com.yl.entity.ProState;
import com.yl.vo.ProVo;

public class ProDaoImpl extends DbUtil implements ProDao {

	@Override
	public List<Pro> queryAll(int currentPage, int pageSize, ProVo vo) {
		String sql = "select * from pro p left join client c on p.clientId = c.clientId left join priority p1 on p.priorityId = p1.priorityId left join proState p2 on p.proStateId = p2.proStateId left join (emp e left join  empType t on e.typeId = t.typeId left join empJob j on e.jobId = j.jobId left join empRole r on e.roleId = r.roleId left join (sal s left join salState s1 on s.salStateId = s1.salStateId) on e.empId = s.empId) on p.managerId = e.empId where 1=1";
		sql = this.setCondition(vo, sql);
		sql += " limit ? , ?";
		return super.excuteQuery(sql, map, (currentPage - 1) * 5 , pageSize);
	}
	
	private String setCondition(ProVo vo, String sql) {
		if (vo != null) {
			if (vo.getBegin() != null ) {
				if (vo.getEnd() != null) {
					sql += " and createDate between '"+vo.getBegin()+"' and '"+vo.getEnd()+"'";
				}else {
					sql += " and createDate >= '"+vo.getBegin()+"'";					
				}
			}else {
				if (vo.getEnd() != null) {
					sql += " and createDate <= '"+vo.getEnd()+"'";
				}
			}
		}
		return sql;
	}
	@Override
	public Pro queryById(Object id) {
		String sql = "select * from pro p left join client c on p.clientId = c.clientId left join priority p1 on p.priorityId = p1.priorityId left join proState p2 on p.proStateId = p2.proStateId left join (emp e left join  empType t on e.typeId = t.typeId left join empJob j on e.jobId = j.jobId left join empRole r on e.roleId = r.roleId left join (sal s left join salState s1 on s.salStateId = s1.salStateId) on e.empId = s.empId) on p.managerId = e.empId where proId = ?";
		List<Pro> list = super.excuteQuery(sql, map, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int save(Pro entity) {
		String sql = "insert into pro values(? , ? , ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return super.excuteUpdate(sql, entity.getProId() , entity.getProName() , entity.getProAmount() , entity.getClient().getClientId() , entity.getEmp().getEmpId() , entity.getDevNum() , entity.getCreateDate() , entity.getStartDate() , entity.getEndDate() , entity.getProCost() , entity.getRemark() , entity.getPriority().getPriorityId() , entity.getProState().getProStateId());
	}

	@Override
	public int del(Object id) {
		String sql = "delete from pro where proId = ?";
		return super.excuteUpdate(sql, id);
	}

	@Override
	public int update(Pro entity) {
		String sql = "update pro set proName = ? , clientId = ? , proAmount = ? , devNum = ? , managerId = ? , proStateId = ? , proCost = ? , startDate = ? , endDate = ? , priorityId = ?  , remark = ? where proId = ?";
		return super.excuteUpdate(sql, entity.getProName() , entity.getClient().getClientId() , entity.getProAmount() , entity.getDevNum() , entity.getEmp().getEmpId() , entity.getProState().getProStateId(), entity.getProCost() , entity.getStartDate() , entity.getEndDate() ,entity.getPriority().getPriorityId(),entity.getRemark() , entity.getProId());
	}

	@Override
	public int getCount(ProVo vo) {
		String sql = "select * from pro p left join client c on p.clientId = c.clientId left join priority p1 on p.priorityId = p1.priorityId left join proState p2 on p.proStateId = p2.proStateId left join (emp e left join  empType t on e.typeId = t.typeId left join empJob j on e.jobId = j.jobId left join empRole r on e.roleId = r.roleId left join (sal s left join salState s1 on s.salStateId = s1.salStateId) on e.empId = s.empId) on p.managerId = e.empId";
		List<Pro> list = super.excuteQuery(sql, map);
		return list.size();
	}
	ResultMapper<Pro> map = new ResultMapper<Pro>() {
		
		@Override
		public Pro resultMapping(ResultSet rs) {
			try {
				Emp emp = new Emp(rs.getInt("empId"), rs.getString("empName"), rs.getString("empPwd"), rs.getString("empSex"), rs.getDate("empBorn") , rs.getDate("empDate"), rs.getString("empNo"), rs.getString("empPhone"), new EmpType(rs.getInt("typeId"), rs.getString("typeName")),new EmpJob(rs.getInt("jobId"), rs.getString("jobName")) , new EmpRole(rs.getInt("roleId"), rs.getString("roleName")) , new EmpSal(rs.getInt("salId"), rs.getDouble("baseSal"), rs.getDouble("bonus"), rs.getDouble("fine"), rs.getDouble("other"), rs.getString("salType"), rs.getDate("salDate"), rs.getString("remark"), rs.getInt("empId"), new EmpSalState(rs.getInt("salStateId"), rs.getString("salState"))));
				Client client = new Client(rs.getInt("clientId"), rs.getString("clientName"), rs.getString("clientComp"), rs.getString("clientPhone"), rs.getString("clientAdd"), rs.getString("clientBack") , rs.getDate("clientDate"));
				Pro pro = new Pro(rs.getInt("proId"), rs.getString("proName"), rs.getDouble("proAmount"), client, emp, rs.getInt("devNum"), rs.getDate("createDate"), rs.getDate("startDate"), rs.getDate("endDate"), rs.getDouble("proCost"), rs.getString("remark"), new Priority(rs.getInt("priorityId"), rs.getString("priorityName")), new ProState(rs.getInt("proStateId"), rs.getString("proState")));
				return pro;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
	@Override
	public List<Pro1> queryPro1s() {
		String sql = "select * from pro";
		return super.excuteQuery(sql, map1);
	}
	
	ResultMapper<Pro1> map1 = new ResultMapper<Pro1>() {
		
		@Override
		public Pro1 resultMapping(ResultSet rs) {
			try {
				Pro1 pro1 = new Pro1(rs.getInt("proId"), rs.getString("proName"));
				return pro1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
}
