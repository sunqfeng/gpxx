package com.gpxx.monitordata;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gpxx.dao.userinfoDao;
import com.gpxx.pub.SpringJobBeanFactory;
import com.gpxx.service.userinfoservice;
import com.gpxx.service.impl.userinfoserviceimp;

@Service
public class SessionListener implements HttpSessionListener
{


	public void sessionCreated(HttpSessionEvent se)
	{
		// TODO Auto-generated method stub

	}

	public void sessionDestroyed(HttpSessionEvent se)
	{
		// TODO Auto-generated method stub

		System.out.println("销毁1111111111");
		// 当session销毁时，将客户签退下来
		String username = (String) se.getSession().getAttribute("username");

		System.out.println("销毁11111 " + username);
		userinfoserviceimp userinfoservice = SpringJobBeanFactory.getBean(userinfoserviceimp.class);
		userinfoservice.upd_userinfo_loginstatus_username("0", username); //签退客户

	}

}
