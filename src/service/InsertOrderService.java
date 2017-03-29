package service;

import dao.OrderDAO;
import domain.Order;
import service.dao.BaseOrderServiceDAO;
import service.dao.InsertOrderServiceDAO;

public class InsertOrderService extends BaseOrderServiceDAO implements InsertOrderServiceDAO{

	@Override
	public boolean insertOrder(Order order) {
		OrderDAO orderDAO = getOrderDAO();
		return orderDAO.insertOrder(order);
	}

}
