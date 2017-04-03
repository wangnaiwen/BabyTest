package service;

import dao.HotSaleDAO;
import domain.HotSale;
import service.dao.BaseHotSaleServiceDAO;
import service.dao.InsertHotSaleServiceDAO;

public class InsertHotSaleService extends BaseHotSaleServiceDAO implements InsertHotSaleServiceDAO{

	@Override
	public boolean insertHotSale(HotSale hotSale) {
		HotSaleDAO hotSaleDAO = getHotSaleDAO();
		return hotSaleDAO.insertHotSale(hotSale);
	}

}
