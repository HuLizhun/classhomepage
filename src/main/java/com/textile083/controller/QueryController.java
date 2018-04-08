package com.textile083.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.textile083.entity.Article;
import com.textile083.service.QueryService;
import com.textile083.service.SearchService;

/**
 * 查询操作相关的控制器
 *
 */
@Controller
@RequestMapping("/Textile083")
public class QueryController {

	@Autowired
	private QueryService queryService;
	@Autowired
	private SearchService searchService;

	@RequestMapping(value = "/queryArticleByTitle.action", method = RequestMethod.GET)
	public String queryAirticleByTitle(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		//根据标题查找文章
		Article article = queryService.queryArticleByTitle(title);
		request.getSession().setAttribute("article", article);
		return "article";
	}

	@RequestMapping("/search.action")
	public String search(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String exit = request.getParameter("exit");
		System.out.println(exit+" "+searchService.doExit(exit));
		String context = request.getParameter("context");
		//如果用户点击退出按钮，返回登陆页面
		if (searchService.doExit(exit)) {
			System.out.println("进入exit");
			request.getSession().setAttribute("user", null);
			return "login";
		}
		Article aritcle = searchService.doSearch(context);
		if (aritcle != null) {
			request.getSession().setAttribute("article", aritcle);
			return "article";
		} else {
			request.getSession().setAttribute("context", context);
			return "none";
		}
	}

	@RequestMapping("/skip.action")
	public String skip(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String num = request.getParameter("num");
		if (name != null && "photo".equals(name)) {
			if (num == null || "".equals(num)) {
				//默认打开第一张照片
				request.getSession().setAttribute("num", 21);
			} else {
				request.getSession().setAttribute("num", num);
			}

		}
		return name;
	}

}
