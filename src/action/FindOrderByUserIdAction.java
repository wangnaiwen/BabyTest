package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindOrderByUserIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindOrderByUserIdAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private int userId;
	private FindOrderByUserIdServiceDAO findOrderByUserIdServiceDAO;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public FindOrderByUserIdServiceDAO getFindOrderByUserIdServiceDAO() {
		return findOrderByUserIdServiceDAO;
	}
	public void setFindOrderByUserIdServiceDAO(
			FindOrderByUserIdServiceDAO findOrderByUserIdServiceDAO) {
		this.findOrderByUserIdServiceDAO = findOrderByUserIdServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findOrderByUserId", findOrderByUserIdServiceDAO.findOrderByUserId(userId));
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
