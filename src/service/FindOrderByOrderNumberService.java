package service;

import dao.OrderDAO;
import domain.Order;
import service.dao.BaseOrderServiceDAO;
import service.dao.FindOrderByOrderNumberServiceDAO;

public class FindOrderByOrderNumberService extends BaseOrderServiceDAO 
	implements FindOrderByOrderNumberServiceDAO{

	@Override
	public Order findOrderByNumbering(String order_number) {
		OrderDAO orderDAO = getOrderDAO();
		return orderDAO.findOrderByNumbering(order_number);
	}

}
