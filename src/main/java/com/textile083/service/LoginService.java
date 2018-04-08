package com.textile083.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.Cookie;

import com.textile083.entity.Article;
import com.textile083.entity.Student;
import com.textile083.exception.AssertException;

public interface LoginService {

	public List<Article> queryAllArticleList();
	
	public List<Student> queryAllStudentList();
	
	public String[] doLogin(Cookie[] cookies) throws UnsupportedEncodingException;
	
	public Student checkStudent(String name, String number) throws Exception;
	
	public Cookie[] checkMsg(String name, String number, String[] msg, Cookie[] cookies1)
			throws UnsupportedEncodingException;
}
