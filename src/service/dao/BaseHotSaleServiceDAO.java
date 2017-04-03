package service.dao;

import dao.HotSaleDAO;

public class BaseHotSaleServiceDAO {
	private HotSaleDAO hotSaleDAO;

	public HotSaleDAO getHotSaleDAO() {
		return hotSaleDAO;
	}

	public void setHotSaleDAO(HotSaleDAO hotSaleDAO) {
		this.hotSaleDAO = hotSaleDAO;
	}
	
}
