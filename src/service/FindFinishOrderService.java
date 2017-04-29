package service;

import java.util.List;

import dao.OrderDAO;
import domain.Order;
import service.dao.BaseOrderServiceDAO;
import service.dao.FindFinishOrderServiceDAO;

public class FindFinishOrderService extends BaseOrderServiceDAO implements FindFinishOrderServiceDAO{

	@Override
	public List<Order> findFinishOrders(int page) {
		OrderDAO orderDAO = getOrderDAO();
		return orderDAO.findFinishOrders(page);
	}

}
