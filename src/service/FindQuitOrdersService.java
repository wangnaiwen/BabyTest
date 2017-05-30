package service;

import java.util.List;

import dao.OrderDAO;
import domain.Order;
import service.dao.BaseOrderServiceDAO;
import service.dao.FindQuitOrdersServiceDAO;

public class FindQuitOrdersService extends BaseOrderServiceDAO implements FindQuitOrdersServiceDAO{

	@Override
	public List<Order> findQuitOrders(int userId) {
		OrderDAO orderDAO = getOrderDAO();
		return orderDAO.findQuitOrders(userId);
	}

}
