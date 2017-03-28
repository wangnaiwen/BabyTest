package service;

import java.util.List;

import service.dao.BaseReceAddressServiceDAO;
import service.dao.FindReceAddressByUserIdServiceDAO;
import dao.ReceAddressDAO;
import domain.ReceAddress;

public class FindReceAddressByUserIdService extends BaseReceAddressServiceDAO implements FindReceAddressByUserIdServiceDAO{

	@Override
	public List<ReceAddress> findReceAddressByUserId(int userId) {
		ReceAddressDAO receAddressDAO = getReceAddressDAO();
		return receAddressDAO.findReceAddressByUserId(userId);
	}
	
}
