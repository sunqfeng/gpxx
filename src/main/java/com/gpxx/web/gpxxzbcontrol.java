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

	/**
	 * 
	 * 显示所有股票的信息，不进行分页
	 * @param model
	 * @return
	 */
	@RequestMapping("/sqf")
//	@ResponseBody /* @ResponseBody 表明返回的是 json串;不加表明是页面跳转 */
	private String list(Model model)
	{

		int gpid = 1;
		List<gpxxzb> gpxxzb_list = new ArrayList<gpxxzb>();

		gpxxzb_list = gpxxzbimp.sel_gpxxzb_gpid(gpid);

		model.addAttribute("gpxxzb", gpxxzb_list);
		return "index2";

	}

	/*
	 * 查询返回所有的
	 * 
	 * 
	 */
	@RequestMapping("/all")
	private String all(Model model)
	{

//		List<gpxxzb> gpxxzb_list = new ArrayList<gpxxzb>();
//
//		gpxxzb_list = gpxxzbimp.sel_gpxxzb_all();
//		model.addAttribute("gpxxzb", gpxxzb_list);
		return "index2";

	}

	/**
	 * 插入gpxxzb信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public  String insert(@RequestBody  gpxxzb stgpxxzb)
	{
		gpxxzbimp.insertgpxxzb(stgpxxzb);
		return "redirect:/all"; /*control 层内跳转*/
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
		System.out.println( "sqf1111="+stgpxxzb.getGpid() );
		gpxxzbimp.del_gpxxzb_gpid(stgpxxzb.getGpid());
		return "redirect:/all"; /*control 层内跳转*/
	}

	/**
	 * 
	 * 显示所有股票的信息，不进行分页
	 * @param model
	 * @return
	 */
	@RequestMapping("/sqf1")
//	@ResponseBody /* @ResponseBody 表明返回的是 json串;不加表明是页面跳转 */
	public String gpxxzb_gpmc(Model model)
	{

//		List<gpxxzb> gpxxzb_list = new ArrayList<gpxxzb>();
//
//		gpxxzb_list = gpxxzbimp.sel_gpxxzb_gpmc("XO");
//
//		model.addAttribute("gpxxzb", gpxxzb_list);

		return "student"; 
	}

}
