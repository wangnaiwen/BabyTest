package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindUserServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindUserAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private FindUserServiceDAO findUserServiceDAO;
    
    private String phone;
	
	public FindUserServiceDAO getFindUserServiceDAO() {
		return findUserServiceDAO;
	}
	public void setFindUserServiceDAO(FindUserServiceDAO findUserServiceDAO) {
		this.findUserServiceDAO = findUserServiceDAO;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String execute() throws Exception{ 
		dataMap = new HashMap<String, Object>();
		dataMap.put("user", findUserServiceDAO.findUserByPhone(phone));
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
