package com.textile083.service;

import java.util.List;
import java.util.Map;

import com.textile083.entity.Article;
import com.textile083.entity.Student;


public interface QueryService {

	public List<Student> queryStudentList();
	
	public List<Article> queryAllArticleList();
	
	public Article queryArticleByTitle(String title);
	
	public List<Article> queryArticleByNumber(String number);
	
	public Map<String, Object> queryArticleByPage(String title, String name, String currentPage);
	
	public StringBuilder findNextLine(String content);
	
	public void addArticle(Article article);
}
