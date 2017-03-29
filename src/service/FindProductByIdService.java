package service;

import dao.ProductDAO;
import domain.Product;
import service.dao.BaseProductServiceDAO;
import service.dao.FindProductByIdServiceDAO;

public class FindProductByIdService extends BaseProductServiceDAO implements FindProductByIdServiceDAO{

	@Override
	public Product findProductById(int id) {
		ProductDAO productDAO = getProductDAO();
		return productDAO.findProductById(id);
	}

}
