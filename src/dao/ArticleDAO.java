package dao;

import java.util.List;

import domain.Article;

public interface ArticleDAO {
	boolean insertArticle(Article article);
	boolean deleteArticle(int id);
	boolean updateArticle(Article article);
	boolean updateArticleLikeTimes();
	boolean updateArticleReadTimes();
	Article findArticleById(int id);
	List<Article> findAllArticles();
}
