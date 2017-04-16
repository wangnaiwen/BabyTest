package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.AddWalletMoneyServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class AddWalletMoneyAction  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private int userId;
    private int money;
    private AddWalletMoneyServiceDAO addWalletMoneyServiceDAO;
    
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
	public AddWalletMoneyServiceDAO getAddWalletMoneyServiceDAO() {
		return addWalletMoneyServiceDAO;
	}
	public void setAddWalletMoneyServiceDAO(
			AddWalletMoneyServiceDAO addWalletMoneyServiceDAO) {
		this.addWalletMoneyServiceDAO = addWalletMoneyServiceDAO;
	}
	@Override
   	public String execute() throws Exception{
    	dataMap = new HashMap<String, Object>();  
   		dataMap.put("addWalletMoney", addWalletMoneyServiceDAO.addWalletMoney(userId, money));
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
