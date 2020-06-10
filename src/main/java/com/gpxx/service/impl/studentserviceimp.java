package com.gpxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpxx.dao.gpxxzbDao;
import com.gpxx.dao.studentDao;
import com.gpxx.entity.gpxxzb;
import com.gpxx.entity.student;
import com.gpxx.service.gpxxzbservice;
import com.gpxx.service.studentservice;

/**
 * serviceimp主要是调用dao层的方法
 * 
 * @author sunqifeng
 *
 */

@Service
public class studentserviceimp implements studentservice
{
	@Autowired
	private studentDao studentdao;

	@SuppressWarnings("unchecked")
	public student select_studentid(int studentid)
	{
		student objstudent;

		objstudent = studentdao.select_studentid(studentid);

		return objstudent;
	}

	public List<student> select_student_name(student objstudent)
	{
		// TODO Auto-generated method stub
		List<student> objstudent_list = new ArrayList<student>();
		if (objstudent.getStudentname() != null && objstudent.getStudentname().length() != 0)
		{
				objstudent_list = studentdao.select_student_name(objstudent.getStudentname());
		}

		return objstudent_list;
	}

}
