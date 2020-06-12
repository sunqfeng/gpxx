package com.gpxx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpxx.dao.userinfoDao;
import com.gpxx.entity.ReMsg;
import com.gpxx.entity.userinfo;
import com.gpxx.pub.userinfopub;
import com.gpxx.service.userinfoservice;

@Service
public class userinfoserviceimp implements userinfoservice
{

	@Autowired
	private userinfoDao userinfodao;

	ReMsg remsg = new ReMsg();

	userinfopub stuserinfopub = new userinfopub();

	public userinfo sel_userinfo_userid(String userid)
	{
		return userinfodao.sel_userinfo_userid(userid);
	}

	/**
	 * 通过用户名查询用户信息
	 */
	public ReMsg sel_userinfo_username(String username)
	{
		// TODO Auto-generated method stub
		userinfo stuserinfo = new userinfo();
		stuserinfo = userinfodao.sel_userinfo_username(username);
		if(stuserinfo == null || stuserinfo.getUsername().equals("") )
		{
			remsg.setCode("110");
			remsg.setMsg("该用户不存在");
		}

		if (!stuserinfo.getLoginstatus().equals("1")) //1:登录状态;0:为登录
		{
			remsg.setCode("120");
			remsg.setMsg("该客户未登录");
		}

		if (stuserinfo.getUsername().trim().equals(username.trim()) ) //该用户已经存在
		{
			remsg.setCode("130");
			remsg.setMsg("该用户已经存在");
		}


		return remsg;
	}

	public ReMsg sel_userinfo_username_and_passwd(String username, String passwd)
	{
		// TODO Auto-generated method stub
		
		userinfo stUserinfo = new userinfo();
		stUserinfo = userinfodao.sel_userinfo_username_and_passwd(username, passwd);
		if (stUserinfo == null)
		{
			remsg.setCode("110");
			remsg.setMsg("该用户不存在!!");
		}
		else
		{
			remsg.setCode("000");
			remsg.setMsg("该用户存在");
		}

		return remsg;
	}

	/**
	 * 用户注册
	 */

	public ReMsg insert_userinfo(userinfo stUserinfo)
	{
		// TODO Auto-generated method stub

		String obj = stuserinfopub.scuserid();//生成userid

		stUserinfo.setUserid(obj); //生成userid
		stUserinfo.setRole("1"); //普通人员1
		stUserinfo.setLoginstatus("1"); //注册以后默认状态为登录1,0:销户状态

		Integer result = userinfodao.insert_userinfo(stUserinfo);
		if (result != 1 )
		{
			remsg.setCode("120");
			remsg.setMsg("用户信息插入失败!!!!!!!");
		}
		else
		{
			remsg.setCode("000");
			remsg.setMsg("用户信息插入成功!!!!");
		}

		System.out.println("insert_userinfo="+result);
		return remsg;
	}

	public Integer upd_userinfo_loginstatus_username(String loginstatus, String username)
	{
		// TODO Auto-generated method stub
		return userinfodao.upd_userinfo_loginstatus_username(loginstatus, username);
	}

}
