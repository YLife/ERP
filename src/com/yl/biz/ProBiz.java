package com.yl.biz;

import java.util.List;

import com.yl.entity.Pro;
import com.yl.entity.Pro1;
import com.yl.vo.ProVo;

public interface ProBiz extends BaseBiz<Pro, ProVo> {
	List<Pro1> findPro1s();
}
