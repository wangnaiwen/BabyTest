package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindOrderByOrderNumberServiceDAO;
import service.dao.InsertOrderServiceDAO;
import com.opensymphony.xwork2.ActionSupport;

import domain.Order;

public class InsertOrderAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private int shopId;
	private int userId;
	private String orderNumber;
	private int orderType;
	private String createTime;
	private String payTime;
	private String finishTime;
	private int addressId;
	private String remark;
	private InsertOrderServiceDAO insertOrderServiceDAO;
	private FindOrderByOrderNumberServiceDAO findOrderByOrderNumberServiceDAO;
	
	public InsertOrderServiceDAO getInsertOrderServiceDAO() {
		return insertOrderServiceDAO;
	}
	public void setInsertOrderServiceDAO(InsertOrderServiceDAO insertOrderServiceDAO) {
		this.insertOrderServiceDAO = insertOrderServiceDAO;
	}
	public FindOrderByOrderNumberServiceDAO getFindOrderByOrderNumberServiceDAO() {
		return findOrderByOrderNumberServiceDAO;
	}
	public void setFindOrderByOrderNumberServiceDAO(
			FindOrderByOrderNumberServiceDAO findOrderByOrderNumberServiceDAO) {
		this.findOrderByOrderNumberServiceDAO = findOrderByOrderNumberServiceDAO;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String execute() throws Exception{
		Order order = new Order();
		order.setUserId(userId);
		order.setShopId(shopId);
		order.setOrderNumber(orderNumber);
		order.setOrderType(orderType);
		order.setFinishTime(finishTime);
		order.setCreateTime(createTime);
		order.setPayTime(payTime);
		order.setAddressId(addressId);
		order.setRemark(remark);
		dataMap = new HashMap<String, Object>();  
		boolean reuslt = insertOrderServiceDAO.insertOrder(order);
		if(reuslt){
			dataMap.put("insertOrder", reuslt);
			Order order2 = findOrderByOrderNumberServiceDAO.findOrderByNumbering(orderNumber);
			dataMap.put("id", order2.getId());
		}else {
			dataMap.put("insertOrder", reuslt);
		}
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
