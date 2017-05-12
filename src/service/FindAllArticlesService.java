package service;

import java.util.List;

import dao.ArticleDAO;
import domain.Article;
import service.dao.FindAllArticleServiceDAO;
import service.dao.BaseArticleServiceDAO;

public class FindAllArticlesService extends BaseArticleServiceDAO implements FindAllArticleServiceDAO{

	@Override
	public List<Article> findAllArticles(int page) {
		ArticleDAO articleDAO = getArticleDAO();
		return articleDAO.findAllArticles(page);
	}

}
