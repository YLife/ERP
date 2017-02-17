package com.yl.dao;

import java.util.List;

import com.yl.entity.Mess;
import com.yl.vo.MessVo;

public interface MessDao extends BaseDao<Mess, MessVo> {
	List<Mess> findByEmpName(int currentPage, int pageSize, MessVo vo, String empName);
}
