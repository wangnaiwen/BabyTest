package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.InsertShoppingCarServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.ShoppingCar;

public class InsertShoppingCarAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private InsertShoppingCarServiceDAO insertShoppingCarServiceDAO;
	private int userId;
	private int productId;
	private String productName;
	private int retailPrice;
	private String productCover;
	private int productCount;
	
	public InsertShoppingCarServiceDAO getInsertShoppingCarServiceDAO() {
		return insertShoppingCarServiceDAO;
	}
	public void setInsertShoppingCarServiceDAO(
			InsertShoppingCarServiceDAO insertShoppingCarServiceDAO) {
		this.insertShoppingCarServiceDAO = insertShoppingCarServiceDAO;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public int getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(int retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getProductCover() {
		return productCover;
	}
	public void setProductCover(String productCover) {
		this.productCover = productCover;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		ShoppingCar car = new ShoppingCar();
		car.setUserId(userId);
		car.setProductId(productId);
		car.setProductName(productName);
		car.setProductCount(productCount);
		car.setProductCount(productCount);
		car.setProductCover(productCover);
		car.setRetailPrice(retailPrice);
		dataMap.put("insertShoppingCar", insertShoppingCarServiceDAO.insertShoppingCar(car));
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
