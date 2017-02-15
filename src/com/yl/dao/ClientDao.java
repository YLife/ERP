package com.yl.dao;

import com.yl.entity.Client;
import com.yl.vo.ClientVo;

public interface ClientDao extends BaseDao<Client , ClientVo> {
	/**
	 * 通过客户公司名称查询客户信息
	 * @param clientName
	 * @return
	 */
	Client findByClientComp(String clientComp);
}
