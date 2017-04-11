package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindShopByUserIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindShopByUserIdAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
    private int userId;
    private FindShopByUserIdServiceDAO findShopByUserIdServiceDAO;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public FindShopByUserIdServiceDAO getFindShopByUserIdServiceDAO() {
		return findShopByUserIdServiceDAO;
	}
	public void setFindShopByUserIdServiceDAO(
			FindShopByUserIdServiceDAO findShopByUserIdServiceDAO) {
		this.findShopByUserIdServiceDAO = findShopByUserIdServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findShopByUserId", findShopByUserIdServiceDAO.findShopByUserId(userId));
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
