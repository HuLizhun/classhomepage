package com.textile083.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.textile083.dao.ArticleDAO;
import com.textile083.entity.Article;
import com.textile083.exception.AssertException;
import com.textile083.service.SearchService;
import com.textile083.util.AssertUtil;

@Service("searchService")
public class SearchServiceImpl implements SearchService {
	@Autowired
	private ArticleDAO articleDao;
	
	public String checkParameter(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String exit = request.getParameter("exit");
		String context = request.getParameter("context");
		//如果用户点击退出按钮，返回登陆页面
		if (doExit(exit)) {
			request.getSession().setAttribute("user", null);
			return "login";
		}
		List<Article> articleList = new ArrayList<Article>();
		try {
			articleList = doSearch(context);
			request.getSession().setAttribute("articleList", articleList);
			return "queryResult";
		} catch (AssertException e) {
			// TODO Auto-generated catch block
			request.setAttribute("context", e.getMessage());
			return "none";
		}
	}

	private boolean doExit(String exit) {
		if (exit != null && "退出".equals(exit.trim())) {
			return true;
		}
		return false;
	}

	private List<Article> doSearch(String context) throws Exception{
			//输入标题不为空验证 
			context=AssertUtil.assertNotBlank("请输入文章标题进行查询！", context);
			List<Article> articleList =  articleDao.queryArticleListByTitle(context);
			//验证article不为null
			AssertUtil.assertListNotNull("没有找到“"+context+"”相关的文章！", articleList);
			return articleList;
	}
}
