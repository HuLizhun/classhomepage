package com.textile083.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.textile083.entity.Article;
import com.textile083.entity.Student;

public interface QueryService {

	public List<Student> queryStudentList();
	
	public List<Article> queryAllArticleList();
	
	public void queryArticleByTitle(HttpServletRequest request);
	
	public void queryArticleByNumber(HttpServletRequest request)throws Exception;
	
	public void queryArticleByPage(HttpServletRequest request);
	
	public Article findNextLine(HttpServletRequest request) throws Exception;
	
	public void addArticle(Article article);
}
