package service;

import dao.ArticleLikeDAO;
import domain.ArticleLike;
import service.dao.BaseArticleLikeServiceDAO;
import service.dao.InsertArticleLikeServiceDAO;

public class InsertArticleLikeService extends BaseArticleLikeServiceDAO implements InsertArticleLikeServiceDAO{

	@Override
	public boolean insertArticleLike(ArticleLike articleLike) {
		ArticleLikeDAO articleLikeDAO = getArticleLikeDAO();
		return articleLikeDAO.insertArticleLike(articleLike);
	}

}
