package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import service.FindUserInfoServiceDAO;

public class FindUserInfoAction extends ActionSupport{
	/**
	 * creator:WNW
	 * time:2016.12.02
	 */
	private static final long serialVersionUID = 1L;
	
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private FindUserInfoServiceDAO findUserInfoServiceDAO;
    private int id;
	
	public FindUserInfoServiceDAO getFindUserInfoServiceDAO() {
		return findUserInfoServiceDAO;
	}
	public void setFindUserInfoServiceDAO(
			FindUserInfoServiceDAO findUserInfoServiceDAO) {
		this.findUserInfoServiceDAO = findUserInfoServiceDAO;
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
		dataMap.put("findUserInfo", findUserInfoServiceDAO.findUserInfoById(id));
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
