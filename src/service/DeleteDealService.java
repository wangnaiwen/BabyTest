package service;

import dao.DealDAO;
import service.dao.BaseDealServiceDAO;
import service.dao.DeleteDealServiceDAO;

public class DeleteDealService extends BaseDealServiceDAO implements DeleteDealServiceDAO{

	@Override
	public boolean deleteDeal(int id) {
		DealDAO dealDAO = getDealDAO();
		return dealDAO.deleteDeal(id);
	}

}
