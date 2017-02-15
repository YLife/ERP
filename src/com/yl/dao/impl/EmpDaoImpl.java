package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.yl.dao.EmpDao;
import com.yl.dao.ResultMapper;
import com.yl.entity.Emp;
import com.yl.entity.EmpJob;
import com.yl.entity.EmpRole;
import com.yl.entity.EmpSal;
import com.yl.entity.EmpSalState;
import com.yl.entity.EmpType;
import com.yl.vo.EmpVo;

public class EmpDaoImpl extends DbUtil implements EmpDao {

	@Override
	public List<Emp> queryAll(int currentPage, int pageSize, EmpVo vo) {
		String sql = "select * from emp e left join  empType t on e.typeId = t.typeId left join empJob j on e.jobId = j.jobId left join empRole r on e.roleId = r.roleId left join (sal s left join salState s1 on s.salStateId = s1.salStateId) on e.empId = s.empId where 1=1";
		sql = setCondition(vo, sql);
		sql += " limit ? , ?";
		return super.excuteQuery(sql, map, (currentPage - 1) * pageSize , pageSize);
	}

	private String setCondition(EmpVo vo, String sql) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		if (vo != null) {
			if (vo.getBegin() != null ) {
				if (vo.getEnd() != null) {
					sql += " and empDate between '"+sdf.format(vo.getBegin())+"' and '"+sdf.format(vo.getEnd())+"'";
				}else {
					sql += " and empDate >= '"+sdf.format(vo.getBegin())+"'";					
				}
			}else {
				if (vo.getEnd() != null) {
					sql = " and empDate <= '"+sdf.format(vo.getEnd())+"'";
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
	public int register(Emp entity){
		String sql = "insert into emp(empId , empName ,empPwd) values(? ,? , ?)";
		return super.excuteUpdate(sql, entity.getEmpId() , entity.getEmpName() , entity.getEmpPwd());
		
	}

	@Override
	public int del(Object id) {
		String sql = "delete from emp where empId = ?";
		return super.excuteUpdate(sql, id);
	}

	@Override
	public int update(Emp entity) {
		String sql = "update emp set empName = ? , empPwd = ? , empSex = ? , empBorn = ? , empDate = ? , empNo = ? , empPhone = ? , typeId = ? , jobId = ? , roleId = ? where empId = ?";
		return super.excuteUpdate(sql, entity.getEmpName() , entity.getEmpPwd() , entity.getEmpSex() , entity.getEmpBorn() , entity.getEmpDate() , entity.getEmpNo() , entity.getEmpPhone() , entity.getEmpType().getTypeId() , entity.getEmpJob().getJobId() , entity.getEmpRole().getRoleId() , entity.getEmpId());
	}

	@Override
	public int getCount(EmpVo vo) {
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

	@Override
	public Emp findByEmpName(String empName) {
		String sql = "select * from emp e left join  empType t on e.typeId = t.typeId left join empJob j on e.jobId = j.jobId left join empRole r on e.roleId = r.roleId left join (sal s left join salState s1 on s.salStateId = s1.salStateId) on e.empId = s.empId where e.empName = ?";
		List<Emp> list = super.excuteQuery(sql, map, empName);
		return list.size() > 0 ? list.get(0) : null;
	}
}
