package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.UpdateArticleServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Article;

public class UpdateArticleAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private UpdateArticleServiceDAO updateArticleServiceDAO;
	private int id;
	private String title;
	private String content;
	private String coverImg;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public UpdateArticleServiceDAO getUpdateArticleServiceDAO() {
		return updateArticleServiceDAO;
	}
	public void setUpdateArticleServiceDAO(
			UpdateArticleServiceDAO updateArticleServiceDAO) {
		this.updateArticleServiceDAO = updateArticleServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		Article article = new Article();
		article.setId(id);
		article.setTitle(title);
		article.setContent(content);
		article.setCoverImg(coverImg);
		dataMap.put("updateArticle", updateArticleServiceDAO.updateArticle(article));
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
