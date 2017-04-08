package service;

import dao.ShoppingCarDAO;
import domain.ShoppingCar;
import service.dao.BaseShoppingCarServiceDAO;
import service.dao.FindShoppingCarByUserIdAndProductIdServiceDAO;

public class FindShoppingCarByUserIdAndProductIdService extends BaseShoppingCarServiceDAO
	implements FindShoppingCarByUserIdAndProductIdServiceDAO{

	@Override
	public ShoppingCar findShoppingCarByUserIdAndProductId(int userId,
			int productId) {
		ShoppingCarDAO shoppingCarDAO = getShoppingCarDAO();
		return shoppingCarDAO.findShoppingCarByUserIdAndProductId(userId, productId);
	}

}
