package com.gpxx.entity;

public class EmailEnt
{

	String sedemail; //发邮件
	String objemail; //目标邮件地址;
	String emailbt; //邮件标题
	String emailnr; //邮件内容
	String sqm; //授权码


	public String getObjemail()
	{
		return objemail;
	}
	public void setObjemail(String objemail)
	{
		this.objemail = objemail;
	}
	public String getEmailbt()
	{
		return emailbt;
	}
	public void setEmailbt(String emailbt)
	{
		this.emailbt = emailbt;
	}
	public String getEmailnr()
	{
		return emailnr;
	}
	public void setEmailnr(String emailnr)
	{
		this.emailnr = emailnr;
	}

	public String getSqm()
	{
		return sqm;
	}
	public void setSqm(String sqm)
	{
		this.sqm = sqm;
	}

	public String getSedemail()
	{
		return sedemail;
	}
	public void setSedemail(String sedemail)
	{
		this.sedemail = sedemail;
	}

	@Override
	public String toString()
	{
		return "EmailEnt [sedemail=" + sedemail + ", objemail=" + objemail + ", emailbt=" + emailbt + ", emailnr="
				+ emailnr + ", sqm=" + sqm + "]";
	}

}
