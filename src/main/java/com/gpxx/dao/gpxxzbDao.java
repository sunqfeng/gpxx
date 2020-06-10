package com.gpxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gpxx.entity.gpxxzb;

public interface gpxxzbDao
{

	/**
	 * 插入股票信息主表
	 * 
	 * @param 
	 * @param gpxxzb 
	 * @return 插入的行数
	 */
//	int insertgpxxzb(@Param("gpid") String gpid, @Param("gpmc") String gpmc,@Param("mrsj") String mrsj,@Param("mrjg") double mrjg,@Param("mcsj") String mcsj,@Param("mcjg") double mcjg,@Param("gpsl") Integer gpsl,@Param("gpje") double gpje,@Param("gpts") Integer gpts,@Param("gpsy") double gpsy );
	int insertgpxxzb(gpxxzb stgpxxzb);

	/**
	 * 根据股票号，查询股票主表的所以信息
	 * @param gpid
	 * @return gpxxzb所以信息
	 */
	List<gpxxzb> sel_gpxxzb_gpid( @Param("gpid")int gpid );

	/**
	 * 
	 * 查询所有的股票信息(无条件)
	 * @return
	 */
	List<gpxxzb> sel_gpxxzb_all();

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

	List<gpxxzb> sel_gpxxzb_gpmc( @Param("gpmc")String gpmc );

}
