package com.gpxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpxx.dao.gpxxzbDao;
import com.gpxx.entity.gpxxzb;
import com.gpxx.service.gpxxzbservice;

/**
 * serviceimp主要是调用dao层的方法
 * @author sunqifeng
 *
 */

@Service
public class gpxxzbserviceimp implements gpxxzbservice 
{

	@Autowired
	private gpxxzbDao gpxxzbdao;

	public List<gpxxzb> sel_gpxxzb_gpid(String gpid)
	{
		// TODO Auto-generated method stub
		List<gpxxzb> listgpxxzb = new ArrayList<gpxxzb>();
		listgpxxzb =  gpxxzbdao.sel_gpxxzb_gpid(gpid);

		return listgpxxzb;
	}

	public List<gpxxzb> sel_gpxxzb_all()
	{
		// TODO Auto-generated method stub
		
		List<gpxxzb> listgpxxzb = new ArrayList<gpxxzb>();
		listgpxxzb =  gpxxzbdao.sel_gpxxzb_all();
		return listgpxxzb;
	}

	public int insertgpxxzb(gpxxzb stgpxxzb)
	{
		// TODO Auto-generated method stub
		gpxxzbdao.insertgpxxzb(stgpxxzb);
		return 0;
	}

	public Integer del_gpxxzb_gpid(String gpid)
	{
		return gpxxzbdao.del_gpxxzb_gpid(gpid);
	}

	public List<gpxxzb> sel_gpxxzb_gpmc(String gpmc)
	{
		return gpxxzbdao.sel_gpxxzb_gpmc(gpmc);
	}

	public Integer upd_gpxxzb_gpid(gpxxzb stgpxxzb)
	{
		return gpxxzbdao.upd_gpxxzb_gpid(stgpxxzb);
	}

}
