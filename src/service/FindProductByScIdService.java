package service;

import java.util.List;

import dao.ProductDAO;
import domain.Product;
import service.dao.BaseProductServiceDAO;
import service.dao.FindProductByScIdServiceDAO;

public class FindProductByScIdService extends BaseProductServiceDAO implements FindProductByScIdServiceDAO{

	@Override
	public List<Product> findProductByScId(int scId, int number) {
		ProductDAO productDAO = getProductDAO();
		return productDAO.findProductByScId(scId, number);
	}
	
}
