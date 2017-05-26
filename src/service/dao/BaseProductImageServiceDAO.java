package service.dao;

import dao.ProductImageDAO;

public class BaseProductImageServiceDAO {
	private ProductImageDAO productImageDAO;

	public ProductImageDAO getProductImageDAO() {
		return productImageDAO;
	}

	public void setProductImageDAO(ProductImageDAO productImageDAO) {
		this.productImageDAO = productImageDAO;
	}
	
}
