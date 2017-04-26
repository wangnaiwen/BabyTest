package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.InsertWithdrawServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Withdraw;

public class InsertWithdrawAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private int money;
	
	private InsertWithdrawServiceDAO insertWithdrawServiceDAO;
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
	public InsertWithdrawServiceDAO getInsertWithdrawServiceDAO() {
		return insertWithdrawServiceDAO;
	}
	public void setInsertWithdrawServiceDAO(
			InsertWithdrawServiceDAO insertWithdrawServiceDAO) {
		this.insertWithdrawServiceDAO = insertWithdrawServiceDAO;
	}
	
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		Withdraw withdraw = new Withdraw();
		withdraw.setUserId(userId);
		withdraw.setMoney(money);
		dataMap.put("insertWithdraw", insertWithdrawServiceDAO.insertWithdraw(withdraw));
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
