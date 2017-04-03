package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindNewProductServiceDAO;
import service.dao.FindProductByIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.NewProduct;
import domain.Product;

public class FindNewProductsAction extends ActionSupport{

	/**
	 * 
	 */
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private FindNewProductServiceDAO findNewProductServiceDAO;
	private FindProductByIdServiceDAO findProductByIdServiceDAO;
	
	public FindNewProductServiceDAO getFindNewProductServiceDAO() {
		return findNewProductServiceDAO;
	}
	public void setFindNewProductServiceDAO(
			FindNewProductServiceDAO findNewProductServiceDAO) {
		this.findNewProductServiceDAO = findNewProductServiceDAO;
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
		List<NewProduct> newProducts = findNewProductServiceDAO.findNewProducts();
		if(newProducts != null){
			List<Product> products = new ArrayList<Product>();
			int length = newProducts.size();
			for(int i = 0; i < length; i++){
				Product product = findProductByIdServiceDAO.findProductById(newProducts.get(i).getProductId());
				if(product != null){
					products.add(product);
				}
			}
			dataMap.put("specialPrice", products);
		}else {
			dataMap.put("specialPrice", newProducts);
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
