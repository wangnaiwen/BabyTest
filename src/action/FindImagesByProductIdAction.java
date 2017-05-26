package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindImagesByProductIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindImagesByProductIdAction extends ActionSupport{

	/**
	 * 
	 */
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	
	private int productId;
	private FindImagesByProductIdServiceDAO findImagesByProductIdServiceDAO;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public FindImagesByProductIdServiceDAO getFindImagesByProductIdServiceDAO() {
		return findImagesByProductIdServiceDAO;
	}

	public void setFindImagesByProductIdServiceDAO(
			FindImagesByProductIdServiceDAO findImagesByProductIdServiceDAO) {
		this.findImagesByProductIdServiceDAO = findImagesByProductIdServiceDAO;
	}

	public Map<String, Object> getDataMap() {  
        return dataMap;  
	}
	    
	//设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }  
    
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		dataMap.put("findImagesByProductId", findImagesByProductIdServiceDAO.findImagesByProductId(productId));
		return "success";
	}

 
}
