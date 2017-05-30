package service.dao;

import java.util.List;

import domain.Order;

public interface FindQuitOrdersServiceDAO {
	List<Order> findQuitOrders(int userId);
}
