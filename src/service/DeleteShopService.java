package service;

import dao.ShopDAO;
import service.dao.BaseShopServiceDAO;
import service.dao.DeleteShopServiceDAO;

public class DeleteShopService extends BaseShopServiceDAO implements DeleteShopServiceDAO{

	@Override
	public boolean deleteShop(int id) {
		ShopDAO shopDAO = getShopDAO();
		return shopDAO.deleteShop(id)
;	}
	

}
