package service;

import dao.OrderDAO;
import service.dao.BaseOrderServiceDAO;
import service.dao.UpdateOrderTypeServiceDAO;

public class UpdateOrderTypeService extends BaseOrderServiceDAO implements UpdateOrderTypeServiceDAO{

	@Override
	public boolean updateOrderType(int id, int type) {
		OrderDAO orderDAO = getOrderDAO();
		return orderDAO.updateOrderType(id, type);
	}
	
}
