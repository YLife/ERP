package com.yl.biz;

import com.yl.entity.Client;
import com.yl.vo.ClientVo;

/**
 * ҵ���ӿ�
 * @author Mr.Yang
 *
 */
public interface ClientBiz extends BaseBiz<Client, ClientVo>{
	/**
	 * ���ݿͻ���˾���Ʋ�ѯ�ͻ���Ϣ
	 * @param clientName
	 * @return
	 */
	Client findByClientComp(String clientComp);
}
