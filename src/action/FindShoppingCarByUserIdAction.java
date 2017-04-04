package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindShoppingCarByUserIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;
public class FindShoppingCarByUserIdAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private FindShoppingCarByUserIdServiceDAO findShoppingCarByUserIdServiceDAO;
	private int userId;
	
	public FindShoppingCarByUserIdServiceDAO getFindShoppingCarByUserIdServiceDAO() {
		return findShoppingCarByUserIdServiceDAO;
	}
	public void setFindShoppingCarByUserIdServiceDAO(
			FindShoppingCarByUserIdServiceDAO findShoppingCarByUserIdServiceDAO) {
		this.findShoppingCarByUserIdServiceDAO = findShoppingCarByUserIdServiceDAO;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		dataMap.put("findShoppingCarByUserId", findShoppingCarByUserIdServiceDAO.findShoppingCarByUserId(userId));
		
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
