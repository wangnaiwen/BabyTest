package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindProductSaleCountServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindProductSaleCountAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
    private FindProductSaleCountServiceDAO findProductSaleCountServiceDAO;
    
    
    public FindProductSaleCountServiceDAO getFindProductSaleCountServiceDAO() {
		return findProductSaleCountServiceDAO;
	}
	public void setFindProductSaleCountServiceDAO(
			FindProductSaleCountServiceDAO findProductSaleCountServiceDAO) {
		this.findProductSaleCountServiceDAO = findProductSaleCountServiceDAO;
	}
	
	//设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }  
    public Map<String, Object> getDataMap() {  
        return dataMap;  
	}
    
	@Override
	public String execute() throws Exception {
		dataMap = new HashMap<String, Object>();  
   		dataMap.put("findProductSaleCount", findProductSaleCountServiceDAO.findPoductSaleCount());
   		return "success";
	}
}
