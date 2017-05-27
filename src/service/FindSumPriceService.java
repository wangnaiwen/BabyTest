package service;

import dao.DealDAO;
import service.dao.FindSumPriceServiceDAO;
import service.dao.BaseDealServiceDAO;

public class FindSumPriceService extends BaseDealServiceDAO implements FindSumPriceServiceDAO{

	@Override
	public int findSumPriceByDay(String startDay, String endDay) {
		DealDAO dealDAO = getDealDAO();
		return dealDAO.findSumPriceByDay(startDay, endDay);
	}

}
