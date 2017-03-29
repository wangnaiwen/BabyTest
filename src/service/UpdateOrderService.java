package service;

import dao.OrderDAO;
import domain.Order;
import service.dao.BaseOrderServiceDAO;
import service.dao.UpdateOrderServiceDAO;

public class UpdateOrderService extends BaseOrderServiceDAO implements UpdateOrderServiceDAO{

	@Override
	public boolean updateOrder(Order order) {
		OrderDAO orderDAO = getOrderDAO();
		return orderDAO.updateOrder(order);
	}

}
