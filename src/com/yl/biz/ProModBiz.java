package com.yl.biz;

import java.util.List;

import com.yl.entity.ProMod;
import com.yl.entity.ProMod1;
import com.yl.vo.ProModVo;

public interface ProModBiz extends BaseBiz<ProMod, ProModVo> {
	/**
	 * ��ѯ���м�¼
	 * @return
	 */
	List<ProMod1> findAlls();
}
