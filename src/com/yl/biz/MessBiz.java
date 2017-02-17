package com.yl.biz;

import java.util.List;

import com.yl.entity.Mess;
import com.yl.vo.MessVo;

public interface MessBiz extends BaseBiz<Mess, MessVo> {
	List<Mess> findByEmpName(int currentPage, int pageSize, MessVo vo, String empName);
}
