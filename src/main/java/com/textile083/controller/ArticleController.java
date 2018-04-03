package com.textile083.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.textile083.entity.Article;
import com.textile083.entity.Student;
import com.textile083.entity.User;
import com.textile083.service.DeleteService;
import com.textile083.service.QueryService;

/**
 * 与文章相关操作的控制器
 *
 */
@Controller
@RequestMapping("/Textile083")
public class ArticleController {

	@Autowired
	private QueryService queryService;
	
	@Autowired
	private DeleteService deleteService;

	@RequestMapping("/write.action")
	public String queryAirticleByTitle(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		//获取文章标题标题和内容
		String title = request.getParameter("subject");
		String content = request.getParameter("content");
		//判断content中字符有换行符，如果有添加<br>
		StringBuilder sb=queryService.findNextLine(content);
		User user = (User) request.getSession().getAttribute("user");
		String number = user.getNumber();
		String name = user.getName();
		//新建Article对象，将学生信息和文章信息加入其中
		Article article = new Article();
		article.setNumber(number);
		article.setName(name);
		article.setContent(sb.toString());
		article.setTitle(title);
		//调用QueryService的addArtice()方法，在数据库中插入文章信息
		queryService.addArticle(article);
		//将文章保存到session中
		request.getSession().setAttribute("article", article);
		return "article";
	}

	@RequestMapping("/queryMyArtilce.action")
	public String queryAirticleByNumber(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		String number = user.getNumber();
		List<Article> myArticlce = queryService.queryArticleByNumber(number);
		request.getSession().setAttribute("myArticlce", myArticlce);
		return "myArticle";
	}
	
	@RequestMapping("/deleteArticleById.action")
	public String deleteArticleById(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		String id=(String)request.getParameter("id");
		System.out.println(id);
		deleteService.deleteArticleById(id);
		return "index";
	}

}
