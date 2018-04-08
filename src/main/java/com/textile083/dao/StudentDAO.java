package com.textile083.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.textile083.entity.Student;

@Repository("studentDAO")
public interface StudentDAO {

	/**
	 * 查询所有学生信息
	 * @return
	 */
	public List<Student> queryAllStudentList();
	
	/**
	 * 根据学号查找学生
	 * @param number
	 * @return
	 */
	public Student queryStudentByNumber(String number);
	/**
	 * 根据姓名查找学生
	 * @param name
	 * @return
	 */
	public Student queryStudentByName(String name);
}
