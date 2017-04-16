package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.UpdateWalletPasswordServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateWalletPasswordAction  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private int userId;
    private int password;
    private UpdateWalletPasswordServiceDAO updateWalletPasswordServiceDAO;
    
    public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public UpdateWalletPasswordServiceDAO getUpdateWalletPasswordServiceDAO() {
		return updateWalletPasswordServiceDAO;
	}
	public void setUpdateWalletPasswordServiceDAO(
			UpdateWalletPasswordServiceDAO updateWalletPasswordServiceDAO) {
		this.updateWalletPasswordServiceDAO = updateWalletPasswordServiceDAO;
	}
	@Override
   	public String execute() throws Exception{
   		dataMap = new HashMap<String, Object>();  
   		dataMap.put("updateWalletPassword", updateWalletPasswordServiceDAO.updateWalletPassword(userId,password));
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
