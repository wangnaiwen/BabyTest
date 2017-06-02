package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.DeleteHotSaleServiceDAO;
import service.dao.DeleteNewProductServiceDAO;
import service.dao.DeleteProductServiceDAO;
import service.dao.DeleteSpecialPriceServiceDAO;
import service.dao.FindProductByIdServiceDAO;
import service.dao.InsertOffProductServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Product;

public class DeleteProductAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private int id;
	private FindProductByIdServiceDAO findProductByIdServiceDAO;
	private DeleteProductServiceDAO deleteProductServiceDAO;
	private InsertOffProductServiceDAO insertOffProductServiceDAO;
	private DeleteNewProductServiceDAO deleteNewProductServiceDAO;
	private DeleteHotSaleServiceDAO deleteHotSaleServiceDAO;
	private DeleteSpecialPriceServiceDAO deleteSpecialPriceServiceDAO;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FindProductByIdServiceDAO getFindProductByIdServiceDAO() {
		return findProductByIdServiceDAO;
	}

	public void setFindProductByIdServiceDAO(
			FindProductByIdServiceDAO findProductByIdServiceDAO) {
		this.findProductByIdServiceDAO = findProductByIdServiceDAO;
	}

	public DeleteProductServiceDAO getDeleteProductServiceDAO() {
		return deleteProductServiceDAO;
	}

	public void setDeleteProductServiceDAO(
			DeleteProductServiceDAO deleteProductServiceDAO) {
		this.deleteProductServiceDAO = deleteProductServiceDAO;
	}

	public InsertOffProductServiceDAO getInsertOffProductServiceDAO() {
		return insertOffProductServiceDAO;
	}

	public void setInsertOffProductServiceDAO(
			InsertOffProductServiceDAO insertOffProductServiceDAO) {
		this.insertOffProductServiceDAO = insertOffProductServiceDAO;
	}
	public DeleteNewProductServiceDAO getDeleteNewProductServiceDAO() {
		return deleteNewProductServiceDAO;
	}

	public void setDeleteNewProductServiceDAO(
			DeleteNewProductServiceDAO deleteNewProductServiceDAO) {
		this.deleteNewProductServiceDAO = deleteNewProductServiceDAO;
	}

	public DeleteHotSaleServiceDAO getDeleteHotSaleServiceDAO() {
		return deleteHotSaleServiceDAO;
	}

	public void setDeleteHotSaleServiceDAO(
			DeleteHotSaleServiceDAO deleteHotSaleServiceDAO) {
		this.deleteHotSaleServiceDAO = deleteHotSaleServiceDAO;
	}

	public DeleteSpecialPriceServiceDAO getDeleteSpecialPriceServiceDAO() {
		return deleteSpecialPriceServiceDAO;
	}

	public void setDeleteSpecialPriceServiceDAO(
			DeleteSpecialPriceServiceDAO deleteSpecialPriceServiceDAO) {
		this.deleteSpecialPriceServiceDAO = deleteSpecialPriceServiceDAO;
	}

	public Map<String, Object> getDataMap() {  
        return dataMap;  
	}
	    
	//����key���Բ���Ϊjson�����ݷ���  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    } 
    
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		Product product = findProductByIdServiceDAO.findProductById(id);
		if(product != null){
			if(insertOffProductServiceDAO.insertOffProduct(product)){
				dataMap.put("deleteProduct", deleteProductServiceDAO.deleteProduct(id));
				deleteHotSaleServiceDAO.deleteHotSale(id);
				deleteNewProductServiceDAO.deleteNewProduct(id);
				deleteSpecialPriceServiceDAO.deleteSpecialPrice(id);
			}else{
				dataMap.put("deleteProduct", false);
			}
		}else{
			dataMap.put("deleteProduct", false);
		}
		return "success";
	}	


	
}
