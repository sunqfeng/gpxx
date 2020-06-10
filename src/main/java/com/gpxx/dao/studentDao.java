package com.gpxx.dao;

import java.util.List;

import com.gpxx.entity.student;

public interface studentDao
{

	/**
	 * 通过ID查询学生的成绩信息
	 * 
	 * @param studentid
	 * @return
	 */
	student select_studentid (int studentid);

	/**
	 * 
	 * @param studentname
	 * @return
	 */
	List<student> select_student_name(String studentname);

}
