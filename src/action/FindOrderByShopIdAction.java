package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindOrderByShopIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindOrderByShopIdAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private int shopId;
	private FindOrderByShopIdServiceDAO findOrderByShopIdServiceDAO;
	
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public FindOrderByShopIdServiceDAO getFindOrderByShopIdServiceDAO() {
		return findOrderByShopIdServiceDAO;
	}
	public void setFindOrderByShopIdServiceDAO(
			FindOrderByShopIdServiceDAO findOrderByShopIdServiceDAO) {
		this.findOrderByShopIdServiceDAO = findOrderByShopIdServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findOrderByShopId", findOrderByShopIdServiceDAO.findOrderByShopId(shopId));
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
