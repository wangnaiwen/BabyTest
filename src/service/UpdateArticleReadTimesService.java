package service;

import dao.ArticleDAO;
import service.dao.BaseArticleServiceDAO;
import service.dao.UpdateArticleReadTimesServiceDAO;

public class UpdateArticleReadTimesService extends BaseArticleServiceDAO implements UpdateArticleReadTimesServiceDAO{

	@Override
	public boolean updateArticleReadTimes() {
		ArticleDAO articleDAO = getArticleDAO();
		return articleDAO.updateArticleReadTimes();
	}

}
