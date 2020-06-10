package com.gpxx.entity;

public class gpxxzb
{
	private String gpid;
	private String gpmc;
	private String mrsj;
	private double mrjg;
	private String mcsj;
	private double mcjg;
	private Integer gpsl ;
	private double gpje;
	private Integer   gpts;
	private double gpsy;

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
	public String getMrsj()
	{
		return mrsj;
	}
	public void setMrsj(String mrsj)
	{
		this.mrsj = mrsj;
	}
	public double getMrjg()
	{
		return mrjg;
	}
	public void setMrjg(double mrjg)
	{
		this.mrjg = mrjg;
	}
	public String getMcsj()
	{
		return mcsj;
	}
	public void setMcsj(String mcsj)
	{
		this.mcsj = mcsj;
	}
	public double getMcjg()
	{
		return mcjg;
	}
	public void setMcjg(double mcjg)
	{
		this.mcjg = mcjg;
	}
	public int getGpsl()
	{
		return gpsl;
	}
	public void setGpsl(int gpsl)
	{
		this.gpsl = gpsl;
	}
	public double getGpje()
	{
		return gpje;
	}
	public void setGpje(double gpje)
	{
		this.gpje = gpje;
	}
	public int getGpts()
	{
		return gpts;
	}
	public void setGpts(int gpts)
	{
		this.gpts = gpts;
	}
	public double getGpsy()
	{
		return gpsy;
	}
	public void setGpsy(double gpsy)
	{
		this.gpsy = gpsy;
	}

	@Override
	public String toString()
	{
		return "gpxxzb [gpid=" + gpid + ", gpmc=" + gpmc + ", mrsj=" + mrsj + ", mrjg=" + mrjg + ", mcsj=" + mcsj
				+ ", mcjg=" + mcjg + ", gpsl=" + gpsl + ", gpje=" + gpje + ", gpts=" + gpts + ", gpsy=" + gpsy + "]";
	}
}
