package service;

import dao.DealDAO;
import service.dao.BaseDealServiceDAO;
import service.dao.FindIncomeByInviteeServiceDAO;

public class FindIncomeByInviteeService extends BaseDealServiceDAO implements FindIncomeByInviteeServiceDAO{

	@Override
	public int findIncomeByInvitee(int invitee) {
		DealDAO dealDAO = getDealDAO();
		return dealDAO.findIncomeByInvitee(invitee);
	}
}
