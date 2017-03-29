package service;

import dao.ProductDAO;
import domain.Product;
import service.dao.BaseProductServiceDAO;
import service.dao.InsertProductServiceDAO;

public class InsertProductService extends BaseProductServiceDAO implements InsertProductServiceDAO{

	@Override
	public boolean insertProduct(Product product) {
		ProductDAO productDAO = getProductDAO();
		return productDAO.insertProduct(product);
	}

}
