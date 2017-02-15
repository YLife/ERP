package com.yl.biz;

import com.yl.entity.Client;
import com.yl.vo.ClientVo;

/**
 * 业务层接口
 * @author Mr.Yang
 *
 */
public interface ClientBiz extends BaseBiz<Client, ClientVo>{
	/**
	 * 根据客户公司名称查询客户信息
	 * @param clientName
	 * @return
	 */
	Client findByClientComp(String clientComp);
}
