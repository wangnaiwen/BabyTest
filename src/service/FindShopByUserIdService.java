package service;

import dao.ShopDAO;
import domain.Shop;
import service.dao.BaseShopServiceDAO;
import service.dao.FindShopByUserIdServiceDAO;

public class FindShopByUserIdService extends BaseShopServiceDAO implements FindShopByUserIdServiceDAO{

	@Override
	public Shop findShopByUserId(int userId) {
		ShopDAO shopDAO = getShopDAO();
		return shopDAO.findShopByUserId(userId);
	}
	

}
