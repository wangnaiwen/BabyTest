package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.ValiteWalletServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class ValiteWalletAction  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
    private int userId;
    private String password;
    private ValiteWalletServiceDAO valiteWalletServiceDAO;
    
    public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ValiteWalletServiceDAO getValiteWalletServiceDAO() {
		return valiteWalletServiceDAO;
	}
	public void setValiteWalletServiceDAO(
			ValiteWalletServiceDAO valiteWalletServiceDAO) {
		this.valiteWalletServiceDAO = valiteWalletServiceDAO;
	}
	@Override
   	public String execute() throws Exception{
   		dataMap = new HashMap<String, Object>();  
   		dataMap.put("valiteWallet", valiteWalletServiceDAO.valiteWallet(userId, password));
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
