package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc.JDBCConnection;
import dao.ArticleDAO;
import dao.BaseDAO;
import domain.Article;

public class ArticleImpl extends BaseDAO implements ArticleDAO{

	@Override
	public boolean insertArticle(Article article) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time = simpleDateFormat.format(date);
	    String sql = "insert into lb_article values(null, '"+article.getAuthor()+"','"+time +"','"
	    		+article.getTitle()+"','"+article.getContent()+"','"+article.getCoverImg()+"',0,0)";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean deleteArticle(int id) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "delete from lb_article where id=" + id;
	    System.out.println(sql);
		boolean result = jdbcConnection.delete(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean updateArticle(Article article) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update lb_article set title='"
	    		+article.getTitle()+"',content='"+article.getContent()+"',cover_img='"
	    		+article.getCoverImg()+"' where id=" +article.getId();
	    System.out.println(sql);
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	//add one more times
	@Override
	public boolean updateArticleLikeTimes(int id) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update lb_article set like_times = (like_times + 1) where id = " +id;
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	//add one more times
	@Override
	public boolean updateArticleReadTimes(int id) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update lb_article set read_times = (read_times + 1) where id = " +id;
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public Article findArticleById(int id) {
		Article article = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_article where id="+id;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				article = new Article();
				article.setId(rs.getInt("id"));
				article.setAuthor(rs.getString("author"));
				article.setTime(rs.getString("time"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setCoverImg(rs.getString("cover_img"));
				article.setReadTimes(rs.getInt("read_times"));
				article.setLikeTimes(rs.getInt("like_times"));
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
		return article;
	}

	@Override
	public List<Article> findAllArticles(int page) {
		List<Article> articles = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_article limit "+ ((page-1)*10)+","+page*10;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setAuthor(rs.getString("author"));
				article.setTime(rs.getString("time"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setCoverImg(rs.getString("cover_img"));
				article.setReadTimes(rs.getInt("read_times"));
				article.setLikeTimes(rs.getInt("like_times"));
				
				if(articles == null){
					articles = new ArrayList<Article>();
				}
				articles.add(article);
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
		return articles;
	}

}
