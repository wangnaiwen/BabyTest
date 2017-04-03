package service.dao;

import dao.ShoppingCarDAO;

public class BaseShoppingCarServiceDAO {
	private ShoppingCarDAO shoppingCarDAO;

	public ShoppingCarDAO getShoppingCarDAO() {
		return shoppingCarDAO;
	}

	public void setShoppingCarDAO(ShoppingCarDAO shoppingCarDAO) {
		this.shoppingCarDAO = shoppingCarDAO;
	}
	
}
