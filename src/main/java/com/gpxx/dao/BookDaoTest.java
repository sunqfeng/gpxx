package com.gpxx.dao;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gpxx.BaseTest;
import com.gpxx.entity.EmailEnt;
import com.gpxx.entity.gpxxzb;
import com.gpxx.entity.jkgpxxzb;
import com.gpxx.entity.userinfo;
import com.gpxx.service.impl.userinfoserviceimp;

public class BookDaoTest extends  BaseTest
{

	@Autowired
//	private userinfoserviceimp sqf;
//	private userinfo stuserinfo;
//	private userinfoDao userinfodao;
//	private emailDao emaildao;
	private jkgpxxzbDao stjkgpxxzbdao ;

	@Test
	public void testsqf()
	{
		EmailEnt emailEnt = new EmailEnt();

		List<jkgpxxzb> list_jkgp = new ArrayList<jkgpxxzb>();
		try
		{
		list_jkgp =	stjkgpxxzbdao.sel_jkgpxxzb_like_gpmc("%酒店%");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<list_jkgp.size();i++)
		{
			
			System.out.println("sqf000"+list_jkgp.get(i));
		}

	}
	



	/*
	@Test
	public void testQueryById() throws Exception {
		long bookId = 1000;
		Book book = bookDao.queryById(bookId);
		System.out.println("sqf======"+book.getName());
	}

	@Test
	public void testQueryAll() throws Exception {
		List<Book> books = bookDao.queryAll(0, 4);
		for (Book book : books) {
			System.out.println("sqf=="+book.getName()+"|"+book.getBookId());
		}
	}

	@Test
	public void testReduceNumber() throws Exception {
		long bookId = 1000;
		int update = bookDao.reduceNumber(bookId);
		System.out.println("update=" + update);
	}
	*/
}
