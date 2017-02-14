package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yl.dao.EmpWorkCaseDao;
import com.yl.dao.ResultMapper;
import com.yl.entity.Emp;
import com.yl.entity.EmpJob;
import com.yl.entity.EmpRole;
import com.yl.entity.EmpSal;
import com.yl.entity.EmpSalState;
import com.yl.entity.EmpType;
import com.yl.vo.EmpWorkCaseVo;

public class EmpWorkCaseDaoImpl extends DbUtil implements EmpWorkCaseDao {

	@Override
	public List<Emp> queryAll(int currentPage, int pageSize, EmpWorkCaseVo vo) {
		String sql = "select * from emp e left join  empType t on e.typeId = t.typeId left join empJob j on e.jobId = j.jobId left join empRole r on e.roleId = r.roleId left join (sal s left join salState s1 on s.salStateId = s1.salStateId) on e.empId = s.empId where 1=1";
		sql = setCondition(vo, sql);
		sql += " limit ? , ?";
		return super.excuteQuery(sql, map, (currentPage - 1) * pageSize , pageSize);
	}

	private String setCondition(EmpWorkCaseVo vo, String sql) {
		if (vo != null) {
			if (vo.getFirst() != null) {
				if (vo.getSecond() != null) {
					sql += " and salDate >= '"+vo.getFirst()+"-"+vo.getSecond()+"-01'";					
				}else {
					sql += " and salDate >= '"+vo.getFirst()+"-01-01'";
				}
			}else {
				if (vo.getSecond() != null) {
					sql += " and salDate >= '1970-"+vo.getSecond()+"-01'";									
				}
			}
		}
		return sql;
	}

	@Override
	public Emp queryById(Object id) {
		String sql = "select * from emp e left join  empType t on e.typeId = t.typeId left join empJob j on e.jobId = j.jobId left join empRole r on e.roleId = r.roleId left join (sal s left join salState s1 on s.salStateId = s1.salStateId) on e.empId = s.empId where e.empId = ?";
		List<Emp> list = super.excuteQuery(sql, map, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int save(Emp entity) {
		String sql = "insert into emp values(? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
		return super.excuteUpdate(sql, entity.getEmpId() , entity.getEmpName() , entity.getEmpPwd() , entity.getEmpSex() , entity.getEmpBorn() , entity.getEmpDate() , entity.getEmpNo() , entity.getEmpPhone() , entity.getEmpType().getTypeId() , entity.getEmpJob().getJobId() , entity.getEmpRole().getRoleId());
	}

	@Override
	public int del(Object id) {
		String sql = "delete from emp where empId = ?";
		return super.excuteUpdate(sql, id);
	}

	@Override
	public int update(Emp entity) {
		String sql = "update emp set empName = ? , empPwd = ? , empSex = ? , empBorn = ? , empDate = ? , empNo = ? , empPhone = ? , tyId = ? , jobId = ? , roleId = ? where empId = ?";
		return super.excuteUpdate(sql, entity.getEmpName() , entity.getEmpPwd() , entity.getEmpSex() , entity.getEmpBorn() , entity.getEmpDate() , entity.getEmpNo() , entity.getEmpPhone() , entity.getEmpType().getTypeId() , entity.getEmpJob().getJobId() , entity.getEmpRole().getRoleId() , entity.getEmpId());
	}

	@Override
	public int getCount(EmpWorkCaseVo vo) {
		String sql = "select * from emp e left join  empType t on e.typeId = t.typeId left join empJob j on e.jobId = j.jobId left join empRole r on e.roleId = r.roleId left join (sal s left join salState s1 on s.salStateId = s1.salStateId) on e.empId = s.empId where 1=1";
		sql = this.setCondition(vo, sql);
		List<Emp> list = super.excuteQuery(sql, map);
		return list.size();
	}
	
	ResultMapper<Emp> map = new ResultMapper<Emp>() {
		
		@Override
		public Emp resultMapping(ResultSet rs) {
			Emp emp = null;
			try {
				emp = new Emp(rs.getInt("empId"), rs.getString("empName"), rs.getString("empPwd"), rs.getString("empSex"), rs.getDate("empBorn") , rs.getDate("empDate"), rs.getString("empNo"), rs.getString("empPhone"), new EmpType(rs.getInt("typeId"), rs.getString("typeName")),new EmpJob(rs.getInt("jobId"), rs.getString("jobName")) , new EmpRole(rs.getInt("roleId"), rs.getString("roleName")) , new EmpSal(rs.getInt("salId"), rs.getDouble("baseSal"), rs.getDouble("bonus"), rs.getDouble("fine"), rs.getDouble("other"), rs.getString("salType"), rs.getDate("salDate"), rs.getString("remark"), rs.getInt("empId"), new EmpSalState(rs.getInt("salStateId"), rs.getString("salState"))));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return emp;
		}
	};
}
