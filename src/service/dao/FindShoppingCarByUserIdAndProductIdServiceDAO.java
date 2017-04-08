package service.dao;

import domain.ShoppingCar;

public interface FindShoppingCarByUserIdAndProductIdServiceDAO {
	ShoppingCar findShoppingCarByUserIdAndProductId(int userId, int productId);

}
