package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindShoppingCarByUserIdAndProductIdServiceDAO;
import service.dao.InsertShoppingCarServiceDAO;
import service.dao.UpdateShoppingCarAddOneProductServiceDAO;
import com.opensymphony.xwork2.ActionSupport;

import domain.ShoppingCar;

public class InsertShoppingCarAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private InsertShoppingCarServiceDAO insertShoppingCarServiceDAO;
	private FindShoppingCarByUserIdAndProductIdServiceDAO findShoppingCarByUserIdAndProductIdServiceDAO;
	private UpdateShoppingCarAddOneProductServiceDAO updateShoppingCarAddOneProductServiceDAO;
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
	public UpdateShoppingCarAddOneProductServiceDAO getUpdateShoppingCarAddOneProductServiceDAO() {
		return updateShoppingCarAddOneProductServiceDAO;
	}
	public void setUpdateShoppingCarAddOneProductServiceDAO(
			UpdateShoppingCarAddOneProductServiceDAO updateShoppingCarAddOneProductServiceDAO) {
		this.updateShoppingCarAddOneProductServiceDAO = updateShoppingCarAddOneProductServiceDAO;
	}
	public FindShoppingCarByUserIdAndProductIdServiceDAO getFindShoppingCarByUserIdAndProductIdServiceDAO() {
		return findShoppingCarByUserIdAndProductIdServiceDAO;
	}
	public void setFindShoppingCarByUserIdAndProductIdServiceDAO(
			FindShoppingCarByUserIdAndProductIdServiceDAO findShoppingCarByUserIdAndProductIdServiceDAO) {
		this.findShoppingCarByUserIdAndProductIdServiceDAO = findShoppingCarByUserIdAndProductIdServiceDAO;
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
		/**
		 * 判断该产品是否已经在购物车里面了
		 * 如果存在，则update product count
		 * 如果不存在，则insert product to db
		 * */
		boolean result = false;
		ShoppingCar shoppingCar = findShoppingCarByUserIdAndProductIdServiceDAO.findShoppingCarByUserIdAndProductId(userId, productId);
		if(shoppingCar != null){
			//说明存在,加一个
			result = updateShoppingCarAddOneProductServiceDAO.updateShoppingCarAddOneProduct(shoppingCar.getId());
		}else{
			//说明不存在,插入一条ShoppingCar
			ShoppingCar car = new ShoppingCar();
			car.setUserId(userId);
			car.setProductId(productId);
			car.setProductName(productName);
			car.setProductCount(productCount);
			car.setProductCount(productCount);
			car.setProductCover(productCover);
			car.setRetailPrice(retailPrice);
			result = insertShoppingCarServiceDAO.insertShoppingCar(car);
		}
		
		dataMap.put("insertShoppingCar",result);
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
