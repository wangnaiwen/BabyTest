package service;

import dao.ProductDAO;
import service.dao.BaseProductServiceDAO;
import service.dao.FindProductCountByIdServiceDAO;

public class FindProductCountByIdService extends BaseProductServiceDAO implements FindProductCountByIdServiceDAO{

	@Override
	public int findProductCountById(int id) {
		ProductDAO productDAO = getProductDAO();
		return productDAO.findProductCountById(id);
	}
	
}
