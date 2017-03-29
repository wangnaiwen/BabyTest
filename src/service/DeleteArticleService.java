package service;

import dao.ArticleDAO;
import service.dao.BaseArticleServiceDAO;
import service.dao.DeleteArticleServiceDAO;

public class DeleteArticleService extends BaseArticleServiceDAO implements DeleteArticleServiceDAO{

	@Override
	public boolean deleteArticle(int id) {
		ArticleDAO articleDAO = getArticleDAO();
		return articleDAO.deleteArticle(id);
	}

}
