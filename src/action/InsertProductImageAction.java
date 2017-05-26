package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.InsertProductImageServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.ProductImage;

public class InsertProductImageAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	
	private int productId;
	private String path;
	private InsertProductImageServiceDAO insertProductImageServiceDAO;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public InsertProductImageServiceDAO getInsertProductImageServiceDAO() {
		return insertProductImageServiceDAO;
	}

	public void setInsertProductImageServiceDAO(
			InsertProductImageServiceDAO insertProductImageServiceDAO) {
		this.insertProductImageServiceDAO = insertProductImageServiceDAO;
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
		ProductImage image = new ProductImage();
		image.setProductId(productId);
		image.setPath(path);
		dataMap.put("insertProductImage", insertProductImageServiceDAO.insertProductImage(image));
		return "success";
	}
	
}
