package service.dao;

import dao.ArticleLikeDAO;

public class BaseArticleLikeServiceDAO {
	private ArticleLikeDAO articleLikeDAO;

	public ArticleLikeDAO getArticleLikeDAO() {
		return articleLikeDAO;
	}

	public void setArticleLikeDAO(ArticleLikeDAO articleLikeDAO) {
		this.articleLikeDAO = articleLikeDAO;
	}
	
}
