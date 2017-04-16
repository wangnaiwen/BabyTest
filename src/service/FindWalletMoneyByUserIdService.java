package service;

import dao.WalletDAO;
import service.dao.BaseWalletServiceDAO;
import service.dao.FindWalletMoneyByUserIdServiceDAO;

public class FindWalletMoneyByUserIdService extends BaseWalletServiceDAO implements FindWalletMoneyByUserIdServiceDAO{

	@Override
	public int findWalletMoneyByUserId(int userId) {
		WalletDAO walletDAO = getWalletDAO();
		return walletDAO.findWalletMoneyByUserId(userId);
	}
}
