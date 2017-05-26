package service;

import dao.SpecialPriceDAO;
import domain.SpecialPrice;
import service.dao.BaseSpecialPriceServiceDAO;
import service.dao.InsertSpecialPriceServiceDAO;

public class InsertSpecialPriceService extends BaseSpecialPriceServiceDAO implements InsertSpecialPriceServiceDAO{

	@Override
	public boolean insertSpecialPrice(SpecialPrice specialPrice) {
		SpecialPriceDAO specialPriceDAO = getSpecialPriceDAO();
		return specialPriceDAO.insertSpecialPrice(specialPrice);
	}

}
