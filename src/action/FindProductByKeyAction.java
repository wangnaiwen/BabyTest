package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindProductByKeyServiceDAO;
import service.dao.InsertSearchServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Search;

public class FindProductByKeyAction extends ActionSupport{
	/**
	 *  creator:Wnw
	 *  time:2016/12/2
	 */
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private int userId;
	private String keyWord;
	private FindProductByKeyServiceDAO findProductByKeyServiceDAO;
	private InsertSearchServiceDAO insertSearchServiceDAO;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public FindProductByKeyServiceDAO getFindProductByKeyServiceDAO() {
		return findProductByKeyServiceDAO;
	}
	public void setFindProductByKeyServiceDAO(
			FindProductByKeyServiceDAO findProductByKeyServiceDAO) {
		this.findProductByKeyServiceDAO = findProductByKeyServiceDAO;
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
		insertSearchServiceDAO.insertSearch(search);
		dataMap.put("findProductByKey", findProductByKeyServiceDAO.findProductByKey(keyWord));
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
