package service;

import dao.ProductDAO;
import service.dao.BaseProductServiceDAO;
import service.dao.DeleteProductServiceDAO;

public class DeleteProductService extends BaseProductServiceDAO implements DeleteProductServiceDAO{

	@Override
	public boolean deleteProduct(int id) {
		ProductDAO productDAO = getProductDAO();
		return productDAO.deleteProduct(id);
	}

}
