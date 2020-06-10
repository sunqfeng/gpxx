package com.gpxx.entity;

public class ReMsg
{

	String Code; //返回码
	String Msg ; //返回信息

	public String getCode()
	{
		return Code;
	}
	public void setCode(String code)
	{
		Code = code;
	}
	public String getMsg()
	{
		return Msg;
	}
	public void setMsg(String msg)
	{
		Msg = msg;
	}

	@Override
	public String toString()
	{
		return "ReMsg [Code=" + Code + ", Msg=" + Msg + "]";
	}

}
