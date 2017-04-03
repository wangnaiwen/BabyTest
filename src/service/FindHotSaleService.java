package service;

import java.util.List;

import dao.HotSaleDAO;
import domain.HotSale;
import service.dao.BaseHotSaleServiceDAO;
import service.dao.FindHotSaleServiceDAO;

public class FindHotSaleService extends BaseHotSaleServiceDAO implements FindHotSaleServiceDAO{

	@Override
	public List<HotSale> findHotSales() {
		HotSaleDAO hotSaleDAO = getHotSaleDAO();
		return hotSaleDAO.findHotSales();
	}

}
