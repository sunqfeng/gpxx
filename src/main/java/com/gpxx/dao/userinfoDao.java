package com.gpxx.dao;

import java.util.List;

import com.gpxx.entity.userinfo;

public interface userinfoDao
{

	/**
	 * 根据用户id查询用户信息
	 * 
	 * @param userid
	 * @return
	 */
	userinfo sel_userinfo_userid(String userid);

	/**
	 * 根据用户名查询用户信息
	 * @param username
	 */
	userinfo sel_userinfo_username(String username);

	/**
	 * 
	 * @param username
	 * @param passwd
	 * @return userinfo
	 */
	userinfo sel_userinfo_username_and_passwd(String username,String passwd);

	/**
	 * 
	 * @param stUserinfo
	 * @return 插入条数
	 */

	Integer insert_userinfo(userinfo stUserinfo);

	/**
	 * 更新用户登录状态
	 * @param loginstatus
	 * @param username
	 */
	Integer upd_userinfo_loginstatus_username(String loginstatus,String username);
}
