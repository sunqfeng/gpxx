package com.gpxx.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.gpxx.entity.gpxxzb;
import com.gpxx.service.impl.gpxxzbserviceimp;

@Controller
public class gpxxzbcontrol
{
	@Autowired
	private gpxxzbserviceimp gpxxzbimp;


	/*
	 *  页面跳转至股票买卖登记页面 
	 */
	@RequestMapping("/regis_gpxxzb")
	private String regis_gpxxzb()
	{

		return "regis_gpxxzb";

	}

	/**
	 * 
	 * 根据gpxxid查询股票信息表
	 * @param model
	 * @return
	 */
	@RequestMapping("/sel_gpxxzb_gpxxid")
	@ResponseBody /* @ResponseBody 表明返回的是 json串;不加表明是页面跳转 */
	private List<gpxxzb> sel_gpxxzb_gpxxid(@RequestBody gpxxzb stGpxxzb_in)
	{
		System.out.println("sqf 2020年6月14日16:18:18  ="+stGpxxzb_in.getGpxxid());
		List<gpxxzb> stGpxxzb = new ArrayList<gpxxzb>() ;
		stGpxxzb =  gpxxzbimp.sel_gpxxzb_gpid(stGpxxzb_in.getGpxxid());
		return stGpxxzb;
	}


	/**
	 * 插入gpxxzb信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/insert_gpxxzb")
	@ResponseBody
	public  List<gpxxzb> insert_gpxxzb(@RequestBody  gpxxzb stgpxxzb)
	{
		List<gpxxzb> list_gpxxzb = new ArrayList<gpxxzb>();
		System.out.println("sqf insert_gpxxzb 000"+stgpxxzb.getGpxxid());
		gpxxzbimp.insertgpxxzb(stgpxxzb); //插入股票交易信息
		//插入股票交易信息以后，进行股票信息查询
		list_gpxxzb = gpxxzbimp.sel_gpxxzb_gpid(stgpxxzb.getGpxxid());

		return list_gpxxzb; /*control 层内跳转*/
	}

	/**
	 * 根据股票id号删除该股票的信息
	 * @param stgpxxzb
	 * @return
	 */
	@RequestMapping("/del")
	@ResponseBody
	public  String del_gpxxzb_gpid(@RequestBody  gpxxzb stgpxxzb)
	{
		System.out.println( "sqf1111="+stgpxxzb.getGpxxid() );
		gpxxzbimp.del_gpxxzb_gpid(stgpxxzb.getGpxxid());
		return "redirect:/all"; /*control 层内跳转*/
	}

	/**
	 * 
	 *  更新股票信息表
	 * @param model
	 * @return
	 */
	@RequestMapping("/upd_gpxxzb_gpid")
	@ResponseBody /* @ResponseBody 表明返回的是 json串;不加表明是页面跳转 */
	public List<gpxxzb> upd_gpxxzb_gpid(@RequestBody  gpxxzb stgpxxzb)
	{

		List<gpxxzb> list_Gpxxzb = new ArrayList<gpxxzb>();

		System.out.println("update sqf ="+stgpxxzb.toString());
		Integer result = gpxxzbimp.upd_gpxxzb_gpid(stgpxxzb);

		list_Gpxxzb = gpxxzbimp.sel_gpxxzb_gpid(stgpxxzb.getGpxxid());

		return list_Gpxxzb; 
	}

}
