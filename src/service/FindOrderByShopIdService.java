package service;

import java.util.List;

import dao.OrderDAO;
import domain.Order;
import service.dao.BaseOrderServiceDAO;
import service.dao.FindOrderByShopIdServiceDAO;

public class FindOrderByShopIdService extends BaseOrderServiceDAO implements FindOrderByShopIdServiceDAO{

	@Override
	public List<Order> findOrderByShopId(int shopId) {
		OrderDAO orderDAO = getOrderDAO();
		return orderDAO.findOrderByShopId(shopId);
	}

}
