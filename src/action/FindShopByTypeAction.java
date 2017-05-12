package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindShopByTypeServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindShopByTypeAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private FindShopByTypeServiceDAO findShopByTypeServiceDAO;
    private int page;
    private int type;
	
	public FindShopByTypeServiceDAO getFindShopByTypeServiceDAO() {
		return findShopByTypeServiceDAO;
	}
	public void setFindShopByTypeServiceDAO(
			FindShopByTypeServiceDAO findShopByTypeServiceDAO) {
		this.findShopByTypeServiceDAO = findShopByTypeServiceDAO;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
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
		dataMap.put("findShopByType", findShopByTypeServiceDAO.findShopByType(type, page));
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