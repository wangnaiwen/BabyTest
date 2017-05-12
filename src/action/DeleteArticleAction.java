package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.DeleteArticleServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteArticleAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private DeleteArticleServiceDAO deleteArticleServiceDAO;
	private int id;
	
	public DeleteArticleServiceDAO getDeleteArticleServiceDAO() {
		return deleteArticleServiceDAO;
	}
	public void setDeleteArticleServiceDAO(
			DeleteArticleServiceDAO deleteArticleServiceDAO) {
		this.deleteArticleServiceDAO = deleteArticleServiceDAO;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		dataMap.put("deleteArticle", deleteArticleServiceDAO.deleteArticle(id));
		return "success";
	}
	public Map<String, Object> getDataMap() {  
        return dataMap;  
	}
	    
	//����key���Բ���Ϊjson�����ݷ���  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    } 
}
