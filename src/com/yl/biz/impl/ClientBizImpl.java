package com.yl.biz.impl;

import java.util.List;

import com.yl.biz.ClientBiz;
import com.yl.dao.ClientDao;
import com.yl.dao.impl.ClientDaoImpl;
import com.yl.entity.Client;
import com.yl.vo.ClientVo;

public class ClientBizImpl implements ClientBiz {
	
	private ClientDao dao = new ClientDaoImpl();
	
	@Override
	public List<Client> findAll(int currentPage, int pageSize, ClientVo vo) {
		System.out.println(vo.getClientcomp());
		return dao.queryAll(currentPage, pageSize, vo);
	}

	@Override
	public Client findById(Object id) {
		return dao.queryById(id);
	}

	@Override
	public int save(Client entity) {
		return dao.save(entity);
	}

	@Override
	public int del(Object id) {
		return dao.del(id);
	}

	@Override
	public int update(Client entity) {
		return dao.update(entity);
	}

	@Override
	public int getTotalPage(int pageSize , ClientVo vo) {
		return (dao.getCount(vo) - 1) / pageSize + 1;
	}

}
