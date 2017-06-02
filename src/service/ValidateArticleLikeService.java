package service;

import dao.ArticleLikeDAO;
import domain.ArticleLike;
import service.dao.BaseArticleLikeServiceDAO;
import service.dao.ValidateArticleLikeServiceDAO;

public class ValidateArticleLikeService extends BaseArticleLikeServiceDAO implements ValidateArticleLikeServiceDAO{

	
	@Override
	public boolean validateArticleLike(ArticleLike articleLike) {
		ArticleLikeDAO articleLikeDAO = getArticleLikeDAO();
		return articleLikeDAO.validateArticleLike(articleLike);
	}
}
