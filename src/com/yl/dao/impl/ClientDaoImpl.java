package com.yl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yl.dao.ClientDao;
import com.yl.dao.ResultMapper;
import com.yl.entity.Client;
import com.yl.vo.ClientVo;

public class ClientDaoImpl extends DbUtil implements ClientDao {

	/**
	 * 为sql语句添加条件信息
	 * @param vo 条件信息
	 * @param sql sql语句
	 * @return sql语句
	 */
	private String setCondition(ClientVo vo, String sql) {
		if (vo != null) {
			if (vo.getClientcomp() !=null && !"".equals(vo.getClientcomp())) {
				sql += " and clientComp = '"+vo.getClientcomp()+"'";
			}
		}
		return sql;
	}

	@Override
	public List<Client> queryAll(int currentPage, int pageSize, ClientVo vo) {
		String sql = "select * from client where 1=1";
		sql = setCondition(vo, sql);
		sql += " limit ? , ?";
		return super.excuteQuery(sql, map, (currentPage - 1) * pageSize , pageSize);
	}
	
	@Override
	public Client queryById(Object id) {
		String sql = "select * from client where clientId = ?";
		List<Client> list = super.excuteQuery(sql, map, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int save(Client entity) {
		String sql = "insert into client values(? , ? , ? , ? , ? , ?)";
		return super.excuteUpdate(sql, entity.getClientId() , entity.getClientName() ,entity.getClientComp() , entity.getClientPhone() , entity.getClientAdd() , entity.getClientBack() , entity.getClientDate());
	}

	@Override
	public int del(Object id) {
		String sql = "delete from client where clientId = ?";
		return super.excuteUpdate(sql, id);
	}

	@Override
	public int update(Client entity) {
		String sql = "update client set clientName = ? , clientComp = ? , clientPhone = ? , clientAdd = ? , clientBack = ? , clientDate = ? where clientId = ?";
		return super.excuteUpdate(sql, entity.getClientName() , entity.getClientComp() , entity.getClientPhone() , entity.getClientAdd() , entity.getClientBack() , entity.getClientDate() , entity.getClientId());
	}

	@Override
	public int getCount(ClientVo vo) {
		String sql = "select * from client where 1=1";
		this.setCondition(vo, sql);
		List<Client> list = super.excuteQuery(sql, map);
		return list.size();
	}
	
	ResultMapper<Client> map = new ResultMapper<Client>() {
		
		@Override
		public Client resultMapping(ResultSet rs) {
			try {
				Client entity = new Client(rs.getInt("clientId"), rs.getString("clientName"), rs.getString("clientComp"), rs.getString("clientPhone"), rs.getString("clientAdd"), rs.getString("clientBack") , rs.getDate("clientDate"));
				return entity;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
}
