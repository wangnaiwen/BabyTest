package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import service.dao.UpdateUserTypeServiceDAO;

public class UpdateUserTypeAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
    private String phone;
    private int type;
    private UpdateUserTypeServiceDAO updateUserTypeServiceDAO;
    
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public UpdateUserTypeServiceDAO getUpdateUserTypeServiceDAO() {
		return updateUserTypeServiceDAO;
	}
	public void setUpdateUserTypeServiceDAO(
			UpdateUserTypeServiceDAO updateUserTypeServiceDAO) {
		this.updateUserTypeServiceDAO = updateUserTypeServiceDAO;
	}
	
	@Override
	public String execute() throws Exception{
		
		dataMap = new HashMap<String, Object>();  
		dataMap.put("updateUserType", updateUserTypeServiceDAO.updateUserType(phone, type));
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
