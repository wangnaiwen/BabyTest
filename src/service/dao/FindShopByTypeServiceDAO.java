package service.dao;

import java.util.List;

import domain.Shop;

public interface FindShopByTypeServiceDAO {
	List<Shop> findShopByType(int type, int page);
}
