package service;

import java.util.List;

import dao.SpecialPriceDAO;
import domain.SpecialPrice;
import service.dao.BaseSpecialPriceServiceDAO;
import service.dao.FindSpecialPriceServiceDAO;

public class FindSpecialPriceService extends BaseSpecialPriceServiceDAO implements FindSpecialPriceServiceDAO{

	@Override
	public List<SpecialPrice> findSpecialPrices() {
		SpecialPriceDAO specialPriceDAO = getSpecialPriceDAO();
		return specialPriceDAO.findSpecialPrices();
	}

}
