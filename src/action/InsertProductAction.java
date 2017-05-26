package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindProductByNumberingServiceDAO;
import service.dao.InsertProductServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Product;

public class InsertProductAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private String numbering;
	private String name;
	private String brand;
	private long retailPrice;
	private long standardPrice;
	private String description;
	private String coverImg;
	private int scId;
	private int count;
	private InsertProductServiceDAO insertProductServiceDAO;
	private FindProductByNumberingServiceDAO findProductByNumberingServiceDAO;
	
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
	public InsertProductServiceDAO getInsertProductServiceDAO() {
		return insertProductServiceDAO;
	}
	public void setInsertProductServiceDAO(
			InsertProductServiceDAO insertProductServiceDAO) {
		this.insertProductServiceDAO = insertProductServiceDAO;
	}
	
	public FindProductByNumberingServiceDAO getFindProductByNumberingServiceDAO() {
		return findProductByNumberingServiceDAO;
	}
	public void setFindProductByNumberingServiceDAO(
			FindProductByNumberingServiceDAO findProductByNumberingServiceDAO) {
		this.findProductByNumberingServiceDAO = findProductByNumberingServiceDAO;
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
		if (insertProductServiceDAO.insertProduct(product)) {
			Product product2 =findProductByNumberingServiceDAO.findProductByNumbering(numbering);
			if(product2 != null){
				dataMap.put("insertProduct", product2.getId());
			}else{
				dataMap.put("insertProduct", 0);
			}
		}else{ //0代表返回错误
			dataMap.put("insertProduct", 0);
		}
   		return "success";
	}
}
