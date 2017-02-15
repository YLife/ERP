package com.yl.dao;

import com.yl.entity.Client;
import com.yl.vo.ClientVo;

public interface ClientDao extends BaseDao<Client , ClientVo> {
	/**
	 * ͨ���ͻ���˾���Ʋ�ѯ�ͻ���Ϣ
	 * @param clientName
	 * @return
	 */
	Client findByClientComp(String clientComp);
}
