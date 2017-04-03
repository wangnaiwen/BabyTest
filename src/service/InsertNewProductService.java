package service;

import dao.NewProductDAO;
import domain.NewProduct;
import service.dao.BaseNewProductServiceDAO;
import service.dao.InsertNewProductServiceDAO;

public class InsertNewProductService extends BaseNewProductServiceDAO implements InsertNewProductServiceDAO{

	@Override
	public boolean insertNewProduct(NewProduct newPrduct) {
		NewProductDAO newProductDAO = getNewProductDAO();
		return newProductDAO.insertNewProduct(newPrduct);
	}

}
