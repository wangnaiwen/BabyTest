package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.UpdateDealServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Deal;

public class UpdateDealAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private UpdateDealServiceDAO updateDealServiceDAO;
    private int id;
	private int orderId;
	private int productId;
	private String productName;
	private int productCount;
	private long sumPrice;
	
	
	public UpdateDealServiceDAO getUpdateDealServiceDAO() {
		return updateDealServiceDAO;
	}
	public void setUpdateDealServiceDAO(UpdateDealServiceDAO updateDealServiceDAO) {
		this.updateDealServiceDAO = updateDealServiceDAO;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public long getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(long sumPrice) {
		this.sumPrice = sumPrice;
	}
    
    @Override
	public String execute() throws Exception{
    	Deal deal = new Deal();
    	deal.setId(id);
		deal.setOrderId(orderId);
		deal.setProductCount(productCount);
		deal.setProductName(productName);
		deal.setProductId(productId);
		deal.setSumPrice(sumPrice);
	
		dataMap = new HashMap<String, Object>();  
		dataMap.put("updatetDeal", updateDealServiceDAO.updateDeal(deal));
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
