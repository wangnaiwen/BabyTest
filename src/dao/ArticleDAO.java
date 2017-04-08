package dao;

import java.util.List;

import domain.Article;

public interface ArticleDAO {
	boolean insertArticle(Article article);
	boolean deleteArticle(int id);
	boolean updateArticle(Article article);
	boolean updateArticleLikeTimes(int id);
	boolean updateArticleReadTimes(int id);
	Article findArticleById(int id);
	List<Article> findAllArticles();
}
