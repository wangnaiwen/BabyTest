package service;

import dao.ShopDAO;
import domain.Shop;
import service.dao.BaseShopServiceDAO;
import service.dao.FindShopByIdServiceDAO;

public class FindShopByIdService extends BaseShopServiceDAO implements FindShopByIdServiceDAO{

	@Override
	public Shop findShopById(int id) {
		ShopDAO shopDAO = getShopDAO();
		return shopDAO.findShopById(id);
	}
	

}
