package web.service;

import dao.OrderDAO;
import service.dao.BaseOrderServiceDAO;

public class OrderService extends BaseOrderServiceDAO implements OrderServiceDAO{

	@Override
	public boolean updateOrderType(int id, int type) {
		OrderDAO orderDAO = getOrderDAO();
		return orderDAO.updateOrderType(id, type);
	}
	
}
