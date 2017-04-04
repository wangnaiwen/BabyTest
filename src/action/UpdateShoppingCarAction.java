package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.UpdateShoppingCarServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.ShoppingCar;

public class UpdateShoppingCarAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private UpdateShoppingCarServiceDAO updateShoppingCarServiceDAO;
	private int id;
	private int userId;
	private int productId;
	private String productName;
	private int retailPrice;
	private String productCover;
	private int productCount;
	
	public UpdateShoppingCarServiceDAO getUpdateShoppingCarServiceDAO() {
		return updateShoppingCarServiceDAO;
	}
	public void setUpdateShoppingCarServiceDAO(
			UpdateShoppingCarServiceDAO updateShoppingCarServiceDAO) {
		this.updateShoppingCarServiceDAO = updateShoppingCarServiceDAO;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		ShoppingCar car = new ShoppingCar();
		car.setId(id);
		car.setUserId(userId);
		car.setProductId(productId);
		car.setProductName(productName);
		car.setProductCount(productCount);
		car.setProductCount(productCount);
		car.setProductCover(productCover);
		car.setRetailPrice(retailPrice);
		dataMap.put("updateShoppingCar", updateShoppingCarServiceDAO.updateShoppingCar(car));
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
