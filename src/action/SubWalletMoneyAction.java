package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.SubWalletMoneyServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class SubWalletMoneyAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private int userId;
    private int money;
    private SubWalletMoneyServiceDAO subWalletMoneyServiceDAO;
    
    public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public SubWalletMoneyServiceDAO getSubWalletMoneyServiceDAO() {
		return subWalletMoneyServiceDAO;
	}
	public void setSubWalletMoneyServiceDAO(
			SubWalletMoneyServiceDAO subWalletMoneyServiceDAO) {
		this.subWalletMoneyServiceDAO = subWalletMoneyServiceDAO;
	}
	@Override
   	public String execute() throws Exception{
    	dataMap = new HashMap<String, Object>();  
   		dataMap.put("subWalletMoney", subWalletMoneyServiceDAO.subWalletMoney(userId, money));
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
