package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindShopByIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;


public class FindShopByIdAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private int id;
    private FindShopByIdServiceDAO findShopByIdServiceDAO;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FindShopByIdServiceDAO getFindShopByIdServiceDAO() {
		return findShopByIdServiceDAO;
	}
	public void setFindShopByIdServiceDAO(
			FindShopByIdServiceDAO findShopByIdServiceDAO) {
		this.findShopByIdServiceDAO = findShopByIdServiceDAO;
	}
	@Override
	public String execute() throws Exception{
	
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findShopById", findShopByIdServiceDAO.findShopById(id));
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
