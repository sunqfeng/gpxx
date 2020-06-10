package com.gpxx.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;

import com.gpxx.BaseTest;
import com.gpxx.entity.jkgpxxzb;
import com.gpxx.monitordata.monitorgp;
import com.gpxx.service.impl.jkgpxxzbserviceimp;

public class studentdaoTest extends BaseTest
{

	@Autowired
	//private jkgpxxzbDao jkgpxxzbdao;
	//private jkgpxxzbserviceimp stjkgpxxzb;
	private monitorgp moni;
	// private userinfoDao userinfodao;

	@SuppressWarnings("unchecked")
	@Test
	public void testsqf()
	{
		jkgpxxzb stJkgpxxzb = new jkgpxxzb();
		List<jkgpxxzb> objlist = new ArrayList<jkgpxxzb>();
		// userinfo stuserinfo = new userinfo();
		try
		{
			// stuserinfo = userinfodao.sel_userinfo_username("sqf");
			//objlist = jkgpxxzbdao.sel_jkgpxxzb_sfjk_1();
			//objlist = stjkgpxxzb.sel_jkgpxxzb_gpid("300348");
			moni.monitor_gp();
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=0;i<objlist.size();i++)
		{
			System.out.println("sqf="+objlist.get(i));
		}

	}

}
