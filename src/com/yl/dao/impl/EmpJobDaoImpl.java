package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yl.dao.EmpJobDao;
import com.yl.dao.ResultMapper;
import com.yl.entity.EmpJob;
import com.yl.vo.EmpJobVo;

public class EmpJobDaoImpl extends DbUtil implements EmpJobDao {

	@Override
	public List<EmpJob> queryAll(int currentPage, int pageSize, EmpJobVo vo) {
		String sql = "select * from empJob limit ? , ?";
		return super.excuteQuery(sql, map, (currentPage - 1) * pageSize, pageSize);
	}

	@Override
	public EmpJob queryById(Object id) {
		String sql = "select * from empJob where jobId = ?"; 
		List<EmpJob> list = super.excuteQuery(sql, map, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int save(EmpJob entity) {
		String sql = "insert into empJob values(? , ? )";
		return super.excuteUpdate(sql, entity.getJobId() , entity.getJobName() );
	}

	@Override
	public int del(Object id) {
		String sql = "delete from empJOb where jobId = ?";
		return super.excuteUpdate(sql, id);
	}

	@Override
	public int update(EmpJob entity) {
		String sql = "update empRole set jobName = ? where jobId = ?";
		return super.excuteUpdate(sql, entity.getJobName() , entity.getJobId());
	}

	@Override
	public int getCount(EmpJobVo vo) {
		String sql = "select * from empJob";
		List<EmpJob> list = super.excuteQuery(sql, map);
		return list.size();
	}
	ResultMapper<EmpJob> map = new ResultMapper<EmpJob>() {
		
		@Override
		public EmpJob resultMapping(ResultSet rs) {
			try {
				EmpJob entity = new EmpJob(rs.getInt("jobId"), rs.getString("jobName"));
				return entity;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
}
