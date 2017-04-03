package dao;

import java.util.List;

import domain.ShoppingCar;

public interface ShoppingCarDAO {
	boolean insertShoppingCar(ShoppingCar car);
	boolean updateShoppingCar(ShoppingCar car);
	boolean deleteShoppingCar(int id);
	List<ShoppingCar> findShoppingCarByUserId(int userId);
}
