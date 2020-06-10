package com.gpxx.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.gpxx.entity.gpxxzb;
import com.gpxx.entity.student;
import com.gpxx.service.impl.gpxxzbserviceimp;
import com.gpxx.service.impl.studentserviceimp;

@Controller
public class studentcontrol
{
	@Autowired
	private studentserviceimp studentimp;


	/**
	 * 
	 * 显示学生成绩信息，不进行分页
	 * @param model
	 * @return
	 */
	@RequestMapping("/studentview")
//	@ResponseBody /* @ResponseBody 表明返回的是 json串;不加表明是页面跳转 */
	public String studentview()
	{
		return "student";
	}


	/**
	 * 
	 * 显示学生成绩信息，不进行分页
	 * @param model
	 * @return
	 */

	@RequestMapping("/studentscore")
	@ResponseBody /* @ResponseBody 表明返回的是 json串;不加表明是页面跳转 */
	public student studentscore(int studentid,String studentname )
	{

		student objstudent = new student();

		objstudent = (student) studentimp.select_studentid(studentid);
		return objstudent; 
	}


	/**
	 * 
	 * 根据学生姓名查询学生成绩信息.
	 * @param model
	 * @return
	 */

	@RequestMapping("/studentname")
	@ResponseBody /* @ResponseBody 表明返回的是 json串;不加表明是页面跳转 */
	public List<student> studentname( @RequestParam(value="studentid",required=true,defaultValue="00000") int studentid,String studentname )
	{

		List<student> list_student = new ArrayList<student>();
		student objstudent = new student();
		objstudent.setStudentid(studentid);
		objstudent.setStudentname(studentname);

		list_student = studentimp.select_student_name(objstudent);

		return list_student; 
	}

	/**
	 * 
	 * 根据学生姓名查询学生成绩信息.
	 * @param model
	 * @return
	 */

	@RequestMapping("/Articles")
	@ResponseBody /* @ResponseBody 表明返回的是 json串;不加表明是页面跳转 */
	public void Articles(int pageSize ,int pageIndex)
	{

		System.out.println("sqf000"+"|"+pageSize+"|"+pageIndex);
		return;
	}



}
