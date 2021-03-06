package service;

import service.dao.BaseReceAddressServiceDAO;
import service.dao.UpdateReceAddressServiceDAO;
import dao.ReceAddressDAO;
import domain.ReceAddress;

public class UpdateReceAddressService extends BaseReceAddressServiceDAO implements UpdateReceAddressServiceDAO{

	@Override
	public boolean UpdateReceAddress(ReceAddress receAddress) {
		ReceAddressDAO receAddressDAO = getReceAddressDAO();
		return receAddressDAO.updateReceAddress(receAddress);
	}

}
