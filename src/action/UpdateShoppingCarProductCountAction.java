package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.UpdateShoppingCarProductCountServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateShoppingCarProductCountAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private UpdateShoppingCarProductCountServiceDAO updateShoppingCarProductCountServiceDAO;
	private int id;
	private int count;
	
	public UpdateShoppingCarProductCountServiceDAO getUpdateShoppingCarProductCountServiceDAO() {
		return updateShoppingCarProductCountServiceDAO;
	}
	public void setUpdateShoppingCarProductCountServiceDAO(
			UpdateShoppingCarProductCountServiceDAO updateShoppingCarProductCountServiceDAO) {
		this.updateShoppingCarProductCountServiceDAO = updateShoppingCarProductCountServiceDAO;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		dataMap.put("updateShoppingCarProductCount", updateShoppingCarProductCountServiceDAO.updateShoppingCarProductCount(id, count));
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
