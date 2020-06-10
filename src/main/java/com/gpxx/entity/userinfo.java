package com.gpxx.entity;

public class userinfo
{

	// -- 创建用户信息表
	// `userid` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
	// `username` varchar(100) NOT NULL COMMENT '用户名',
	// `passwd` varchar(100) NOT NULL COMMENT '用户密码',
	// `email` varchar(20) COMMENT '用户邮箱',
	// `telephone` varchar(12) COMMENT '用户电话',
	// `address` varchar(100) COMMENT '地址',

	private String userid;  //用户id
	private String username; //用户名
	private String passwd;  //用户密码
	private String email;  //邮箱地址
	private String telephone; //电话
	private String address; //地址
	private String role; //角色
	private String loginstatus; //登录状态



	public String getRole()
	{
		return role;
	}



	public void setRole(String role)
	{
		this.role = role;
	}



	public String getLoginstatus()
	{
		return loginstatus;
	}



	public void setLoginstatus(String loginstatus)
	{
		this.loginstatus = loginstatus;
	}



	public String getUserid()
	{
		return userid;
	}



	public void setUserid(String userid)
	{
		this.userid = userid;
	}



	public String getUsername()
	{
		return username;
	}



	public void setUsername(String username)
	{
		this.username = username;
	}



	public String getPasswd()
	{
		return passwd;
	}



	public void setPasswd(String passwd)
	{
		this.passwd = passwd;
	}



	public String getEmail()
	{
		return email;
	}



	public void setEmail(String email)
	{
		this.email = email;
	}



	public String getTelephone()
	{
		return telephone;
	}



	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}



	public String getAddress()
	{
		return address;
	}



	public void setAddress(String address)
	{
		this.address = address;
	}



	@Override
	public String toString()
	{
		return "userinfo [userid=" + userid + ", username=" + username + ", passwd=" + passwd + ", email=" + email
				+ ", telephone=" + telephone + ", address=" + address + ", role=" + role + ", loginstatus="
				+ loginstatus + "]";
	}


}
