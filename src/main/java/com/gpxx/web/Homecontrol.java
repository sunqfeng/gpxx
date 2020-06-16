package com.gpxx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Homecontrol
{


	/**
	 * 
	 * 只是负责跳转到HOME界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/gpxxhome")
	public String gpxxhome()
	{
		return "gpxxhome";
	}

	
}
