package com.yl.dao;

import java.util.List;

import com.yl.entity.Mess;
import com.yl.vo.MessVo;

public interface MessDao extends BaseDao<Mess, MessVo> {
	
	/**
	 * 分页查询
	 * @param currentPage
	 * @param pageSize
	 * @param vo
	 * @param empName
	 * @return
	 */
	List<Mess> findByEmpName(int currentPage, int pageSize, MessVo vo, String empName);
	
	/**
	 * 分页查询查询发件记录
	 * @param currentPage
	 * @param pageSize
	 * @param vo
	 * @param empName
	 * @return
	 */
	List<Mess> findByEmpName1(int currentPage, int pageSize, MessVo vo, String empName);
	
	/**
	 * 分页查询收件记录
	 * @param currentPage
	 * @param pageSize
	 * @param vo
	 * @param empName
	 * @return
	 */
	List<Mess> findByEmpName2(int currentPage, int pageSize, MessVo vo, String empName);
	
	/**
	 * 查询发件总条数
	 * @param vo
	 * @param empName
	 * @return
	 */
	int getCount1(MessVo vo ,String empName);
	
	/**
	 * 查询收件总条数
	 * @param vo
	 * @param empName
	 * @return
	 */
	int getCount2(MessVo vo ,String empName);
}
