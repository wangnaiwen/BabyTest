package service;

import dao.DealDAO;
import domain.Deal;
import service.dao.BaseDealServiceDAO;
import service.dao.InsertDealServiceDAO;

public class InsertDealService extends BaseDealServiceDAO implements InsertDealServiceDAO{

	@Override
	public boolean insertDeal(Deal deal) {
		DealDAO dealDAO = getDealDAO();
		return dealDAO.insertDeal(deal);
	}

}
