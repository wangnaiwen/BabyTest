package service;

import java.util.List;

import dao.ShopDAO;
import domain.Shop;
import service.dao.BaseShopServiceDAO;
import service.dao.FindShopByInviteeServiceDAO;

public class FindShopByInviteeService extends BaseShopServiceDAO implements FindShopByInviteeServiceDAO{

	@Override
	public List<Shop> findShopByInvitee(int invitee) {
		ShopDAO shopDAO = getShopDAO();
		return shopDAO.findShopByInvitee(invitee);
	}

}
