package service;

import dao.ShoppingCarDAO;
import service.dao.BaseShoppingCarServiceDAO;
import service.dao.UpdateShoppingCarProductCountServiceDAO;

public class UpdateShoppingCarProductCountService extends BaseShoppingCarServiceDAO implements UpdateShoppingCarProductCountServiceDAO{

	@Override
	public boolean updateShoppingCarProductCount(int id, int count) {
		ShoppingCarDAO shoppingCarDAO = getShoppingCarDAO();
		return shoppingCarDAO.updateShoppingCarProductCount(id, count);
	}

}
