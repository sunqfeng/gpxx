package com.gpxx.service;

import org.springframework.stereotype.Service;

import com.gpxx.entity.ReMsg;
import com.gpxx.entity.userinfo;

@Service
public interface userinfoservice
{
	/*
	 *根据用户id查询用户信息 
	 */
	userinfo sel_userinfo_userid(String userid);

	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	ReMsg sel_userinfo_username(String username);

	/**
	 * 
	 * @param username
	 * @param passwd
	 * @return userinfo
	 */
	ReMsg sel_userinfo_username_and_passwd(String username,String passwd);

	/**
	 * 
	 * @param stUserinfo
	 * @return
	 * 
	 */
	ReMsg insert_userinfo(userinfo stUserinfo);

	/**
	 * 更新客户登录状态
	 * @return
	 */
	Integer upd_userinfo_loginstatus_username(String loginstatus,String username);

	/**
	 * 
	 * @param name
	 * @return
	 */
	ReMsg check_name(String name);

}
