package com.textile083.service;

import com.textile083.entity.Article;


public interface SearchService {

	public Article doSearch(String context);
	
	public boolean doExit(String exit);
}
