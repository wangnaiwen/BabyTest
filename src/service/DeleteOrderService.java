package service;

import dao.OrderDAO;
import service.dao.BaseOrderServiceDAO;
import service.dao.DeleteOrderServiceDAO;

public class DeleteOrderService extends BaseOrderServiceDAO implements DeleteOrderServiceDAO{

	@Override
	public boolean deleteOrder(int id) {
		OrderDAO orderDAO = getOrderDAO();
		return orderDAO.deleteOrder(id);
	}

}
