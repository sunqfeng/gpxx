package com.gpxx.entity;

public class jkgpxxzb
{

	public String gpid = "";
	public String gpmc = "";
	public double dqjg =0.0;
	public double jkjg =0.0;
	public String sfjk = "";
	public Integer jkcs =0;
	public String objemail = "";
	public String ljy = "";

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
	public double getDqjg()
	{
		return dqjg;
	}
	public void setDqjg(double dqjg)
	{
		this.dqjg = dqjg;
	}
	public double getJkjg()
	{
		return jkjg;
	}
	public void setJkjg(double jkjg)
	{
		this.jkjg = jkjg;
	}
	public String getSfjk()
	{
		return sfjk;
	}
	public void setSfjk(String sfjk)
	{
		this.sfjk = sfjk;
	}

	

	public Integer getJkcs()
	{
		return jkcs;
	}
	public void setJkcs(Integer jkcs)
	{
		this.jkcs = jkcs;
	}
	public String getObjemail()
	{
		return objemail;
	}
	public void setObjemail(String objemail)
	{
		this.objemail = objemail;
	}


	public String getLjy()
	{
		return ljy;
	}
	public void setLjy(String ljy)
	{
		this.ljy = ljy;
	}
	@Override
	public String toString()
	{
		return "jkgpxxzb [gpid=" + gpid + ", gpmc=" + gpmc + ", dqjg=" + dqjg + ", jkjg=" + jkjg + ", sfjk=" + sfjk
				+ ", jkcs=" + jkcs + ", objemail=" + objemail + "]";
	}


}
