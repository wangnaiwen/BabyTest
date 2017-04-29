package action;

import service.dao.InsertProductServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Product;

public class InsertProdcutAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numbering;
	private String name;
	private String brand;
	private long retailPrice;
	private long standardPrice;
	private String description;
	private String coverImg;
	private int scId;
	private InsertProductServiceDAO insertProductServiceDAO;
	
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
		product.setStandardPrice(standardPrice);
		if(insertProductServiceDAO.insertProduct(product)){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
