package service.dao;

import java.util.List;

import domain.Order;

public interface FindOrderByInviteeServiceDAO {
	List<Order> findOrderByInvitee(int invitee, int number);
}
