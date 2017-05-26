package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.InsertHotSaleServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.HotSale;

public class InsertHotSaleAction extends ActionSupport{
	/**
	 * creator:WNW
	 * time:2016.12.02
	 */
	private static final long serialVersionUID = 1L;
	
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private int productId;
    private String time;
    private InsertHotSaleServiceDAO insertHotSaleServiceDAO;
	    
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
	
	public InsertHotSaleServiceDAO getInsertHotSaleServiceDAO() {
		return insertHotSaleServiceDAO;
	}

	public void setInsertHotSaleServiceDAO(
			InsertHotSaleServiceDAO insertHotSaleServiceDAO) {
		this.insertHotSaleServiceDAO = insertHotSaleServiceDAO;
	}

	//设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }  
    @Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		HotSale hotSale = new HotSale();
		hotSale.setProductId(productId);
		hotSale.setTime(time);
		dataMap.put("insertHotSale", insertHotSaleServiceDAO.insertHotSale(hotSale));
		return "success";
	}

}
