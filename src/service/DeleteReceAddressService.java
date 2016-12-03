package service;

import dao.ReceAddressDAO;
import domain.ReceAddress;

public class DeleteReceAddressService extends BaseReceAddressServiceDAO implements DeleteReceAddressServiceDAO{

	@Override
	public boolean deleteReceAddress(ReceAddress receAddress) {
		ReceAddressDAO receAddressDAO = getReceAddressDAO();
		return receAddressDAO.deleteReceAddress(receAddress);
	}

}
