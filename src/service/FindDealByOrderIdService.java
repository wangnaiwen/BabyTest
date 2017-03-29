package service;

import java.util.List;

import dao.DealDAO;
import domain.Deal;
import service.dao.BaseDealServiceDAO;
import service.dao.FindDealByOrderIdServiceDAO;

public class FindDealByOrderIdService extends BaseDealServiceDAO implements FindDealByOrderIdServiceDAO{

	@Override
	public List<Deal> findDealByOrderId(int orderId) {
		DealDAO dealDAO = getDealDAO();
		return dealDAO.findDealByOrderId(orderId);
	}

}
