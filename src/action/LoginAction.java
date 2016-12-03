package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.LoginServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.User;

public class LoginAction extends ActionSupport{

	/**
	 * creator:WNW
	 * time:2016.11.29
	 */
	private static final long serialVersionUID = 1L;
	
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private LoginServiceDAO loginServiceDAO;
    
	private int id;
	private String phone;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	public void setLoginServiceDAO(LoginServiceDAO loginServiceDAO) {
		this.loginServiceDAO = loginServiceDAO;
	}
	
	@Override
	public String execute() throws Exception{
		boolean validated = false;
		
		User u = new User();
		u.setId(id);
		u.setPhone(phone);
		u.setPassword(password);
		
		User user = loginServiceDAO.login(u);
		
		if(user != null){
			validated = true;
		}
		
		dataMap = new HashMap<String, Object>();  
		
		if(validated){
			dataMap.put("user", user);
		}else {
			dataMap.put("user", user);
		}
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