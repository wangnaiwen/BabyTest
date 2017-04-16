package service;

import dao.WalletDAO;
import domain.Wallet;
import service.dao.BaseWalletServiceDAO;
import service.dao.InsertWalletServiceDAO;

public class InsertWalletService extends BaseWalletServiceDAO implements InsertWalletServiceDAO{

	@Override
	public boolean insertWallet(Wallet wallet) {
		WalletDAO walletDAO = getWalletDAO();
		return walletDAO.insertWallet(wallet);
	}

}
