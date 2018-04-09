package com.textile083.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String queryAirticleByTitle(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		//根据标题查找文章
		queryService.queryArticleByTitle(request);
		return "article";
	}

	@RequestMapping("/search.action")
	public String search(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String result=searchService.checkParameter(request);
		return result;
	}

	@RequestMapping("/skip.action")
	public String skip(HttpServletRequest request) throws Exception {
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
