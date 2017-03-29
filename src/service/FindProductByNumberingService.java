package service;

import dao.ProductDAO;
import domain.Product;
import service.dao.BaseProductServiceDAO;
import service.dao.FindProductByNumberingServiceDAO;

public class FindProductByNumberingService extends BaseProductServiceDAO implements FindProductByNumberingServiceDAO{

	@Override
	public Product findProductByNumbering(String numbering) {
		ProductDAO productDAO = getProductDAO();
		return productDAO.findProductByNumbering(numbering);
	}
	
}
