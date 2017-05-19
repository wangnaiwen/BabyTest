package service;

import dao.ProductDAO;
import service.dao.BaseProductServiceDAO;
import service.dao.UpdateProductCountByIdServiceDAO;

public class UpdateProductCountByIdService extends BaseProductServiceDAO implements UpdateProductCountByIdServiceDAO{

	@Override
	public boolean updateProductCountById(int id, int count) {
		ProductDAO productDAO = getProductDAO();
		return productDAO.updateProductCountById(id, count);
	}

}
