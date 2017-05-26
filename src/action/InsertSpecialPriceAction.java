package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.InsertSpecialPriceServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.SpecialPrice;

public class InsertSpecialPriceAction extends ActionSupport{
	/**
	 * creator:WNW
	 * time:2016.12.02
	 */
	private static final long serialVersionUID = 1L;
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private int productId;
    private String time;
    private InsertSpecialPriceServiceDAO insertSpecialPriceServiceDAO;
	    
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Map<String, Object> getDataMap() {  
        return dataMap;  
	}

	public InsertSpecialPriceServiceDAO getInsertSpecialPriceServiceDAO() {
		return insertSpecialPriceServiceDAO;
	}

	public void setInsertSpecialPriceServiceDAO(
			InsertSpecialPriceServiceDAO insertSpecialPriceServiceDAO) {
		this.insertSpecialPriceServiceDAO = insertSpecialPriceServiceDAO;
	}

	//设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }  
    @Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		SpecialPrice specialPrice = new SpecialPrice();
		specialPrice.setProductId(productId);
		specialPrice.setTime(time);
		dataMap.put("insertSpecialPrice", insertSpecialPriceServiceDAO.insertSpecialPrice(specialPrice));
		return "success";
	}
}
