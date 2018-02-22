package com.textile083.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.textile083.dao.ArticleDAO;
import com.textile083.dao.StudentDAO;
import com.textile083.entity.Article;
import com.textile083.entity.Page;
import com.textile083.entity.Student;

@Service("queryService")
@Transactional
public class QueryService {

	@Autowired
	private StudentDAO studentDao;
	@Autowired
	private ArticleDAO articleDao;

	/**
	 * 查询数据库中所有学生的信息
	 * 
	 * @return 学生列表
	 */
	public List<Student> queryStudentList() {
		// 调用StudentDAO中的queryStudentList()方法查询所有学生信息
		List<Student> studentList = studentDao.queryAllStudentList();
		return studentList;
	}

	/**
	 * 查询数据库中所有的article信息
	 * 
	 * @return
	 */
	public List<Article> queryAllArticleList() {
		// 调用ArticleDAO中的queryArticleByTitle()方法查询对应的article对象
		List<Article> articleList = articleDao.queryAllArticleList();
		return articleList;
	}

	/**
	 * 根据标题查询article
	 * 
	 * @param title
	 * @return
	 */
	public Article queryArticleByTitle(String title) {
		// 调用ArticleDAO中的queryArticleByTitle()方法查询对应的article对象
		Article article = articleDao.queryArticleByTitle(title);
		return article;
	}

	/**
	 * 根据学号查询article
	 * 
	 * @param number
	 * @return
	 */
	public List<Article> queryArticleByNumber(String number) {
		List<Article> articleList = articleDao.queryArticleByNumber(number);
		return articleList;
	}

	/**
	 * 向数据库添加article
	 * 
	 * @param article
	 */
	public void addArticle(Article article) {
		// 向数据库添加article
		articleDao.addArticle(article);
	}

	/**
	 * 分页查询
	 */
	public Map<String, Object> queryArticleByPage(String title, String name, String currentPage) {
		Page page = new Page(queryAllArticleList().size());
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		// 如果当前页为空或者不是int类型的数字，把当前页设置为第一页
		if (currentPage == null || !pattern.matcher(currentPage).matches()) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		Map<String, Object> pageParam = new HashMap<String, Object>();
		pageParam.put("dbIndex", page.getDbIndex());
		pageParam.put("dbNumber", page.getDbNumber());
		List<Article> articleList = articleDao.queryArticleByPage(pageParam);
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("page", page);
		parameter.put("articleList", articleList);
		return parameter;
	}
}
