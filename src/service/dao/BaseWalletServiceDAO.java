package service.dao;

import dao.WalletDAO;

public class BaseWalletServiceDAO {
	private WalletDAO walletDAO;

	public WalletDAO getWalletDAO() {
		return walletDAO;
	}

	public void setWalletDAO(WalletDAO walletDAO) {
		this.walletDAO = walletDAO;
	}
}
