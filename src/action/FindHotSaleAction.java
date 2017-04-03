package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindHotSaleServiceDAO;
import service.dao.FindProductByIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;
import domain.HotSale;
import domain.Product;

public class FindHotSaleAction extends ActionSupport{

	/**
	 * 
	 */
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private FindHotSaleServiceDAO findHotSaleServiceDAO;
	private FindProductByIdServiceDAO findProductByIdServiceDAO;
	
	public FindHotSaleServiceDAO getFindHotSaleServiceDAO() {
		return findHotSaleServiceDAO;
	}
	public void setFindHotSaleServiceDAO(FindHotSaleServiceDAO findHotSaleServiceDAO) {
		this.findHotSaleServiceDAO = findHotSaleServiceDAO;
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
		List<HotSale> hotSales = findHotSaleServiceDAO.findHotSales();
		if(hotSales != null){
			List<Product> products = new ArrayList<Product>();
			int length = hotSales.size();
			for(int i = 0; i < length; i++){
				Product product = findProductByIdServiceDAO.findProductById(hotSales.get(i).getProductId());
				if(product != null){
					products.add(product);
				}
			}
			dataMap.put("specialPrice", products);
		}else {
			dataMap.put("specialPrice", hotSales);
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
