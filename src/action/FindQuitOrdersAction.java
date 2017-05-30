package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindQuitOrdersServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindQuitOrdersAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private int userId;
	private FindQuitOrdersServiceDAO findQuitOrdersServiceDAO;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public FindQuitOrdersServiceDAO getFindQuitOrdersServiceDAO() {
		return findQuitOrdersServiceDAO;
	}
	public void setFindQuitOrdersServiceDAO(
			FindQuitOrdersServiceDAO findQuitOrdersServiceDAO) {
		this.findQuitOrdersServiceDAO = findQuitOrdersServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findQuitOrders", findQuitOrdersServiceDAO.findQuitOrders(userId));
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

