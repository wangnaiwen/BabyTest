package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindHotSaleServiceDAO;
import service.dao.FindProductByIdServiceDAO;
import service.dao.FindProductByKeyServiceDAO;
import service.dao.FindSearchByUserIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.HotSale;
import domain.Product;
import domain.Search;

public class RecommendProductAction extends ActionSupport{

    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private int userId;
	private FindSearchByUserIdServiceDAO findSearchByUserIdServiceDAO;
	private FindProductByKeyServiceDAO findProductByKeyServiceDAO;
	private FindHotSaleServiceDAO hotSaleServiceDAO;
	private FindProductByIdServiceDAO findProductByIdServiceDAO;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public FindSearchByUserIdServiceDAO getFindSearchByUserIdServiceDAO() {
		return findSearchByUserIdServiceDAO;
	}

	public void setFindSearchByUserIdServiceDAO(
			FindSearchByUserIdServiceDAO findSearchByUserIdServiceDAO) {
		this.findSearchByUserIdServiceDAO = findSearchByUserIdServiceDAO;
	}

	public FindProductByKeyServiceDAO getFindProductByKeyServiceDAO() {
		return findProductByKeyServiceDAO;
	}

	public void setFindProductByKeyServiceDAO(
			FindProductByKeyServiceDAO findProductByKeyServiceDAO) {
		this.findProductByKeyServiceDAO = findProductByKeyServiceDAO;
	}

	public FindHotSaleServiceDAO getHotSaleServiceDAO() {
		return hotSaleServiceDAO;
	}

	public void setHotSaleServiceDAO(FindHotSaleServiceDAO hotSaleServiceDAO) {
		this.hotSaleServiceDAO = hotSaleServiceDAO;
	}

	public FindProductByIdServiceDAO getFindProductByIdServiceDAO() {
		return findProductByIdServiceDAO;
	}

	public void setFindProductByIdServiceDAO(
			FindProductByIdServiceDAO findProductByIdServiceDAO) {
		this.findProductByIdServiceDAO = findProductByIdServiceDAO;
	}

	public Map<String, Object> getDataMap() {  
        return dataMap;  
	}
	    
	//设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }
	
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();
		List<Product> products = new ArrayList<Product>();
		List<Search> searchs = findSearchByUserIdServiceDAO.findSearchByUserId(userId);
		if(searchs == null){
			List<HotSale> hotSales = hotSaleServiceDAO.findHotSales();
			int length = hotSales.size();
			for (int i = 0; i < length; i++) {
				products.add(findProductByIdServiceDAO.findProductById(hotSales.get(i).getProductId()));
			}
			System.out.println("11111111111111111");
			dataMap.put("recommendProducts",products);
			return SUCCESS;
		}else{
			int length = searchs.size();
			if (length >= 4) {
				System.out.println("2222222222222222");
				for(int i = 0 ; i < length; i++){
					List<Product> tempProducts = findProductByKeyServiceDAO.findProductByKey(searchs.get(i).getKey());
					if(tempProducts != null && products.size() < 4){
						products.add(tempProducts.get(0));
						if (products.size() == 4) {
							dataMap.put("recommendProducts",products);
							return SUCCESS;
						}
					}
				}
				System.out.println("33333333333333333");
				//如果前面用户搜索的不到4个，则去查找热门的
				List<HotSale> hotSales = hotSaleServiceDAO.findHotSales();
				int length2 = hotSales.size();
				for (int i = 0; i < length2; i++) {
					products.add(findProductByIdServiceDAO.findProductById(hotSales.get(i).getProductId()));
					System.out.println("4444444444444444");
					if (products.size() == 4) {
						dataMap.put("recommendProducts",products);
						return SUCCESS;
					}
				}
			}else{
				System.out.println("5555555555555");
				for(int i = 0 ; i < length; i++){
					List<Product> tempProducts = findProductByKeyServiceDAO.findProductByKey(searchs.get(i).getKey());
					if(tempProducts != null && products.size() < 4){
						products.add(tempProducts.get(0));
						System.out.println("666666666666666");
					}
				}
				List<HotSale> hotSales = hotSaleServiceDAO.findHotSales();
				int length2 = hotSales.size();
				for (int i = 0; i < length2; i++) {
					System.out.println("555555555");
					products.add(findProductByIdServiceDAO.findProductById(hotSales.get(0).getProductId()));
					if (products.size() == 4) {
						dataMap.put("recommendProducts",products);
						return SUCCESS;
					}
				}
			}
		}
		return "success";		
	}  
}
