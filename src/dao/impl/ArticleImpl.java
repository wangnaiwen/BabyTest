package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	    String sql = "insert into article values(null, '"+article.getAuthor()+"','"+article.getTime() +"','"
	    		+article.getTitle()+"','"+article.getContent()+"','"+article.getCoverImg()+"',"
	    		+article.getReadTimes()+","+article.getLikeTimes()+")";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean deleteArticle(int id) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "delete from article where id=" + id;
	    System.out.println(sql);
		boolean result = jdbcConnection.delete(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean updateArticle(Article article) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update article set author='"+article.getAuthor()+"',time='"+article.getTime() +"',title='"
	    		+article.getTitle()+"',content='"+article.getContent()+"',cover_img='"+article.getCoverImg()
	    		+"',read_times="+article.getReadTimes()+",like_times="+article.getLikeTimes()+" where id=" 
	    		+article.getId();
	    System.out.println(sql);
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	//add one more times
	@Override
	public boolean updateArticleLikeTimes() {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = null;
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	//add one more times
	@Override
	public boolean updateArticleReadTimes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Article findArticleById(int id) {
		Article article = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from article where id="+id;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				article = new Article();
				article.setId(rs.getInt("id"));
				article.setAuthor(rs.getString("anthor"));
				article.setTime(rs.getString(rs.getString("time")));
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
	public List<Article> findAllArticles() {
		List<Article> articles = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from article";
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setAuthor(rs.getString("anthor"));
				article.setTime(rs.getString(rs.getString("time")));
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
