package com.textile083.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.textile083.entity.Article;

@Repository("articleDAO")
public interface ArticleDAO {
	/**
	 * 查询数据库中所有的article对象
	 * 
	 * @return
	 */
	public List<Article> queryAllArticleList();

	/**
	 * 根据标题查询article
	 * 
	 * @param title
	 * @return
	 */
	public Article queryArticleByTitle(String title);

	/**
	 * 向数据库添加article
	 * 
	 * @param article
	 */
	public void addArticle(Article article);

	/**
	 * 分页查询
	 * 
	 * @param parameter
	 */
	public List<Article> queryArticleByPage(Map<String, Object> parameter);

	/**
	 * 根据学号查询文章
	 * 
	 * @param number
	 * @return
	 */
	public List<Article> queryArticleByNumber(String number);
	
	public void deleteArticleById(int id);
}
