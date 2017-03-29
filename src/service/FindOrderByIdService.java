package service;

import dao.OrderDAO;
import domain.Order;
import service.dao.BaseOrderServiceDAO;
import service.dao.FindOrderByIdServiceDAO;

public class FindOrderByIdService extends BaseOrderServiceDAO implements FindOrderByIdServiceDAO{

	@Override
	public Order findOrderById(int id) {
		OrderDAO orderDAO = getOrderDAO();
		return orderDAO.findOrderById(id);
	}

}
