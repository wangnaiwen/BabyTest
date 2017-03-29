package service;

import java.util.List;

import dao.OrderDAO;
import domain.Order;
import service.dao.BaseOrderServiceDAO;
import service.dao.FindOrderByUserIdServiceDAO;

public class FindOrderByUserIdService extends BaseOrderServiceDAO implements FindOrderByUserIdServiceDAO{

	@Override
	public List<Order> findOrderByUserId(int userId) {
		OrderDAO orderDAO = getOrderDAO();
		return orderDAO.findOrderByUserId(userId);
	}

}
