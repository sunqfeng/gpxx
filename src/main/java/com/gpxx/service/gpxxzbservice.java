package com.gpxx.service;

import java.util.List;


import com.gpxx.entity.gpxxzb;

public interface gpxxzbservice
{

	/**
	 * 查询gpxxzb所有信息,根据股票号
	 * 
	 */

	List<gpxxzb> sel_gpxxzb_gpid(int gpid);

	/**
	 *  查询gpxxzb所有信息，无条件查询
	 * 
	 * @return
	 */
	List<gpxxzb> sel_gpxxzb_all();

	/**
	 * 
	 * 插入股票信息主表信息
	 * 
	 * @param gpid
	 * @param gpmc
	 * @param mrsj
	 * @param mrjg
	 * @param mcsj
	 * @param mcjg
	 * @param gpsl
	 * @param gpje
	 * @param gpts
	 * @param gpsy
	 * @return
	 */
	int insertgpxxzb(gpxxzb stgpxxzb);

	/**
	 * 根据股票id删除该股票信息 
	 * @param gpid
	 * @return
	 */
	Integer del_gpxxzb_gpid(String gpid);

	/**
	 * 
	 * 根据股票名称查询股票信息
	 * @param gpmc
	 * @return
	 */
	List<gpxxzb> sel_gpxxzb_gpmc(String gpmc);

}
