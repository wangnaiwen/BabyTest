package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import service.UpdateUserPasswordServiceDAO;

public class UpdateUserPasswordAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
    private String phone;
    private String password;
    
    private UpdateUserPasswordServiceDAO updateUserPasswordServiceDAO;
    
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UpdateUserPasswordServiceDAO getUpdateUserPasswordServiceDAO() {
		return updateUserPasswordServiceDAO;
	}
	public void setUpdateUserPasswordServiceDAO(
			UpdateUserPasswordServiceDAO updateUserPasswordServiceDAO) {
		this.updateUserPasswordServiceDAO = updateUserPasswordServiceDAO;
	}
	
	@Override
	public String execute() throws Exception{
				
		dataMap = new HashMap<String, Object>();  
		dataMap.put("updateUserPassword", updateUserPasswordServiceDAO.updateUserPassword(phone, password));
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
