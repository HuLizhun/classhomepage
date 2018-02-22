package com.textile083.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.textile083.entity.Article;
import com.textile083.entity.Student;
import com.textile083.service.QueryService;

@Controller
@RequestMapping("/Textile083")
public class ArticleController {

	@Autowired
	private QueryService queryService;

	@RequestMapping("/write.action")
	public String queryAirticleByTitle(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("subject");
		String content = request.getParameter("content");
		Student student = (Student) request.getSession().getAttribute("student");
		String number = student.getNumber();
		String name = student.getName();
		Article article = new Article();
		article.setNumber(number);
		article.setName(name);
		article.setContent(content);
		article.setTitle(title);
		queryService.addArticle(article);
		request.getSession().setAttribute("article", article);
		return "article";
	}

	@RequestMapping("/queryMyArtilce.action")
	public String queryAirticleByNumber(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		Student student = (Student) request.getSession().getAttribute("student");
		String number = student.getNumber();
		List<Article> myArticlce = queryService.queryArticleByNumber(number);
		request.getSession().setAttribute("myArticlce", myArticlce);
		return "myArticle";
	}

	public String queryArticleByPage(HttpServletRequest request) {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String currentPage = request.getParameter("currentPage");
		Map<String, Object> param = queryService.queryArticleByPage(title, name, currentPage);
		request.getSession().setAttribute("page", param.get("page"));
		request.getSession().setAttribute("articleList", param.get("articleList"));
		return "liberature";
	}

}
