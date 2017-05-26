package service;

import dao.OffProductDAO;
import domain.Product;
import service.dao.BaseOffProductServiceDAO;
import service.dao.InsertOffProductServiceDAO;

public class InsertOffProductService extends BaseOffProductServiceDAO implements InsertOffProductServiceDAO{

	@Override
	public boolean insertOffProduct(Product product) {
		OffProductDAO offProductDAO = getOffProductDAO();
		return offProductDAO.insertOffProduct(product);
	}
	
}
