package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.ValidateArticleLikeServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.ArticleLike;

public class ValidateArticleLikeAction  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
    private int userId;
    private int articleId;
    private ValidateArticleLikeServiceDAO validateArticleLikeServiceDAO;
    
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public ValidateArticleLikeServiceDAO getValidateArticleLikeServiceDAO() {
		return validateArticleLikeServiceDAO;
	}

	public void setValidateArticleLikeServiceDAO(
			ValidateArticleLikeServiceDAO validateArticleLikeServiceDAO) {
		this.validateArticleLikeServiceDAO = validateArticleLikeServiceDAO;
	}

	public Map<String, Object> getDataMap() {  
        return dataMap;  
	}
	    
	//设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }  
    
    @Override
   	public String execute() throws Exception{
   		dataMap = new HashMap<String, Object>();  
   		ArticleLike articleLike = new ArticleLike();
   		articleLike.setUserId(userId);
   		articleLike.setArticleId(articleId);
   		dataMap.put("validateArticleLike",validateArticleLikeServiceDAO.validateArticleLike(articleLike));
   		return "success";
   	}
   
       
}
