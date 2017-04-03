package service.dao;

import dao.NewProductDAO;

public class BaseNewProductServiceDAO {
	private NewProductDAO newProductDAO;

	public NewProductDAO getNewProductDAO() {
		return newProductDAO;
	}

	public void setNewProductDAO(NewProductDAO newProductDAO) {
		this.newProductDAO = newProductDAO;
	}
	
}
