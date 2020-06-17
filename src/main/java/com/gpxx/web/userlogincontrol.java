package com.gpxx.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpxx.entity.ReMsg;
import com.gpxx.entity.userinfo;
import com.gpxx.service.impl.userinfoserviceimp;


@Controller
public class userlogincontrol
{
	@Autowired // @Autowired 必须要加上
	private userinfoserviceimp userinfoser;

	private ReMsg msg; 

	/**
	 * 
	 * 只负责跳转到login界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/userlogin")
	public String userlogin()
	{
		return "login";
	}


	/**
	 * 
	 * 只负责跳转到register界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/register")
	public String register()
	{
		return "./register"; //ajax页面跳转使用
	}


	/**
	 * 根据用户名与密码查询用户信息
	 * @param stuserinfo
	 * @return
	 */
	@RequestMapping("/sel_userinfo_username")
	@ResponseBody
	public ReMsg sel_userinfo_userid(@RequestBody userinfo stuserinfo,HttpServletRequest request)
	{
		msg = userinfoser.sel_userinfo_username_and_passwd(stuserinfo.getUsername(), stuserinfo.getPasswd());

		if(msg == null || !msg.getCode().equals("000"))
		{

			System.out.println("error!!!!!!!!!!!!!!"+msg.getCode()+msg.getMsg());
		}

		if(msg.getCode().equals("000")) //该客户存在,把客户名保存在session中
		{
			request.getSession().setAttribute("username", stuserinfo.getUsername());
			//修改客户状态为登录状态
			userinfoser.upd_userinfo_loginstatus_username("1", stuserinfo.getUsername());
		}
					

		return msg;
	}

	/**
	 * 注册用户信息
	 * @param stuserinfo
	 * @return
	 */

	@RequestMapping("/insert_userinfo")
	@ResponseBody
	public ReMsg insert_userinfo(@RequestBody userinfo stuserinfo)
	{
		msg = userinfoser.insert_userinfo(stuserinfo);

		if(msg == null || !msg.getCode().equals("000"))
		{
			System.out.println("error!!!!!!!!!!!!!!"+msg.getCode()+msg.getMsg());
		}

		return msg;
	}

	/**
	 * 检查注册的用户名是否重复.
	 * @param name
	 * @return
	 */
	@RequestMapping("/check_name")
	@ResponseBody
	public ReMsg check_name(@RequestParam(value="name",required=true,defaultValue="")String name)
	{
		System.out.println("check_name ="+name);
		msg = userinfoser.sel_userinfo_username(name);
		System.out.println("check_name="+msg.toString());
		return msg;
	}


}
