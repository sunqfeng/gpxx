package com.gpxx.service;

import java.util.List;


import com.gpxx.entity.gpxxzb;
import com.gpxx.entity.student;

public interface studentservice
{

	/**
	 * 查询student所有信息,根据学生号;只查询出一条数据
	 * 
	 */

	student select_studentid(int studentid);

	/**
	 * 
	 * @param objstudent
	 * @return
	 */

	List<student> select_student_name(student objstudent);

}
