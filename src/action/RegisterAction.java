package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import service.dao.FindUserServiceDAO;
import service.dao.InsertUserInfoServiceDAO;
import service.dao.RegisterServiceDAO;
import domain.User;
import domain.UserInfo;

public class RegisterAction extends ActionSupport{
	/**
	 * creator:WNW
	 * time:2016.11.30
	 */
	private static final long serialVersionUID = 1L;
	
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private RegisterServiceDAO registerServiceDAO;
    private FindUserServiceDAO findUserServiceDAO;
    private InsertUserInfoServiceDAO insertUserInfoServiceDAO;
    
	private String phone;
	private String password;
	
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
	
	public void setRegisterServiceDAO(RegisterServiceDAO registerServiceDAO) {
		this.registerServiceDAO = registerServiceDAO;
	}
	
	public void setFindUserServiceDAO(FindUserServiceDAO findUserServiceDAO) {
		this.findUserServiceDAO = findUserServiceDAO;
	}
	
	public InsertUserInfoServiceDAO getInsertUserInfoServiceDAO() {
		return insertUserInfoServiceDAO;
	}
	public void setInsertUserInfoServiceDAO(
			InsertUserInfoServiceDAO insertUserInfoServiceDAO) {
		this.insertUserInfoServiceDAO = insertUserInfoServiceDAO;
	}
	/**
	 * Register:
	 * 1. phone and password
	 * 2. judge the phone is exist? 
	 * 	(1) yes : return the hint
	 * 	(2) no  : return the register hint 
	 * 
	 * */
	
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();		
		User u = new User();
		u.setPhone(phone);
		u.setPassword(password);
		u.setType(0);
		
		User user = findUserServiceDAO.findUserByPhone(u.getPhone());
		
		if(user != null){
			System.out.println("*********************");
			dataMap.put("exist", true);
			return "success";
		}else{
			dataMap.put("exist", false);
			
			if(registerServiceDAO.register(u)){
				user = findUserServiceDAO.findUserByPhone(u.getPhone());
				UserInfo userInfo = new UserInfo();
				userInfo.setUserId(user.getId());
			
				dataMap.put("register", insertUserInfoServiceDAO.insertUserInfo(userInfo));
				return "success";
			}else{
				dataMap.put("register", false);
				return "success";
			}
		}
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
