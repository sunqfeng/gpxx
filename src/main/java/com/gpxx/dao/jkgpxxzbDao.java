package com.gpxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gpxx.entity.gpxxzb;
import com.gpxx.entity.jkgpxxzb;

public interface jkgpxxzbDao
{

	/**
	 * 插入监控股票信息主表
	 * 
	 * @param 
	 * @param jkgpxxzb 
	 * @return 插入的行数
	 */
	int insertjkgpxxzb(jkgpxxzb stjkgpxxzb);

	/**
	 * 根据股票号，查询监控股票主表的所以信息
	 * @param gpid
	 * @return jkgpxxzb所以信息
	 */
	List<jkgpxxzb> sel_jkgpxxzb_gpid( @Param("gpid")String gpid );

	/**
	 * 
	 * 查询所有的股票信息(无条件)
	 * @return
	 */
	List<jkgpxxzb> sel_jkgpxxzb_all();

	/**
	 * 根据股票ID删除该股票信息
	 * @param gpid
	 * @return
	 */
	Integer del_gpxxzb_gpid(@Param("gpid")String gpid);


	/***
	 * 根据gpmc查询gpxxzb的信息
	 * @param gpmc
	 * @return
	 */

	List<jkgpxxzb> sel_jkgpxxzb_gpmc( @Param("gpmc")String gpmc );

	/* 根据gpid更新gpxxzb信息
	 * 
	 */
	Integer upd_gpxxzb_gpid(jkgpxxzb stjkgpxxzb );

	/**
	 * 查询需要监控的股票信息
	 * @return
	 */
	List<jkgpxxzb> sel_jkgpxxzb_sfjk_1(String sfjk);

	/**
	 * 根据gpid更新sfjk字段
	 * @param sfjk
	 * @param gpid
	 * @return
	 */
	Integer upd_gpxxzb_sfjk_gpid(String sfjk,String gpid);


	/**
	 * 根据股票名称进行模糊查询
	 * @param gpmc
	 * @return
	 */
	List<jkgpxxzb> sel_jkgpxxzb_like_gpmc(@Param("gpmc")String gpmc );

}
