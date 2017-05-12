package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.UpdateShopTypeServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateShopTypeAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private UpdateShopTypeServiceDAO updateShopTypeServiceDAO;
    private int id;
    private int type;
	
	
	public UpdateShopTypeServiceDAO getUpdateShopTypeServiceDAO() {
		return updateShopTypeServiceDAO;
	}
	public void setUpdateShopTypeServiceDAO(
			UpdateShopTypeServiceDAO updateShopTypeServiceDAO) {
		this.updateShopTypeServiceDAO = updateShopTypeServiceDAO;
	}
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
	@Override
	public String execute() throws Exception{
	
		dataMap = new HashMap<String, Object>();  
		dataMap.put("updateShopType", updateShopTypeServiceDAO.updateShopType(id, type));
		return "success";
	}
	public Map<String, Object> getDataMap() {  
        return dataMap;  
	}
	    
	//����key���Բ���Ϊjson�����ݷ���  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    } 
}