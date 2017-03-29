package service;

import dao.ArticleDAO;
import domain.Article;
import service.dao.BaseArticleServiceDAO;
import service.dao.InsertArticleServiceDAO;

public class InsertArticleService extends BaseArticleServiceDAO implements InsertArticleServiceDAO{

	@Override
	public boolean insertArticle(Article article) {
		ArticleDAO articleDAO = getArticleDAO();
		return articleDAO.insertArticle(article);
	}

}
