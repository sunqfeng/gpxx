package com.gpxx.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpxx.entity.ReMsg;
import com.gpxx.entity.gpxxzb;
import com.gpxx.entity.jkgpxxzb;
import com.gpxx.entity.student;
import com.gpxx.service.impl.gpxxzbserviceimp;
import com.gpxx.service.impl.jkgpxxzbserviceimp;
import com.gpxx.service.impl.studentserviceimp;
import com.gpxx.service.impl.userinfoserviceimp;

@Controller
public class jkgpxxzbcontrol
{
	@Autowired
	private jkgpxxzbserviceimp stjkgpxxzb_imp;

	@Autowired
	private userinfoserviceimp stuserinfoimp;

	private ReMsg reMsg;

	/**
	 * 
	 * 只是负责跳转到监控股票信息的界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/jkgpxxzbview")
	public String studentview()
	{
		return "jkgpxx";
	}

	/**
	 * 
	 * 只是负责跳转到监控股票信息的界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/jkgpxx_zqb")
	public String jkgpxx_zqb()
	{
		return "jkgpxx_zqb";
	}

	/**
	 * 
	 * 只是负责跳转到vue界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/jkgpxx_index")
	public String jkgpxx_index(HttpServletRequest request)
	{
		String username = (String) request.getSession().getAttribute("username");
		System.out.println("sqf+session=" + username);

		if (username == null || username.equals(""))
		{
			System.out.println("该客户未登录请登录");
			return "login";
		}

		reMsg = stuserinfoimp.sel_userinfo_username(username);
		if (reMsg.getCode().equals("120"))
		{
			System.out.println("该客户未登录请登录");
			return "login";
		}

		return "index";
	}

	/**
	 * 
	 * 根据股票id号查询股票信息
	 * 
	 * @param model
	 * @return
	 */

	@RequestMapping("/sel_jkgpxxzb")
	@ResponseBody /* @ResponseBody 表明返回的是 json串;不加表明是页面跳转 */
	public List<jkgpxxzb> sel_jkgpxxzb(@RequestParam(value = "gpid", required = true, defaultValue = "") String gpid,
			@RequestParam(value = "gpmc", required = true, defaultValue = "") String gpmc, HttpServletRequest request)
	{

		List<jkgpxxzb> list_jkgpxxzb = new ArrayList<jkgpxxzb>();

		System.out.println("kong " + gpid + " kong " + gpmc);

		if (gpid.isEmpty() && !gpmc.isEmpty()) // 如果股票id号为空，股票名称不为空，那么用股票名称进行模糊查询
		{
			System.out.println("kong " + gpid + " kong " + gpmc);
			list_jkgpxxzb = stjkgpxxzb_imp.sel_jkgpxxzb_like_gpmc("%" + gpmc + "%");
		} else
		{
			list_jkgpxxzb = stjkgpxxzb_imp.sel_jkgpxxzb_gpid(gpid);
		}

		System.out.println("sqf===" + gpid + "|" + gpmc + "|");
		// 检查客户是否在线
		return list_jkgpxxzb;
	}

	/**
	 * 
	 * 插入需要查询的股票信息
	 * 
	 * @param model
	 * @return
	 */

	@RequestMapping("/insert_jkgpxxzb")
	@ResponseBody /* @ResponseBody 表明返回的是 json串;不加表明是页面跳转 */
	public int insert_jkgpxxzb(@RequestBody jkgpxxzb stjkgpxxzb) /* 后台要接受前台传入的json需要加 @RequestBody */
	{

		System.out.println("sqf===" + stjkgpxxzb.gpid + "|" + stjkgpxxzb.gpmc);
		int insert_result = stjkgpxxzb_imp.insertjkgpxxzb(stjkgpxxzb);
		return insert_result;
	}

	/**
	 * 
	 * 
	 * @param model
	 * @return
	 */

	@RequestMapping("/del_jkgpxxzb_gpid")
	@ResponseBody /* @ResponseBody 表明返回的是 json串;不加表明是页面跳转 */
	public int del_jkgpxxzb_gpid(@RequestBody jkgpxxzb stjkgpxxzb) /* 后台要接受前台传入的json需要加 @RequestBody */
	{

		System.out.println("sqf===" + stjkgpxxzb.gpid + "|" + stjkgpxxzb.gpmc);
		int insert_result = stjkgpxxzb_imp.del_gpxxzb_gpid(stjkgpxxzb.gpid);
		return insert_result;
	}

	/*
	 * 
	 * 
	 */
	@RequestMapping("/udp_jkgpxxzb_gpid")
	@ResponseBody /* @ResponseBody 表明返回的是 json串;不加表明是页面跳转 */
	public int udp_jkgpxxzb_gpid(@RequestBody jkgpxxzb stjkgpxxzb) /* 后台要接受前台传入的json需要加 @RequestBody */
	{

		System.out.println("sqf===" + stjkgpxxzb.gpid + "|" + stjkgpxxzb.gpmc);
		return stjkgpxxzb_imp.upd_gpxxzb_gpid(stjkgpxxzb);
	}

}
