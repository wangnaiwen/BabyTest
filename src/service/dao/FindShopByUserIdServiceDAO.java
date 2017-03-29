package service.dao;

import domain.Shop;

public interface FindShopByUserIdServiceDAO {
	Shop findShopByUserId(int userId);
}
