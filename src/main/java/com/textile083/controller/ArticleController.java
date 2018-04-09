package com.textile083.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.textile083.entity.Article;
import com.textile083.exception.AssertException;
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
	public String queryAirticleByTitle(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		try {
			//将输入的文章标题和内容封装成Article对象
			Article article=queryService.findNextLine(request);
			//调用QueryService的addArtice()方法，在数据库中插入文章信息
			queryService.addArticle(article);
			return "article";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("message",e.getMessage());
			return "write";
		}
	}

	@RequestMapping("/queryMyArtilce.action")
	public String queryArticleByNumber(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		try{
			queryService.queryArticleByNumber(request);
			return "myArticle";
		}catch(AssertException e){
			request.setAttribute("message", e.getMessage());
			return "noArticle";
		}
		
		
	}
	
	@RequestMapping("/deleteArticleById.action")
	public String deleteArticleById(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		String id=(String)request.getParameter("id");
		deleteService.deleteArticleById(id);
		return "redirect:/Textile083/liberature.action";
	}

}
