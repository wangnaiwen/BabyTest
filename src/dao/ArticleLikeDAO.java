package dao;

import domain.ArticleLike;

public interface ArticleLikeDAO {
	boolean insertArticleLike(ArticleLike articleLike);
	boolean validateArticleLike(ArticleLike articleLike);
}
