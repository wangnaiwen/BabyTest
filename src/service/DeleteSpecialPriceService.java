package service;

import dao.SpecialPriceDAO;
import service.dao.BaseSpecialPriceServiceDAO;
import service.dao.DeleteSpecialPriceServiceDAO;

public class DeleteSpecialPriceService extends BaseSpecialPriceServiceDAO implements DeleteSpecialPriceServiceDAO{

	@Override
	public boolean deleteSpecialPrice(int productId) {
		SpecialPriceDAO specialPriceDAO = getSpecialPriceDAO();
		return specialPriceDAO.deleteSpecialPrice(productId);
	}

}
