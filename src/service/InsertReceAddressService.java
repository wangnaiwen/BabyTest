package service;

import service.dao.BaseReceAddressServiceDAO;
import service.dao.InsertReceAddressServiceDAO;
import dao.ReceAddressDAO;
import domain.ReceAddress;

public class InsertReceAddressService extends BaseReceAddressServiceDAO implements InsertReceAddressServiceDAO{

	@Override
	public boolean insertReceAddress(ReceAddress receAddress) {
		ReceAddressDAO receAddressDAO = getReceAddressDAO();
		return receAddressDAO.insertReceAddress(receAddress);
	}
	
}
