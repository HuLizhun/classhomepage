package com.textile083.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.textile083.entity.Article;
import com.textile083.entity.Student;

public interface LoginService {

	public List<Article> queryAllArticleList();
	
	public List<Student> queryAllStudentList();
	
	public void doLogin(HttpServletRequest request) throws Exception;
	
	public void checkStudent(HttpServletRequest request) throws Exception;
	
	public boolean checkMsg(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
