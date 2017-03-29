package service;

import dao.ShopDAO;
import domain.Shop;
import service.dao.BaseShopServiceDAO;
import service.dao.UpdateShopServiceDAO;

public class UpdateShopService extends BaseShopServiceDAO implements UpdateShopServiceDAO{

	@Override
	public boolean updateShop(Shop shop) {
		ShopDAO shopDAO = getShopDAO();
		return shopDAO.updateShop(shop);
	}

}
