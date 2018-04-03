package com.textile083.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.textile083.dao.ArticleDAO;
import com.textile083.service.DeleteService;

@Service("deleteService")
public class DeleteServiceImpl implements DeleteService {

	@Autowired
	private ArticleDAO articleDAO;
	
	/**
	 * 根据article id删除article，该权限只有管理员才有
	 */
	public void deleteArticleById(String id) {
		int article_id=Integer.parseInt(id);
		articleDAO.deleteArticleById(article_id);
	}

}
