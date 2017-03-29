package service.dao;

import dao.ShopDAO;

public class BaseShopServiceDAO {
	private ShopDAO shopDAO;

	public ShopDAO getShopDAO() {
		return shopDAO;
	}

	public void setShopDAO(ShopDAO shopDAO) {
		this.shopDAO = shopDAO;
	}

	
}
