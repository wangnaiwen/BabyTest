package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.InsertSearchServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Search;

public class InsertSearchAction extends ActionSupport{

    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String keyWord;
	private InsertSearchServiceDAO insertSearchServiceDAO;
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public InsertSearchServiceDAO getInsertSearchServiceDAO() {
		return insertSearchServiceDAO;
	}
	public void setInsertSearchServiceDAO(
			InsertSearchServiceDAO insertSearchServiceDAO) {
		this.insertSearchServiceDAO = insertSearchServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		Search search = new Search();
		search.setUserId(userId);
		search.setKey(keyWord);
		dataMap.put("insertSearch",insertSearchServiceDAO.insertSearch(search));
		return "success";
	}
	
	public void setKey(String key) {
		this.key = key;
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
