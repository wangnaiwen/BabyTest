package service;

import dao.ShoppingCarDAO;
import domain.ShoppingCar;
import service.dao.BaseShoppingCarServiceDAO;
import service.dao.InsertShoppingCarServiceDAO;

public class InsertShoppingCarService extends BaseShoppingCarServiceDAO implements InsertShoppingCarServiceDAO{

	@Override
	public boolean insertShoppingCar(ShoppingCar car) {
		ShoppingCarDAO shoppingCarDAO = getShoppingCarDAO();
		return shoppingCarDAO.insertShoppingCar(car);
	}

}
