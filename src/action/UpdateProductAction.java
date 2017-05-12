package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.UpdateProductServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Product;

public class UpdateProductAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private int id;
	private String numbering;
	private String name;
	private String brand;
	private long retailPrice;
	private long standardPrice;
	private String description;
	private String coverImg;
	private int scId;
	private int count;
	
	private UpdateProductServiceDAO updateProductServiceDAO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumbering() {
		return numbering;
	}
	public void setNumbering(String numbering) {
		this.numbering = numbering;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public long getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(long retailPrice) {
		this.retailPrice = retailPrice;
	}
	public long getStandardPrice() {
		return standardPrice;
	}
	public void setStandardPrice(long standardPrice) {
		this.standardPrice = standardPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCoverImg() {
		return coverImg;
	}
	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}
	public int getScId() {
		return scId;
	}
	public void setScId(int scId) {
		this.scId = scId;
	}
	public UpdateProductServiceDAO getUpdateProductServiceDAO() {
		return updateProductServiceDAO;
	}
	public void setUpdateProductServiceDAO(
			UpdateProductServiceDAO updateProductServiceDAO) {
		this.updateProductServiceDAO = updateProductServiceDAO;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public String execute() throws Exception {
		Product product = new Product();
		product.setId(id);
		product.setBrand(brand);
		product.setCoverImg(coverImg);
		product.setDescription(description);
		product.setName(name);
		product.setNumbering(numbering);
		product.setRetailPrice(retailPrice);
		product.setScId(scId);
		product.setCount(count);
		product.setStandardPrice(standardPrice);
		dataMap = new HashMap<String, Object>();  
   		dataMap.put("updateProduct", updateProductServiceDAO.updateProduct(product));
   		return "success";
	}
}
