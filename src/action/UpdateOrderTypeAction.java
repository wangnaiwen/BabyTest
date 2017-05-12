package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.UpdateOrderTypeServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateOrderTypeAction extends ActionSupport{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private int id;
	private int type;
	private UpdateOrderTypeServiceDAO  updateOrderTypeServiceDAO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public UpdateOrderTypeServiceDAO getUpdateOrderTypeServiceDAO() {
		return updateOrderTypeServiceDAO;
	}
	public void setUpdateOrderTypeServiceDAO(
			UpdateOrderTypeServiceDAO updateOrderTypeServiceDAO) {
		this.updateOrderTypeServiceDAO = updateOrderTypeServiceDAO;
	}
	@Override
	public String execute() throws Exception {
		dataMap = new HashMap<String, Object>();  
   		dataMap.put("updateOrderType", updateOrderTypeServiceDAO.updateOrderType(id, type));
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
