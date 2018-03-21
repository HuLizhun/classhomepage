package com.textile083.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.textile083.service.QueryService;

/**
 * 分页功能的控制器
 *
 */
@Controller
@RequestMapping("/Textile083")
public class PagingController {

	@Autowired
	private QueryService queryService;

	@RequestMapping("/liberature.action")
	public String queryArticleByPage(HttpServletRequest request) {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		//获取当前页
		String currentPage = request.getParameter("currentPage");
		//将标题，姓名和当前页信息传给service
		Map<String, Object> param = queryService.queryArticleByPage(title, name, currentPage);
		request.getSession().setAttribute("page", param.get("page"));
		request.getSession().setAttribute("articleList", param.get("articleList"));
		return "liberature";
	}

}
