package service;

import dao.WalletDAO;
import service.dao.BaseWalletServiceDAO;
import service.dao.SubWalletMoneyServiceDAO;

public class SubWalletMoneyService extends BaseWalletServiceDAO implements SubWalletMoneyServiceDAO{

	@Override
	public boolean subWalletMoney(int userId,int money) {
		WalletDAO walletDAO = getWalletDAO();
		return walletDAO.subWalletMoney(userId, money);
	}

}
