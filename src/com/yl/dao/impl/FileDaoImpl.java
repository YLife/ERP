package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yl.dao.FileDao;
import com.yl.dao.ResultMapper;
import com.yl.entity.Emp1;
import com.yl.entity.Files;
import com.yl.entity.Pro1;
import com.yl.vo.FileVo;

public class FileDaoImpl extends DbUtil implements FileDao {

	@Override
	public List<Files> queryAll(int currentPage, int pageSize, FileVo vo) {
		String sql = "select * from file f left join pro p on f.proId = p.proId left join emp e on f.empId = e.empId where 1=1";
		sql = setCondition(vo, sql);
		sql += " limit ? ,?";
		return super.excuteQuery(sql, map, (currentPage -1) * pageSize , pageSize);
	}

	private String setCondition(FileVo vo, String sql) {
		if (vo != null) {
			if (vo.getFileName() != null ) {
				sql += " and fileName like '%"+vo.getFileName()+"%'";
			}
		}
		return sql;
	}

	@Override
	public Files queryById(Object id) {
		String sql = "select * from file f left join emp e on f.empId = e.empId left join pro p on f.proId = p.proId where fileId = £¿";
		List<Files> list = super.excuteQuery(sql, map, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int save(Files entity) {
		String sql = "insert into file values(? ,? ,?, ?, ?)";
		return super.excuteUpdate(sql, entity.getFileId() , entity.getFileName() ,entity.getUploadDate() , entity.getEmp1().getEmpId() , entity.getPro1().getProId());
	}

	@Override
	public int del(Object id) {
		String sql = "delete from file where fileId = ?";
		return super.excuteUpdate(sql, id);
	}

	@Override
	public int update(Files entity) {
		return 0;
	}

	@Override
	public int getCount(FileVo vo) {
		String sql = "select * from file f left join emp e on f.empId = e.empId left join pro p on f.proId = p.proId";
		List<Files> list = super.excuteQuery(sql, map);
		return list.size();
	}
	ResultMapper<Files> map = new ResultMapper<Files>() {
		
		@Override
		public Files resultMapping(ResultSet rs) {
			try {
				Files file = new Files(rs.getInt("fileId"), rs.getString("fileName"), rs.getDate("uploadDate"), new Emp1(rs.getInt("empId"), rs.getString("empName")), new Pro1(rs.getInt("proId"), rs.getString("proName")));
				return file;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
}
