package service;

import dao.NewProductDAO;
import service.dao.BaseNewProductServiceDAO;
import service.dao.DeleteNewProductServiceDAO;

public class DeleteNewProductService extends BaseNewProductServiceDAO implements DeleteNewProductServiceDAO{

	@Override
	public boolean deleteNewProduct(int productId) {
		NewProductDAO newProductDAO = getNewProductDAO();
		return newProductDAO.deleteNewProduct(productId);
	}

}
