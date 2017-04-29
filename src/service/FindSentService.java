package service;

import java.util.List;

import dao.OrderDAO;
import domain.Order;
import service.dao.BaseOrderServiceDAO;
import service.dao.FindSentOrderServiceDAO;

public class FindSentService extends BaseOrderServiceDAO implements FindSentOrderServiceDAO{

	@Override
	public List<Order> findbeSentOrders(int page) {
		OrderDAO orderDAO = getOrderDAO();
		return orderDAO.findbeSentOrders(page);
	}

}
