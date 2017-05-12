package service;

import dao.ShopDAO;
import service.dao.BaseShopServiceDAO;
import service.dao.UpdateShopTypeServiceDAO;

public class UpdateShopTypeService extends BaseShopServiceDAO implements UpdateShopTypeServiceDAO{

	@Override
	public boolean updateShopType(int id, int type) {
		ShopDAO shopDAO = getShopDAO();
		return shopDAO.updateShopType(id, type);
	}
	
}
