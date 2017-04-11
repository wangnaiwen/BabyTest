package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindDealByOrderIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindDealByOrderIdAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private int orderId;
    private FindDealByOrderIdServiceDAO findDealByOrderIdServiceDAO;
    
    public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public FindDealByOrderIdServiceDAO getFindDealByOrderIdServiceDAO() {
		return findDealByOrderIdServiceDAO;
	}
	public void setFindDealByOrderIdServiceDAO(
			FindDealByOrderIdServiceDAO findDealByOrderIdServiceDAO) {
		this.findDealByOrderIdServiceDAO = findDealByOrderIdServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		dataMap.put("findDealByOrderId", findDealByOrderIdServiceDAO.findDealByOrderId(orderId));
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
