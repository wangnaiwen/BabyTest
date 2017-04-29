package service.dao;

import java.util.List;

import domain.Order;

public interface FindFinishOrderServiceDAO {
	List<Order> findFinishOrders(int page);
}
