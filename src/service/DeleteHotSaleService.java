package service;

import dao.HotSaleDAO;
import service.dao.BaseHotSaleServiceDAO;
import service.dao.DeleteHotSaleServiceDAO;

public class DeleteHotSaleService extends BaseHotSaleServiceDAO implements DeleteHotSaleServiceDAO{

	@Override
	public boolean deleteHotSale(int productId) {
		HotSaleDAO hotSaleDAO = getHotSaleDAO();
		return hotSaleDAO.deleteHotSale(productId);
	}

}
