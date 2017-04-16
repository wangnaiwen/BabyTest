package service;

import dao.WalletDAO;
import service.dao.AddWalletMoneyServiceDAO;
import service.dao.BaseWalletServiceDAO;

public class AddWalletMoneyService extends BaseWalletServiceDAO implements AddWalletMoneyServiceDAO{

	@Override
	public boolean addWalletMoney(int userId, int money) {
		WalletDAO walletDAO = getWalletDAO();
		return walletDAO.addWalletMoney(userId, money);
	}

}
