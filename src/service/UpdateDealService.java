package service;

import dao.DealDAO;
import domain.Deal;
import service.dao.BaseDealServiceDAO;
import service.dao.UpdateDealServiceDAO;

public class UpdateDealService extends BaseDealServiceDAO implements UpdateDealServiceDAO{

	@Override
	public boolean updateDeal(Deal deal) {
		DealDAO dealDAO = getDealDAO();
		return dealDAO.updateDeal(deal);
	}

}
