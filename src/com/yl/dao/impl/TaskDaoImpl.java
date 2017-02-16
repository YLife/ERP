package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yl.dao.ResultMapper;
import com.yl.dao.TaskDao;
import com.yl.entity.Emp1;
import com.yl.entity.Priority;
import com.yl.entity.Pro1;
import com.yl.entity.ProFun1;
import com.yl.entity.ProMod1;
import com.yl.entity.Task;
import com.yl.vo.TaskVo;

public class TaskDaoImpl extends DbUtil implements TaskDao {

	@Override
	public List<Task> queryAll(int currentPage, int pageSize, TaskVo vo) {
		String sql = "select * from task t left join emp e on t.empId = e.empId left join pro p on t.proId = p.proId left join `mod` m on t.modId = m.modId left join fun f on t.funId = f.funId left join priority p1 on t.priorityId = p1.priorityId where 1=1";
		sql = setCondition(vo, sql);
		sql += " limit ? ,?";
		return super.excuteQuery(sql, map, (currentPage - 1) * pageSize , pageSize);
	}

	private String setCondition(TaskVo vo, String sql) {
		if (vo != null) {
			if (vo != null) {
				if (vo.getBegin() != null ) {
					if (vo.getEnd() != null) {
						sql += " and taskCreateDate between '"+vo.getBegin()+"' and '"+vo.getEnd()+"'";
					}else {
						sql += " and taskCreateDate >= '"+vo.getBegin()+"'";					
					}
				}else {
					if (vo.getEnd() != null) {
						sql += " and taskCreateDate <= '"+vo.getEnd()+"'";
					}
				}
			}
		}
		return sql;
	}

	@Override
	public Task queryById(Object id) {
		String sql = "select * from task t left join emp e on t.empId = e.empId left join pro p on t.proId = p.proId left join `mod` m on t.modId = m.modId left join fun f on t.funId = f.funId left join priority p1 on t.priorityId = p1.priorityId where taskId = ?";
		List<Task> list = super.excuteQuery(sql, map, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int save(Task entity) {
		String sql = "insert into task values(? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
		return super.excuteUpdate(sql, entity.getTaskId() , entity.getTaskName() , entity.getPro1().getProId() , entity.getMod1().getModId(), entity.getFun1().getFunId(),entity.getEmp1().getEmpId() ,entity.getPriority().getPriorityId() ,entity.getCreateDate(),entity.getEndDate() ,entity.getTaskNote());
	}

	@Override
	public int del(Object id) {
		String sql = "delete from task where taskId = ?";
		return super.excuteUpdate(sql, id);
	}

	@Override
	public int update(Task entity) {
		String sql = "update task set taskName = ? , proId = ? ,modId = ? ,funId = ? , empId = ? , priorityId = ? ,taskCreateDate = ? ,taskEndDate = ? ,taskNote = ? where taskId = ?";
		return super.excuteUpdate(sql, entity.getTaskName() , entity.getPro1().getProId() , entity.getMod1().getModId(), entity.getFun1().getFunId(),entity.getEmp1().getEmpId() ,entity.getPriority().getPriorityId() ,entity.getCreateDate(),entity.getEndDate() ,entity.getTaskNote(), entity.getTaskId() );
	}

	@Override
	public int getCount(TaskVo vo) {
		String sql = "select * from task t left join emp e on t.empId = e.empId left join pro p on t.proId = p.proId left join `mod` m on t.modId = m.modId left join fun f on t.funId = f.funId left join priority p1 on t.priorityId = p1.priorityId";
		List<Task> list = super.excuteQuery(sql, map);
		return list.size();
	}
	
	ResultMapper<Task> map = new ResultMapper<Task>() {
		
		@Override
		public Task resultMapping(ResultSet rs) {
			try {
				Pro1 pro1 = new Pro1(rs.getInt("proId"), rs.getString("proName"));
				ProMod1 mod1 = new ProMod1(rs.getInt("modId"), rs.getString("modName"), pro1);
				ProFun1 fun1 = new ProFun1(rs.getInt("funId"), rs.getString("funName"));
				Emp1 emp1 = new Emp1(rs.getInt("empId"), rs.getString("empName"));
				Priority priority = new Priority(rs.getInt("priorityId"), rs.getString("priorityName"));
				Task task = new Task(rs.getInt("taskId"), rs.getString("taskName"), pro1 , mod1 , fun1, emp1, priority, rs.getDate("taskCreateDate"), rs.getDate("taskEndDate"), rs.getString("taskNote"));
				return task;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
}
