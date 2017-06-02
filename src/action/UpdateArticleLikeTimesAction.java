package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.InsertArticleLikeServiceDAO;
import service.dao.UpdateArticleLikeTimesServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.ArticleLike;

public class UpdateArticleLikeTimesAction  extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private UpdateArticleLikeTimesServiceDAO updateArticleLikeTimesServiceDAO;
	private InsertArticleLikeServiceDAO insertArticleLikeServiceDAO;
	private int articleId;
	private int userId;
	
	public UpdateArticleLikeTimesServiceDAO getUpdateArticleLikeTimesServiceDAO() {
		return updateArticleLikeTimesServiceDAO;
	}
	public void setUpdateArticleLikeTimesServiceDAO(
			UpdateArticleLikeTimesServiceDAO updateArticleLikeTimesServiceDAO) {
		this.updateArticleLikeTimesServiceDAO = updateArticleLikeTimesServiceDAO;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public InsertArticleLikeServiceDAO getInsertArticleLikeServiceDAO() {
		return insertArticleLikeServiceDAO;
	}
	public void setInsertArticleLikeServiceDAO(
			InsertArticleLikeServiceDAO insertArticleLikeServiceDAO) {
		this.insertArticleLikeServiceDAO = insertArticleLikeServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		if (updateArticleLikeTimesServiceDAO.updateArticleLikeTimes(articleId)) {
			ArticleLike articleLike = new ArticleLike();
			articleLike.setArticleId(articleId);
			articleLike.setUserId(userId);
			dataMap.put("updateArticleLikeTimes", insertArticleLikeServiceDAO.insertArticleLike(articleLike));
		}else {
			dataMap.put("updateArticleLikeTimes",false);
		}
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

