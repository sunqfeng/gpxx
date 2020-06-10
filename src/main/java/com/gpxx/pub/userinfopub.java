package com.gpxx.pub;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 所有关于userinfo的公共函数都放在该处
 * @author sunqifeng
 * 2020年6月7日10:25:26
 * @version 01
 */
public class userinfopub
{
	public String scuserid()
	{

		System.out.println("scuserid00000");
		Random ran=new Random();
		int ran3 = ran.nextInt(100) ;

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式

		String obj = df.format(new Date())+ran3;
		System.out.println(obj);
		return obj;
	}

//	public static void main(String[] args)
//	{
//		userinfopub stsqf = new userinfopub();
//		stsqf.scuserid();
//	}
}
