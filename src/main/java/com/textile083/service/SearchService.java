package com.textile083.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.textile083.dao.ArticleDAO;
import com.textile083.entity.Article;

@Service("searchService")
@Transactional
public class SearchService {
	@Autowired
	private ArticleDAO articleDao;

	public boolean doExit(String exit) {
		if (exit != null && exit.equals("退出")) {
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
