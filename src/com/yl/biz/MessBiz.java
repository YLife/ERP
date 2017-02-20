package com.yl.biz;

import java.util.List;

import com.yl.entity.Mess;
import com.yl.vo.MessVo;

public interface MessBiz extends BaseBiz<Mess, MessVo> {
	/**
	 * 分页查询记录
	 * @param currentPage
	 * @param pageSize
	 * @param vo
	 * @param empName
	 * @return
	 */
	List<Mess> findByEmpName(int currentPage, int pageSize, MessVo vo, String empName);

	/**
	 * 查询发件总条数
	 * @param vo
	 * @param empName
	 * @return
	 */
	int getCount1(int pageSie , MessVo vo ,String empName);
	
	/**
	 * 查询收件总条数
	 * @param vo
	 * @param empName
	 * @return
	 */
	int getCount2(int pageSize ,MessVo vo ,String empName);
	
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
}
