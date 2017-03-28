package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import service.dao.FindUserInfoByUserIdServiceDAO;

public class FindUserInfoByUserIdAction extends ActionSupport{
	/**
	 * creator:WNW
	 * time:2016.12.02
	 */
	private static final long serialVersionUID = 1L;
	
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private FindUserInfoByUserIdServiceDAO findUserInfoByUserIdServiceDAO;
    private int userId;
	
	public FindUserInfoByUserIdServiceDAO getFindUserInfoByUserIdServiceDAO() {
		return findUserInfoByUserIdServiceDAO;
	}
	public void setFindUserInfoByUserIdServiceDAO(
			FindUserInfoByUserIdServiceDAO findUserInfoByUserIdServiceDAO) {
		this.findUserInfoByUserIdServiceDAO = findUserInfoByUserIdServiceDAO;
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
		dataMap.put("findUserInfoByUserId", findUserInfoByUserIdServiceDAO.findUserInfoByUserId(userId));
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
