package service;

import dao.WalletDAO;
import service.dao.BaseWalletServiceDAO;
import service.dao.UpdateWalletPasswordServiceDAO;

public class UpdateWalletPasswordService extends BaseWalletServiceDAO implements UpdateWalletPasswordServiceDAO{

	@Override
	public boolean updateWalletPassword(int userId, int password) {
		WalletDAO walletDAO = getWalletDAO();
		return walletDAO.updateWalletPassword(userId,password);
	}

}
