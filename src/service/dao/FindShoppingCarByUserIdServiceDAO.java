package service.dao;

import java.util.List;

import domain.ShoppingCar;

public interface FindShoppingCarByUserIdServiceDAO {

	List<ShoppingCar> findShoppingCarByUserId(int userId);
}
