package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindProductByIdServiceDAO;
import service.dao.FindSpecialPriceServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Product;
import domain.SpecialPrice;

public class FindSpecialPriceAction extends ActionSupport{

	/**
	 * 
	 */
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private FindSpecialPriceServiceDAO findSpecialPriceServiceDAO;
	private FindProductByIdServiceDAO findProductByIdServiceDAO;
	
	public FindSpecialPriceServiceDAO getFindSpecialPriceServiceDAO() {
		return findSpecialPriceServiceDAO;
	}
	public void setFindSpecialPriceServiceDAO(
			FindSpecialPriceServiceDAO findSpecialPriceServiceDAO) {
		this.findSpecialPriceServiceDAO = findSpecialPriceServiceDAO;
	}

	public FindProductByIdServiceDAO getFindProductByIdServiceDAO() {
		return findProductByIdServiceDAO;
	}
	public void setFindProductByIdServiceDAO(
			FindProductByIdServiceDAO findProductByIdServiceDAO) {
		this.findProductByIdServiceDAO = findProductByIdServiceDAO;
	}
	@Override
	public String execute() throws Exception{

		dataMap = new HashMap<String, Object>();
		List<SpecialPrice> specialPrices = findSpecialPriceServiceDAO.findSpecialPrices();
		if(specialPrices != null){
			List<Product> products = new ArrayList<Product>();
			int length = specialPrices.size();
			for(int i = 0; i < length; i++){
				Product product = findProductByIdServiceDAO.findProductById(specialPrices.get(i).getProductId());
				if(product != null){
					products.add(product);
				}
			}
			dataMap.put("specialPrice", products);
		}else {
			dataMap.put("specialPrice", specialPrices);
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
