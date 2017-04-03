package service;

import java.util.List;

import dao.NewProductDAO;
import domain.NewProduct;
import service.dao.BaseNewProductServiceDAO;
import service.dao.FindNewProductServiceDAO;

public class FindNewProductService extends BaseNewProductServiceDAO implements FindNewProductServiceDAO{

	@Override
	public List<NewProduct> findNewProducts() {
		NewProductDAO newProductDAO = getNewProductDAO();
		return newProductDAO.findNewProducts();
	}

}
