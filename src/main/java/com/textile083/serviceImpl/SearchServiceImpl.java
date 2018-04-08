package com.textile083.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.textile083.dao.ArticleDAO;
import com.textile083.entity.Article;
import com.textile083.service.SearchService;

@Service("searchService")
public class SearchServiceImpl implements SearchService {
	@Autowired
	private ArticleDAO articleDao;

	public boolean doExit(String exit) {
		if (exit != null && (exit.trim()).equals("退出")) {
			return true;
		}
		return false;
	}

	public Article doSearch(String context) {
		if (context != null) {
			Article article = (Article) articleDao.queryArticleByTitle(context);
			return article;
		}
		return null;
	}
}
