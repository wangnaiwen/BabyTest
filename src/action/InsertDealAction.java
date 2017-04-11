package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.InsertDealServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Deal;

public class InsertDealAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private int orderId;
	private int productId;
	private String productName;
	private int productCount;
	private long sumPrice;
	private InsertDealServiceDAO insertDealServiceDAO;
	
	public InsertDealServiceDAO getInsertDealServiceDAO() {
		return insertDealServiceDAO;
	}
	public void setInsertDealServiceDAO(InsertDealServiceDAO insertDealServiceDAO) {
		this.insertDealServiceDAO = insertDealServiceDAO;
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
		deal.setOrderId(orderId);
		deal.setProductCount(productCount);
		deal.setProductName(productName);
		deal.setProductId(productId);
		deal.setSumPrice(sumPrice);
	
		dataMap = new HashMap<String, Object>();  
		dataMap.put("insertDeal", insertDealServiceDAO.insertDeal(deal));
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
