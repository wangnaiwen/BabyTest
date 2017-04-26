package service;

import java.util.List;

import dao.ProductDAO;
import domain.Product;
import service.dao.BaseProductServiceDAO;
import service.dao.FindProductByKeyServiceDAO;

public class FindProductByKeyService extends BaseProductServiceDAO implements FindProductByKeyServiceDAO{

	@Override
	public List<Product> findProductByKey(String key) {
		ProductDAO productDAO = getProductDAO();
		return productDAO.findProductByKey(key);
	}
	
}
