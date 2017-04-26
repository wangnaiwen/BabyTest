package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindSearchByUserIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindSearchByUserIdAction extends ActionSupport{

    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private FindSearchByUserIdServiceDAO findSearchByUserIdServiceDAO;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public FindSearchByUserIdServiceDAO getFindSearchByUserIdServiceDAO() {
		return findSearchByUserIdServiceDAO;
	}
	public void setFindSearchByUserIdServiceDAO(
			FindSearchByUserIdServiceDAO findSearchByUserIdServiceDAO) {
		this.findSearchByUserIdServiceDAO = findSearchByUserIdServiceDAO;
	}
	
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findSearchByUserId",findSearchByUserIdServiceDAO.findSearchByUserId(userId));
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
