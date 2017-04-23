package service.dao;

import java.util.List;

import domain.Order;

public interface FindOrderByShopIdServiceDAO {
	List<Order> findOrderByShopId(int shopId, int number);
}
