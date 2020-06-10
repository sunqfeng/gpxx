package com.gpxx.pub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.gpxx.entity.WebGpxx;

/*
 * http://hq.sinajs.cn/list=sh601006
 * 这个url会返回一串文本，例如：
var hq_str_sh601006="大秦铁路, 27.55, 27.25, 26.91, 27.55, 26.20,26.91, 26.92,
22114263, 589824680, 4695, 26.91, 57590, 26.90, 14700, 26.89,14300,
26.88, 15100, 26.87, 3100, 26.92, 8900, 26.93, 14230, 26.94, 25150,26.95, 15220, 26.96, 2008-01-11, 15:05:32";
这个字符串由许多数据拼接在一起，不同含义的数据用逗号隔开了，按照程序员的思路，顺序号从0开始。
0：”大秦铁路”，股票名字；
1：”27.55″，今日开盘价；
2：”27.25″，昨日收盘价；
3：”26.91″，当前价格；
4：”27.55″，今日最高价；
5：”26.20″，今日最低价；
6：”26.91″，竞买价，即“买一”报价；
7：”26.92″，竞卖价，即“卖一”报价；
8：”22114263″，成交的股票数，由于股票交易以一百股为基本单位，所以在使用时，通常把该值除以一百；
9：”589824680″，成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万；
10：”4695″，“买一”申请4695股，即47手；
11：”26.91″，“买一”报价；
12：”57590″，“买二”
13：”26.90″，“买二”
14：”14700″，“买三”
15：”26.89″，“买三”
16：”14300″，“买四”
17：”26.88″，“买四”
18：”15100″，“买五”
19：”26.87″，“买五”
20：”3100″，“卖一”申报3100股，即31手；
21：”26.92″，“卖一”报价
(22, 23), (24, 25), (26,27), (28, 29)分别为“卖二”至“卖四的情况”
30：”2008-01-11″，日期；
31：”15:05:32″，时间；
 */

public class GetGpxx
{

	String url = "" ;
	@SuppressWarnings("null")
	public WebGpxx doget(String gpid)
	{

		String xinl ="http://hq.sinajs.cn/list=";

		if (gpid.substring(0, 1).equalsIgnoreCase("6")
				|| gpid.substring(0, 3).equalsIgnoreCase("900")
				|| gpid.substring(0, 3).equalsIgnoreCase("730")
				|| gpid.substring(0, 3).equalsIgnoreCase("700"))
		{
			url = xinl + "sh" + gpid;// 先用上海查询
		} else
		{
			url = xinl + "sz" + gpid; // 查询不到，再用深圳查询
		}

		WebGpxx webgpxx = new WebGpxx();

		String result = "";
		BufferedReader in = null;
		try
		{
			String urlstring = url;
			URL realurl = new URL(urlstring);
			System.out.println("请求的服务器主机域名：" + realurl.getHost().toString());
			// 打开与此URL的连接
			URLConnection connection = realurl.openConnection();
			// 设置请求连接时间和读取数据时间
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(7000);
			// 建立实际的连接
			connection.connect();
			// 读取获取的数据
			InputStreamReader isr = new InputStreamReader(connection.getInputStream(), "GB2312");// 或者utf-8
			in = new BufferedReader(isr);
			String line;
			while ((line = in.readLine()) != null)
			{
				result += line;
			}
		} catch (Exception e)
		{
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		} finally
		{
			try
			{
				if (in != null)
				{
					in.close();
				}
			} catch (Exception e2)
			{
				System.out.println("关闭请求流出现异常！" + e2);
				e2.printStackTrace();
			}
		}

		/* 开始结息url返回的字符串 */
		String[] result1 = result.split("=");

		System.out.println(result1[1]);
		System.out.println("sqf=" + result1[1].length());
		if (result1[1].length() == 3)
		{
			webgpxx.setGpmc("no");
			return webgpxx;
		}

		String[] gpxxarry = result1[1].split(",");

		webgpxx.setGpmc(gpxxarry[0].replace("\"", "")); /* 股票名称 */
		webgpxx.setJrkbjg(Double.parseDouble(gpxxarry[1]));/* 今日开盘价格 */
		webgpxx.setZrsbjg(Double.parseDouble(gpxxarry[2]));/* 昨日收盘价 */
		webgpxx.setDqjg(Double.parseDouble(gpxxarry[3]));/* 当前价格 */
		webgpxx.setJrzgjg(Double.parseDouble(gpxxarry[4]));/* 今日最高价 */
		webgpxx.setJrzdjg(Double.parseDouble(gpxxarry[5]));/* 今日最低价 */

		System.out.println("sqf===" + webgpxx.toString());

		return webgpxx;
	}

//	 public static void main(String argv[])
//	 {
//		 WebGpxx webgpxx = new WebGpxx();
//		 GetGpxx getGpxx = new GetGpxx();
//		 webgpxx=getGpxx.doget("300348");
//		 System.out.println("sqf0=="+webgpxx.getGpmc());
//	 }

}
