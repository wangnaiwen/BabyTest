package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindWalletMoneyByUserIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindWalletMoneyByUserIdAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private FindWalletMoneyByUserIdServiceDAO findWalletMoneyByUserIdServiceDAO;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public FindWalletMoneyByUserIdServiceDAO getFindWalletMoneyByUserIdServiceDAO() {
		return findWalletMoneyByUserIdServiceDAO;
	}
	public void setFindWalletMoneyByUserIdServiceDAO(
			FindWalletMoneyByUserIdServiceDAO findWalletMoneyByUserIdServiceDAO) {
		this.findWalletMoneyByUserIdServiceDAO = findWalletMoneyByUserIdServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		dataMap.put("findWalleMoneyByUserId", findWalletMoneyByUserIdServiceDAO.findWalletMoneyByUserId(userId));
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
