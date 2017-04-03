package service;

import java.util.List;

import dao.ShoppingCarDAO;
import domain.ShoppingCar;
import service.dao.BaseShoppingCarServiceDAO;
import service.dao.FindShoppingCarByUserIdServiceDAO;

public class FindShoppingCarByUserIdService extends BaseShoppingCarServiceDAO implements FindShoppingCarByUserIdServiceDAO{

	@Override
	public List<ShoppingCar> findShoppingCarByUserId(int userId) {
		ShoppingCarDAO shoppingCarDAO = getShoppingCarDAO();
		return shoppingCarDAO.findShoppingCarByUserId(userId);
	}

}
