package service.dao;

import java.util.List;

import domain.Shop;

public interface FindShopByInviteeServiceDAO {
	List<Shop> findShopByInvitee(int invitee);
}
