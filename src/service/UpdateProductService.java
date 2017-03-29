package service;

import dao.ProductDAO;
import domain.Product;
import service.dao.BaseProductServiceDAO;
import service.dao.UpdateProductServiceDAO;

public class UpdateProductService extends BaseProductServiceDAO implements UpdateProductServiceDAO{

	@Override
	public boolean updateProduct(Product product) {
		ProductDAO productDAO = getProductDAO();
		return productDAO.updateProduct(product);
	}
	
}
