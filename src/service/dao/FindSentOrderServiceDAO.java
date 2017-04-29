package service.dao;

import java.util.List;

import domain.Order;

public interface FindSentOrderServiceDAO {
	List<Order> findbeSentOrders(int page);
}
