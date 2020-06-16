package com.gpxx.pub;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理时间的公共类
 * @author sunqifeng
 *
 */
public class DayClass
{
	public Integer DayDiff(String time1, String time2) throws ParseException
	{
		
		SimpleDateFormat dfs = new SimpleDateFormat("yyyyMMdd");
        Date begin = dfs.parse(time1);
        Date end = dfs.parse(time2);
        long between = (end.getTime() - begin.getTime()) / 1000;//除以1000是为了转换成秒
        long day1 = between / (24 * 3600);
        long hour1 = between % (24 * 3600) / 3600;
        long minute1 = between % 3600 / 60;
        long second1 = between % 60 / 60;
        System.out.println("" + day1 + "天" + hour1 + "小时" + minute1 + "分" + second1 + "秒");

		return (int) day1;
	}

//	public static void main(String[] args) throws ParseException
//	{
//		DayClass dayClass = new DayClass();
//		long sqf = dayClass.DayDiff("20200616", "20200625");
//		System.out.println("long  day sqf="+sqf);
//		System.out.println("20200616102723".substring(0,8));
//	}
}
