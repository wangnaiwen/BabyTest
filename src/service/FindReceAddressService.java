package service;

import dao.ReceAddressDAO;
import domain.ReceAddress;

public class FindReceAddressService extends BaseReceAddressServiceDAO implements FindReceAddressServiceDAO{

	@Override
	public ReceAddress findReceAddressById(int id) {
		ReceAddressDAO receAddressDAO = getReceAddressDAO();
		return receAddressDAO.findReceAddressById(id);
	}
	
}
