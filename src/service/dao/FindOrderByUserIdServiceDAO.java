package service.dao;

import java.util.List;

import domain.Order;

public interface FindOrderByUserIdServiceDAO {
	List<Order> findOrderByUserId(int userId);
}
