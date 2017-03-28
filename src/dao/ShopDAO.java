package dao;

import domain.Shop;

public interface ShopDAO {
	boolean insertShop(Shop shop);
	boolean updateShop(Shop shop);
	boolean deleteShop(int id);
	Shop findShopByUserId(int userId);
	Shop findShopById(int id);
}
