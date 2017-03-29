package service;

import dao.ArticleDAO;
import domain.Article;
import service.dao.BaseArticleServiceDAO;
import service.dao.UpdateArticleServiceDAO;

public class UpdateArticleService extends BaseArticleServiceDAO implements UpdateArticleServiceDAO{

	@Override
	public boolean updateArticle(Article article) {
		ArticleDAO articleDAO = getArticleDAO();
		return articleDAO.updateArticle(article);
	}

}
