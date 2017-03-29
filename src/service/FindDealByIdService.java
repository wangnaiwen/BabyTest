package service;

import dao.DealDAO;
import domain.Deal;
import service.dao.BaseDealServiceDAO;
import service.dao.FindDealByIdServiceDAO;

public class FindDealByIdService extends BaseDealServiceDAO implements FindDealByIdServiceDAO{

	@Override
	public Deal findDealById(int id) {
		DealDAO dealDAO = getDealDAO();
		return dealDAO.findDealById(id);
	}

}
