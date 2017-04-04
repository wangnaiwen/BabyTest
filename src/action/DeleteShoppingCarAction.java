package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.DeleteShoppingCarServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteShoppingCarAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private DeleteShoppingCarServiceDAO deleteShoppingCarServiceDAO;
	private int id;
	
	public DeleteShoppingCarServiceDAO getDeleteShoppingCarServiceDAO() {
		return deleteShoppingCarServiceDAO;
	}
	public void setDeleteShoppingCarServiceDAO(
			DeleteShoppingCarServiceDAO deleteShoppingCarServiceDAO) {
		this.deleteShoppingCarServiceDAO = deleteShoppingCarServiceDAO;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		dataMap.put("deleteShoppingCar", deleteShoppingCarServiceDAO.deleteShoppingCar(id));
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
