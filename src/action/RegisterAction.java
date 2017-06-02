package action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import service.dao.FindUserServiceDAO;
import service.dao.InsertUserInfoServiceDAO;
import service.dao.InsertWalletServiceDAO;
import service.dao.RegisterServiceDAO;
import domain.User;
import domain.UserInfo;
import domain.Wallet;

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
    private InsertWalletServiceDAO insertWalletServiceDAO;
    
	private String phone;
	private String password;
	private String payPassword;
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
	public String getPayPassword() {
		return payPassword;
	}
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
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
	
	public InsertWalletServiceDAO getInsertWalletServiceDAO() {
		return insertWalletServiceDAO;
	}
	public void setInsertWalletServiceDAO(
			InsertWalletServiceDAO insertWalletServiceDAO) {
		this.insertWalletServiceDAO = insertWalletServiceDAO;
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
			dataMap.put("exist", true);
			return "success";
		}else{
			dataMap.put("exist", false);
			if(registerServiceDAO.register(u)){
				user = findUserServiceDAO.findUserByPhone(u.getPhone());
				UserInfo userInfo = new UserInfo();
				userInfo.setUserId(user.getId());
				
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmssSSS");
				Date date = new Date();
				userInfo.setNickName(simpleDateFormat.format(date));
				if(insertUserInfoServiceDAO.insertUserInfo(userInfo)){
					Wallet wallet = new Wallet();
					wallet.setUserId(user.getId());
					wallet.setMoney(50000);
					wallet.setPassword(payPassword);
					if(insertWalletServiceDAO.insertWallet(wallet)){
						dataMap.put("register",findUserServiceDAO.findUserByPhone(phone));
					}else{
						dataMap.put("register",null);
					}
				}else{
					dataMap.put("register",null);
				}
				return "success";
			}else{
				dataMap.put("register", null);
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
