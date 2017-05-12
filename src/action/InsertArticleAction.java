package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.InsertArticleServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Article;

public class InsertArticleAction  extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private InsertArticleServiceDAO insertArticleServiceDAO;
	private String author;
	private String title;
	private String content;
	private String coverImg;
	
	public InsertArticleServiceDAO getInsertArticleServiceDAO() {
		return insertArticleServiceDAO;
	}
	public void setInsertArticleServiceDAO(
			InsertArticleServiceDAO insertArticleServiceDAO) {
		this.insertArticleServiceDAO = insertArticleServiceDAO;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCoverImg() {
		return coverImg;
	}
	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		Article article = new Article();
		article.setAuthor(author);
		article.setContent(content);
		article.setCoverImg(coverImg);
		article.setTitle(title);
		dataMap.put("insertArticle", insertArticleServiceDAO.insertArticle(article));
		return "success";
	}
	public Map<String, Object> getDataMap() {  
        return dataMap;  
	}
	    
	//设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    } 
}
