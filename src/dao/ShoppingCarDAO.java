package dao;

import java.util.List;

import domain.ShoppingCar;

public interface ShoppingCarDAO {
	boolean insertShoppingCar(ShoppingCar car);
	boolean updateShoppingCar(ShoppingCar car);
	boolean updateShoppingCarProductCount(int id, int count);
	boolean updateShoppingCarAddOneProduct(int id);
	boolean deleteShoppingCar(int id);
	List<ShoppingCar> findShoppingCarByUserId(int userId);
	ShoppingCar findShoppingCarByUserIdAndProductId(int userId, int productId);
}
