package service;

import dao.DealDAO;
import service.dao.BaseDealServiceDAO;
import service.dao.FindIncomeByShopIdServiceDAO;

public class FindIncomeByShopIdService extends BaseDealServiceDAO implements FindIncomeByShopIdServiceDAO{
	@Override
	public int findIncomeByShopId(int shopId) {
		DealDAO dealDAO = getDealDAO();
		return dealDAO.findIncomeByShopId(shopId);
	}
}
