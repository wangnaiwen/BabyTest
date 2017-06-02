package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindDealByOrderIdServiceDAO;
import service.dao.FindOrderByShopIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Order;

public class FindOrderByShopIdAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private int shopId;
	private int number;
	private FindOrderByShopIdServiceDAO findOrderByShopIdServiceDAO;
	private FindDealByOrderIdServiceDAO findDealByOrderIdServiceDAO;
	
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public FindOrderByShopIdServiceDAO getFindOrderByShopIdServiceDAO() {
		return findOrderByShopIdServiceDAO;
	}
	public void setFindOrderByShopIdServiceDAO(
			FindOrderByShopIdServiceDAO findOrderByShopIdServiceDAO) {
		this.findOrderByShopIdServiceDAO = findOrderByShopIdServiceDAO;
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
		List<String> nameList = null;
		List<Order> orders =findOrderByShopIdServiceDAO.findOrderByShopId(shopId, number);
		dataMap.put("findOrderByShopId", orders);
		if (orders != null) {
			int length = orders.size();
			nameList = new ArrayList<String>();
			for (int i = 0; i < length; i++) {
				nameList.add(findDealByOrderIdServiceDAO.findDealByOrderId(orders.get(i).getId()).get(0).getProductName());
			}
		}
		dataMap.put("nameList",nameList);
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
