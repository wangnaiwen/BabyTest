package service;

import java.util.List;

import dao.OrderDAO;
import domain.Order;
import service.dao.BaseOrderServiceDAO;
import service.dao.FindOrderByInviteeServiceDAO;

public class FindOrderByInviteeService extends BaseOrderServiceDAO implements FindOrderByInviteeServiceDAO{

	@Override
	public List<Order> findOrderByInvitee(int invitee, int number) {
		OrderDAO orderDAO = getOrderDAO();
		return orderDAO.findOrderByInvitee(invitee, number);
	}
	

}
