package com.yl.biz;

import java.util.List;

import com.yl.entity.Mess;
import com.yl.vo.MessVo;

public interface MessBiz extends BaseBiz<Mess, MessVo> {
	/**
	 * ��ҳ��ѯ��¼
	 * @param currentPage
	 * @param pageSize
	 * @param vo
	 * @param empName
	 * @return
	 */
	List<Mess> findByEmpName(int currentPage, int pageSize, MessVo vo, String empName);

	/**
	 * ��ѯ����������
	 * @param vo
	 * @param empName
	 * @return
	 */
	int getCount1(int pageSie , MessVo vo ,String empName);
	
	/**
	 * ��ѯ�ռ�������
	 * @param vo
	 * @param empName
	 * @return
	 */
	int getCount2(int pageSize ,MessVo vo ,String empName);
	
	/**
	 * ��ҳ��ѯ��ѯ������¼
	 * @param currentPage
	 * @param pageSize
	 * @param vo
	 * @param empName
	 * @return
	 */
	List<Mess> findByEmpName1(int currentPage, int pageSize, MessVo vo, String empName);
	
	/**
	 * ��ҳ��ѯ�ռ���¼
	 * @param currentPage
	 * @param pageSize
	 * @param vo
	 * @param empName
	 * @return
	 */
	List<Mess> findByEmpName2(int currentPage, int pageSize, MessVo vo, String empName);
}
