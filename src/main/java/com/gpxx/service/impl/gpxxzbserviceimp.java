package com.gpxx.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpxx.dao.gpxxzbDao;
import com.gpxx.entity.WebGpxx;
import com.gpxx.entity.gpxxzb;
import com.gpxx.pub.DayClass;
import com.gpxx.pub.GetGpxx;
import com.gpxx.service.gpxxzbservice;

/**
 * serviceimp主要是调用dao层的方法
 * 
 * @author sunqifeng
 *
 */

@Service
public class gpxxzbserviceimp implements gpxxzbservice
{

	@Autowired
	private gpxxzbDao gpxxzbdao;

	GetGpxx stGetGpxx = new GetGpxx();

	/**
	 * 
	 */
	public List<gpxxzb> sel_gpxxzb_gpid(String gpid)
	{
		// TODO Auto-generated method stub
		List<gpxxzb> listgpxxzb = new ArrayList<gpxxzb>();
		listgpxxzb = gpxxzbdao.sel_gpxxzb_gpid(gpid);

		return listgpxxzb;
	}

	/**
	 * 
	 */

	public List<gpxxzb> sel_gpxxzb_all()
	{
		// TODO Auto-generated method stub

		List<gpxxzb> listgpxxzb = new ArrayList<gpxxzb>();
		listgpxxzb = gpxxzbdao.sel_gpxxzb_all();
		return listgpxxzb;
	}

	/**
	 * 
	 */
	public int insertgpxxzb(gpxxzb stgpxxzb)
	{

		DayClass dayClass = new DayClass();
		WebGpxx webGpxx = new WebGpxx();

		// 给买入时间加上时间戳
		SimpleDateFormat df = new SimpleDateFormat("HHmmss");// 设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳

		webGpxx = stGetGpxx.doget(stgpxxzb.getGpxxid()); // 查询股票信息

		stgpxxzb.setGpmc(webGpxx.getGpmc()); // 赋值股票名称

		stgpxxzb.setGpje(stgpxxzb.getMrjg() * stgpxxzb.getGpsl()); // 赋值购买股票总金额

		stgpxxzb.setMrsj(stgpxxzb.getMrsj() + date); // 卖出时间加上+时分秒

		// 计算买入日期与卖出日期的相差天数
		if (!stgpxxzb.getMrsj().trim().isEmpty() && !stgpxxzb.getMcsj().trim().isEmpty())
		{
			try
			{
				stgpxxzb.setGpts(dayClass.DayDiff(stgpxxzb.getMrsj().substring(0, 8), stgpxxzb.getMcsj()));
			} catch (ParseException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		gpxxzbdao.insertgpxxzb(stgpxxzb);
		return 0;
	}

	/**
	 * 
	 */
	public Integer del_gpxxzb_gpid(String gpid)
	{
		return gpxxzbdao.del_gpxxzb_gpid(gpid);
	}

	public List<gpxxzb> sel_gpxxzb_gpmc(String gpmc)
	{
		return gpxxzbdao.sel_gpxxzb_gpmc(gpmc);
	}

	/**
	 * 
	 */
	public Integer upd_gpxxzb_gpid(gpxxzb stgpxxzb)
	{

		DayClass dayClass = new DayClass();
		if (!stgpxxzb.getMcsj().trim().isEmpty() && stgpxxzb.getMcjg() > 0.0) // 只有卖出时间不为空，卖出价格大于0.0才计算股票收益
		{
			stgpxxzb.setGpsy(stgpxxzb.getMcjg() * stgpxxzb.getGpsl() - stgpxxzb.getMrjg() * stgpxxzb.getGpsl()); // 计算收益
		}

		// 计算买入日期与卖出日期的相差天数
		if (!stgpxxzb.getMrsj().trim().isEmpty() && !stgpxxzb.getMcsj().trim().isEmpty())
		{
			try
			{
				Integer day = dayClass.DayDiff(stgpxxzb.getMrsj().substring(0, 8), stgpxxzb.getMcsj());
				System.out.println("sqf day="+day);
				stgpxxzb.setGpts(day);
			} catch (ParseException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return gpxxzbdao.upd_gpxxzb_gpid(stgpxxzb);
	}

}
