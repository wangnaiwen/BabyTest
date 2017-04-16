package service;

import service.dao.BaseWalletServiceDAO;
import service.dao.ValiteWalletServiceDAO;
import dao.WalletDAO;

public class ValiteWalletService extends BaseWalletServiceDAO implements ValiteWalletServiceDAO{

	@Override
	public boolean valiteWallet(int userId, int password) {
		WalletDAO walletDAO = getWalletDAO();
		return walletDAO.valiteWallet(userId, password);
	}
}
