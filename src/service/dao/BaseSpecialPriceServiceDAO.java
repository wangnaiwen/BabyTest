package service.dao;

import dao.SpecialPriceDAO;

public class BaseSpecialPriceServiceDAO {
	private SpecialPriceDAO specialPriceDAO;

	public SpecialPriceDAO getSpecialPriceDAO() {
		return specialPriceDAO;
	}

	public void setSpecialPriceDAO(SpecialPriceDAO specialPriceDAO) {
		this.specialPriceDAO = specialPriceDAO;
	}
	
}
