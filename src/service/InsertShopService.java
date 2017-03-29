package service;

import dao.ShopDAO;
import domain.Shop;
import service.dao.BaseShopServiceDAO;
import service.dao.InsertShopServiceDAO;

public class InsertShopService extends BaseShopServiceDAO implements InsertShopServiceDAO{

	@Override
	public boolean insertShop(Shop shop) {
		ShopDAO shopDAO = getShopDAO();
		return shopDAO.insertShop(shop);
	}

}
