package com.gpxx.pub;


import com.gpxx.entity.EmailEnt;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @version 01
 * @author sunqifeng 2020年6月7日18:01:01 关于email的公共函数
 *
 */
public class Email
{

	/**
	 * 发送邮件 
	 * @param objEmail
	 * @throws GeneralSecurityException
	 * @throws MessagingException
	 */
	public void SendEmail( final EmailEnt emailEnt) throws GeneralSecurityException, MessagingException
	{

		if (emailEnt==null)
		{
			return ;
		}

		// 创建一个配置文件并保存
		Properties properties = new Properties();

		properties.setProperty("mail.host", "smtp.qq.com");

		properties.setProperty("mail.transport.protocol", "smtp");

		properties.setProperty("mail.smtp.auth", "true");

		// QQ存在一个特性设置SSL加密
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.socketFactory", sf);

		// 创建一个session对象
		Session session = Session.getDefaultInstance(properties, new Authenticator()
		{
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(emailEnt.getObjemail(), emailEnt.getSqm());
			}
		});

		// 开启debug模式
		session.setDebug(true);

		// 获取连接对象
		Transport transport = session.getTransport();

		// 连接服务器
		transport.connect("smtp.qq.com", emailEnt.getSedemail(), emailEnt.getSqm());

		// 创建邮件对象
		MimeMessage mimeMessage = new MimeMessage(session);

		// 邮件发送人
		mimeMessage.setFrom(new InternetAddress(emailEnt.getSedemail()));

		// 邮件接收人
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailEnt.getObjemail()));

		// 邮件标题
		mimeMessage.setSubject(emailEnt.getEmailbt());

		// 邮件内容
		mimeMessage.setContent(emailEnt.getEmailnr(), "text/html;charset=UTF-8");

		// 发送邮件
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

		// 关闭连接
		transport.close();
	}
}
