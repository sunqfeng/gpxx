package com.gpxx.entity;

public class WebGpxx
{

	public String gpid;
	public String gpmc ;/*股票名字*/
	public double jrkbjg; /*今日开盘价*/
	public double zrsbjg;/*昨日收盘价*/
	public double dqjg; /*当前价格*/
	public double jrzgjg; /*今日最高价*/
	public double jrzdjg; /*今日最低价*/


	public String getGpid()
	{
		return gpid;
	}
	public void setGpid(String gpid)
	{
		this.gpid = gpid;
	}
	public String getGpmc()
	{
		return gpmc;
	}
	public void setGpmc(String gpmc)
	{
		this.gpmc = gpmc;
	}
	public double getJrkbjg()
	{
		return jrkbjg;
	}
	public void setJrkbjg(double jrkbjg)
	{
		this.jrkbjg = jrkbjg;
	}
	public double getZrsbjg()
	{
		return zrsbjg;
	}
	public void setZrsbjg(double zrsbjg)
	{
		this.zrsbjg = zrsbjg;
	}
	public double getDqjg()
	{
		return dqjg;
	}
	public void setDqjg(double dqjg)
	{
		this.dqjg = dqjg;
	}
	public double getJrzgjg()
	{
		return jrzgjg;
	}
	public void setJrzgjg(double jrzgjg)
	{
		this.jrzgjg = jrzgjg;
	}
	public double getJrzdjg()
	{
		return jrzdjg;
	}
	public void setJrzdjg(double jrzdjg)
	{
		this.jrzdjg = jrzdjg;
	}

	@Override
	public String toString()
	{
		return "WebGpxx [gpid=" + gpid + ", gpmc=" + gpmc + ", jrkbjg=" + jrkbjg + ", zrsbjg=" + zrsbjg + ", dqjg="
				+ dqjg + ", jrzgjg=" + jrzgjg + ", jrzdjg=" + jrzdjg + "]";
	}
	
}
