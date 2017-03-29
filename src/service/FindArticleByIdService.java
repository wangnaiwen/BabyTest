package service;

import dao.ArticleDAO;
import domain.Article;
import service.dao.BaseArticleServiceDAO;
import service.dao.FindArticleByIdServiceDAO;

public class FindArticleByIdService extends BaseArticleServiceDAO implements FindArticleByIdServiceDAO{

	@Override
	public Article findArticleById(int id) {
		ArticleDAO articleDAO = getArticleDAO();
		return articleDAO.findArticleById(id);
	}

}
