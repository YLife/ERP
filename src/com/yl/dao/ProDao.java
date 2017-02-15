package com.yl.dao;

import java.util.List;

import com.yl.entity.Pro;
import com.yl.entity.Pro1;
import com.yl.vo.ProVo;

public interface ProDao extends BaseDao<Pro, ProVo> {
	List<Pro1> queryPro1s();
}
