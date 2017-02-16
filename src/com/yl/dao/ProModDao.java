package com.yl.dao;

import java.util.List;

import com.yl.entity.ProMod;
import com.yl.entity.ProMod1;
import com.yl.vo.ProModVo;

public interface ProModDao extends BaseDao<ProMod, ProModVo> {
	/**
	 * 查询所有模块
	 * @return
	 */
	List<ProMod1> findAlls();
}
