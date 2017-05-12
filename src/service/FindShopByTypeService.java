package service;

import java.util.List;

import dao.ShopDAO;
import domain.Shop;
import service.dao.BaseShopServiceDAO;
import service.dao.FindShopByTypeServiceDAO;

public class FindShopByTypeService extends BaseShopServiceDAO implements FindShopByTypeServiceDAO{

	@Override
	public List<Shop> findShopByType(int type, int page) {
		ShopDAO shopDAO = getShopDAO();
		return shopDAO.findShopByType(type, page);
	}
	
}
