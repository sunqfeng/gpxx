package com.gpxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpxx.dao.gpxxzbDao;
import com.gpxx.dao.jkgpxxzbDao;
import com.gpxx.entity.WebGpxx;
import com.gpxx.entity.gpxxzb;
import com.gpxx.entity.jkgpxxzb;
import com.gpxx.pub.GetGpxx;
import com.gpxx.service.gpxxzbservice;
import com.gpxx.service.jkgpxxzbservice;

/**
 * serviceimp主要是调用dao层的方法
 * 
 * @author sunqifeng
 *
 */

@Service
public class jkgpxxzbserviceimp implements jkgpxxzbservice
{

	@Autowired
	private jkgpxxzbDao stjkgpxxzbdao;
//	private GetGpxx getgpxxpub;
	GetGpxx getGpxx = new GetGpxx();

	WebGpxx webgpxx = null;

	public int insertjkgpxxzb(jkgpxxzb stjkgpxxzb)
	{
		// TODO Auto-generated method stub
		/*
		600为沪市
		000开头为深市（还有几个001）
		002开头是深市中小板
		300开头为深市创业板
		*/

//		String url ="http://hq.sinajs.cn/list="; //新浪股票url
//		WebGpxx webgpxx = null;
		webgpxx = getGpxx.doget(stjkgpxxzb.getGpid());

//		if ( stjkgpxxzb.getGpid().substring(0, 1).equalsIgnoreCase("6") ||
//				stjkgpxxzb.getGpid().substring(0, 3).equalsIgnoreCase("900") ||
//				stjkgpxxzb.getGpid().substring(0, 3).equalsIgnoreCase("730") ||
//				stjkgpxxzb.getGpid().substring(0, 3).equalsIgnoreCase("700") 
//				)
//		{
//			webgpxx = GetGpxx.doget(url+"sh"+stjkgpxxzb.getGpid()); //先用上海查询
//		}
//		else
//		{
//			webgpxx = GetGpxx.doget(url+"sz"+stjkgpxxzb.getGpid()); //查询不到，再用深圳查询
//
//			if (webgpxx.getGpmc().equals("no")) //还是没有查询到
//			{
//				return 0;
//			}
//		}

		//赋值股票名称，股票当前价格
		stjkgpxxzb.setGpmc(webgpxx.getGpmc());
		stjkgpxxzb.setDqjg(webgpxx.getDqjg());
		stjkgpxxzb.setJkcs(1); //默认监控次数为1

		int insert_result = stjkgpxxzbdao.insertjkgpxxzb(stjkgpxxzb);

		return insert_result;
	}

	public List<jkgpxxzb> sel_jkgpxxzb_gpid(String gpid)
	{
		// TODO Auto-generated method stub
		List<jkgpxxzb> list_jkgpxxzb = new ArrayList<jkgpxxzb>();
		System.out.println("sqf000" + gpid);
		list_jkgpxxzb = stjkgpxxzbdao.sel_jkgpxxzb_gpid(gpid);

		for(int i=0;i<list_jkgpxxzb.size();i++) //查询当前股票最新的价格
		{
//			list_jkgpxxzb.get(i).getGpid()
			webgpxx = getGpxx.doget(list_jkgpxxzb.get(i).getGpid());
			list_jkgpxxzb.get(i).setDqjg(webgpxx.getDqjg());
		}


		return list_jkgpxxzb;
	}

	public List<jkgpxxzb> sel_jkgpxxzb_all()
	{
		// TODO Auto-generated method stub
		List<jkgpxxzb> list_jkgpxxzb = new ArrayList<jkgpxxzb>();
		list_jkgpxxzb = stjkgpxxzbdao.sel_jkgpxxzb_all();
		return list_jkgpxxzb;
	}

	public Integer del_gpxxzb_gpid(String gpid)
	{
		// TODO Auto-generated method stub
		return  stjkgpxxzbdao.del_gpxxzb_gpid(gpid);
	}

	public List<jkgpxxzb> sel_jkgpxxzb_gpmc(String gpmc)
	{
		// TODO Auto-generated method stub
		List<jkgpxxzb> list_jkgpxxzb = new ArrayList<jkgpxxzb>();
		list_jkgpxxzb = stjkgpxxzbdao.sel_jkgpxxzb_gpmc(gpmc);
		return list_jkgpxxzb;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gpxx.service.jkgpxxzbservice#upd_gpxxzb_gpid(com.gpxx.entity.jkgpxxzb)
	 * 
	 */
	public Integer upd_gpxxzb_gpid(jkgpxxzb stjkgpxxzb)
	{

		return stjkgpxxzbdao.upd_gpxxzb_gpid(stjkgpxxzb);
	}

	/**
	 * 
	 */
	public List<jkgpxxzb> sel_jkgpxxzb_sfjk_1(String sfjk )
	{

		return stjkgpxxzbdao.sel_jkgpxxzb_sfjk_1(sfjk);
	}

}
