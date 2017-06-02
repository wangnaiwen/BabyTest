package dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JDBCConnection;
import dao.ArticleLikeDAO;
import dao.BaseDAO;
import domain.ArticleLike;

public class ArticleLikeImp extends BaseDAO implements ArticleLikeDAO{

	@Override
	public boolean insertArticleLike(ArticleLike articleLike) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into lb_article_like values(null, "+articleLike.getUserId()+","+articleLike.getArticleId()+")";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean validateArticleLike(ArticleLike articleLike) {
		boolean result = false;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_article_like where user_id="+articleLike.getUserId() +" AND article_id = " + articleLike.getArticleId();
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				result = true;
			}
			jdbcConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
