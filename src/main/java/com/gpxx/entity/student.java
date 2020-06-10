package com.gpxx.entity;

public class student
{

	private int studentid;// 学生ID

	private String studentname;// 学生名称 

	private int studentscore;// 学生成绩

	public int getStudentid()
	{
		return studentid;
	}

	public void setStudentid(int studentid)
	{
		this.studentid = studentid;
	}

	public String getStudentname()
	{
		return studentname;
	}

	public void setStudentname(String studentname)
	{
		this.studentname = studentname;
	}

	public int getStudentscore()
	{
		return studentscore;
	}

	public void setStudentscore(int studentscore)
	{
		this.studentscore = studentscore;
	}

	@Override
	public String toString()
	{
		return "student [studentid=" + studentid + ", studentname=" + studentname + ", studentscore=" + studentscore
				+ "]";
	}


}
