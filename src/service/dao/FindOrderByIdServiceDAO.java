package service.dao;

import domain.Order;

public interface FindOrderByIdServiceDAO {
	Order findOrderById(int id);
}
