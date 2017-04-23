package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindIncomeByShopIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;


public class FindIncomeByShopIdAction extends ActionSupport{

    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private FindIncomeByShopIdServiceDAO findIncomeByShopIdServiceDAO;
	private int shopId;
	
	public FindIncomeByShopIdServiceDAO getFindIncomeByShopIdServiceDAO() {
		return findIncomeByShopIdServiceDAO;
	}
	public void setFindIncomeByShopIdServiceDAO(
			FindIncomeByShopIdServiceDAO findIncomeByShopIdServiceDAO) {
		this.findIncomeByShopIdServiceDAO = findIncomeByShopIdServiceDAO;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		dataMap.put("findIncomeByShopId", findIncomeByShopIdServiceDAO.findIncomeByShopId(shopId));
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
