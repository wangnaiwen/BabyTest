package service;

import dao.ReceAddressDAO;
import domain.ReceAddress;

public class FindFinalReceAddressByUserIdService extends BaseReceAddressServiceDAO implements FindFinalReceAddressByUserIdServiceDAO{

	@Override
	public ReceAddress findFinalReceAddressByUserId(int userId) {
		ReceAddressDAO receAddressDAO = getReceAddressDAO();
		return receAddressDAO.findFinalReceAddressByUserId(userId);
	}

}
