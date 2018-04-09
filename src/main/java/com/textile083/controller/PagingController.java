package com.textile083.controller;

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
	public String queryArticleByPage(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		//分页查询
		queryService.queryArticleByPage(request);
		return "liberature";
	}

}
