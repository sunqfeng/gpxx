package com.gpxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gpxx.entity.EmailEnt;
import com.gpxx.entity.gpxxzb;
import com.gpxx.entity.jkgpxxzb;

public interface emailDao
{

	/**
	 * 查询email参数表中的所有数据
	 * @return
	 */
    EmailEnt sel_email_all();

}
