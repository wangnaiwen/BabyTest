package service;

import dao.ShoppingCarDAO;
import domain.ShoppingCar;
import service.dao.BaseShoppingCarServiceDAO;
import service.dao.UpdateShoppingCarServiceDAO;

public class UpdateShoppingCarService extends BaseShoppingCarServiceDAO implements UpdateShoppingCarServiceDAO{

	@Override
	public boolean updateShoppingCar(ShoppingCar car) {
		ShoppingCarDAO shoppingCarDAO = getShoppingCarDAO();
		return shoppingCarDAO.updateShoppingCar(car);
	}

}
