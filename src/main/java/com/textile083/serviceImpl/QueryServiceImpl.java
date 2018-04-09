package com.textile083.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.textile083.dao.ArticleDAO;
import com.textile083.dao.StudentDAO;
import com.textile083.entity.Article;
import com.textile083.entity.Page;
import com.textile083.entity.Student;
import com.textile083.entity.User;
import com.textile083.service.QueryService;
import com.textile083.util.AssertUtil;

@Service("queryService")
public class QueryServiceImpl implements QueryService{

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
	public void queryArticleByTitle(HttpServletRequest request) {
		// 调用ArticleDAO中的queryArticleByTitle()方法查询对应的article对象
		String title = request.getParameter("title");
		Article article = articleDao.queryArticleByTitle(title);
		request.getSession().setAttribute("article", article);
	}

	/**
	 * 根据学号查询article
	 * 
	 * @param number
	 * @return
	 */
	public void queryArticleByNumber(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		String number = user.getNumber();
		List<Article> articleList = articleDao.queryArticleByNumber(number);
		AssertUtil.assertListNotNull("您还没有发表文章！", articleList);
		request.getSession().setAttribute("myArticlce", articleList);
	}

	/**
	 * 向数据库添加article
	 * 
	 * @param article
	 */
	@Transactional
	public void addArticle(Article article) {
		// 向数据库添加article
		articleDao.addArticle(article);
	}

	/**
	 * 分页查询
	 */
	public void queryArticleByPage(HttpServletRequest request) {
		//获取当前页
		String currentPage = request.getParameter("currentPage");
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
		request.getSession().setAttribute("page", page);
		request.getSession().setAttribute("articleList", articleList);
	}
	
	/**
	 * 判断字符串是否有换行，如果有则在后面添加<br>
	 * @param content
	 */
	public Article findNextLine(HttpServletRequest request) throws Exception{
		//获取文章标题标题和内容
		String title = request.getParameter("subject");
		String content = request.getParameter("content");
		//标题和内容不为空验证
		title=AssertUtil.assertNotBlank("请填写文章标题", title);
		content=AssertUtil.assertNotBlank("请填写文章内容", content);
		StringBuilder sb=new StringBuilder();
		//如果输入的内容有换行，则在后面添加<br>
		for(int i=0;i<content.length();i++){
			sb.append(content.substring(i, i+1));
			if("\n".equals(content.substring(i, i+1))){
				sb.append("<br>");
			}
		}
		User user = (User) request.getSession().getAttribute("user");
		String number = user.getNumber();
		String name = user.getName();
		//新建Article对象，将学生信息和文章信息加入其中
		Article article = new Article();
		article.setNumber(number);
		article.setName(name);
		article.setContent(sb.toString());
		article.setTitle(title);		
		//将文章保存到session中
		request.getSession().setAttribute("article", article);
		return article;
	}
}
