package com.gpxx.monitordata;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpxx.dao.emailDao;
import com.gpxx.dao.jkgpxxzbDao;
import com.gpxx.entity.EmailEnt;
import com.gpxx.entity.WebGpxx;
import com.gpxx.entity.jkgpxxzb;
import com.gpxx.pub.Email;
import com.gpxx.pub.GetGpxx;

/**
 * @version 01
 * @author sunqifeng
 * @2020年6月8日10:28:23 监控后台股票的程序(这是一个定时执行程序，每50秒执行一次)
 */
@Service
public class monitorgp
{

	@Autowired
	private jkgpxxzbDao stjkgpxxzbdao;

	@Autowired
	private emailDao stEmailDao;

	Email stEmail = new Email();

	GetGpxx getGpxx = new GetGpxx();

	WebGpxx webGpxx = new WebGpxx();

	EmailEnt stEmailEnt = new EmailEnt();

	public void monitor_gp()
	{

		List<jkgpxxzb> list_jkgpxxzb = new ArrayList<jkgpxxzb>();

		list_jkgpxxzb = stjkgpxxzbdao.sel_jkgpxxzb_sfjk_1("1"); // 查询需要监控的股票信息
		if (list_jkgpxxzb.isEmpty())
		{
			return;
		}

		stEmailEnt = stEmailDao.sel_email_all();

		for (int i = 0; i < list_jkgpxxzb.size(); i++)
		{
			System.out.println("sqf=" + list_jkgpxxzb.get(i));
			webGpxx = getGpxx.doget(list_jkgpxxzb.get(i).getGpid());
			// 如果当前价格大于监控的价格，发送邮箱
			if ((webGpxx.getDqjg() > list_jkgpxxzb.get(i).getJkjg() && list_jkgpxxzb.get(i).getLjy().equals(">"))
					|| (webGpxx.getDqjg() < list_jkgpxxzb.get(i).getJkjg() && list_jkgpxxzb.get(i).getLjy().equals("<"))
					|| (webGpxx.getDqjg() == list_jkgpxxzb.get(i).getJkjg()
							&& list_jkgpxxzb.get(i).getLjy().equals("=")))
			{
				// 设置邮件标题，邮件内容
				stEmailEnt.setEmailbt("股票信息");
				String gpnr = list_jkgpxxzb.get(i).getGpmc() + "当前股票价格=" + String.valueOf(webGpxx.getDqjg()) + " | "
						+ "监控的价格" + String.valueOf(list_jkgpxxzb.get(i).getJkjg());
				stEmailEnt.setEmailnr(gpnr);
				stEmailEnt.setObjemail(list_jkgpxxzb.get(i).getObjemail());
				try
				{
					stEmail.SendEmail(stEmailEnt); // 发送邮件
				} catch (GeneralSecurityException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 邮件发送以后更新股票监控状态为0
				stjkgpxxzbdao.upd_gpxxzb_sfjk_gpid("0", list_jkgpxxzb.get(i).getGpid());
			}
		}

		return;
	}
}
