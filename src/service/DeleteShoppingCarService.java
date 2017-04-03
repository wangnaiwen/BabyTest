package service;

import dao.ShoppingCarDAO;
import service.dao.BaseShoppingCarServiceDAO;
import service.dao.DeleteShoppingCarServiceDAO;

public class DeleteShoppingCarService extends BaseShoppingCarServiceDAO implements DeleteShoppingCarServiceDAO{

	@Override
	public boolean deleteShoppingCar(int id) {
		ShoppingCarDAO shoppingCarDAO = getShoppingCarDAO();
		return shoppingCarDAO.deleteShoppingCar(id);
	}

}
