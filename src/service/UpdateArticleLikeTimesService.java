package service;

import dao.ArticleDAO;
import service.dao.BaseArticleServiceDAO;
import service.dao.UpdateArticleLikeTimesServiceDAO;

public class UpdateArticleLikeTimesService extends BaseArticleServiceDAO implements UpdateArticleLikeTimesServiceDAO{

	@Override
	public boolean updateArticleLikeTimes() {
		ArticleDAO articleDAO = getArticleDAO();
		return articleDAO.updateArticleLikeTimes();
	}

}
