package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yl.dao.MessDao;
import com.yl.dao.ResultMapper;
import com.yl.entity.Mess;
import com.yl.vo.MessVo;

public class MessDaoImpl extends DbUtil implements MessDao {
	
	@Override
	public List<Mess> queryAll(int currentPage, int pageSize, MessVo vo) {
		return null;
	}
	
	@Override
	public List<Mess> findByEmpName(int currentPage, int pageSize, MessVo vo, String empName) {
		String sql = "select * from mess where 1=1";
		sql += " and (sendName = '"+empName+"' or getName = '"+empName+"')";
		sql = setCondition(vo, sql);
		sql += " limit ?, ?";
		return super.excuteQuery(sql, map, (currentPage - 1) * pageSize ,pageSize);
	}
	
	private String setCondition(MessVo vo, String sql) {
		if (vo != null) {
			if (vo != null) {
				if (vo.getBegin() != null ) {
					if (vo.getEnd() != null) {
						sql += " and sendDate between '"+vo.getBegin()+"' and '"+vo.getEnd()+"'";
					}else {
						sql += " and sendDate >= '"+vo.getBegin()+"'";					
					}
				}else {
					if (vo.getEnd() != null) {
						sql += " and sendDate <= '"+vo.getEnd()+"'";
					}
				}
			}
		}
		return sql;
	}

	@Override
	public Mess queryById(Object id) {
		String sql = "select * from mess where messId = ?";
		List<Mess> list = super.excuteQuery(sql, map, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int save(Mess entity) {
		String sql = "insert into mess values(? ,?, ?, ?, ?, ?, ?)";
		return super.excuteUpdate(sql, entity.getMessId(),entity.getMessTitle(),entity.getMessContent(),entity.getSendName(),entity.getGetName(),entity.getSendDate(),entity.getGetDate());
	}

	@Override
	public int del(Object id) {
		String sql = "delete from mess where messId = ?";
		return super.excuteUpdate(sql, id);
	}

	@Override
	public int update(Mess entity) {
		return 0;
	}

	@Override
	public int getCount(MessVo vo) {
		String sql = "select * from mess where 1=1";
		sql = this.setCondition(vo, sql);
		List<Mess> list = super.excuteQuery(sql, map);
		return list.size();
	}
	
	ResultMapper<Mess> map = new ResultMapper<Mess>() {
		
		@Override
		public Mess resultMapping(ResultSet rs) {
			try {
				Mess mess = new Mess(rs.getInt("messId"), rs.getString("messTitle"), rs.getString("messContent"), rs.getString("sendName"), rs.getString("getName"), rs.getDate("sendDate"), rs.getDate("getDate"));
				return mess;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};

}
