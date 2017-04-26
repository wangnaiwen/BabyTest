package dao;

import domain.Wallet;

public interface WalletDAO {
	boolean insertWallet(Wallet wallet);
	boolean updateWalletPassword(int userId, String password);
	boolean subWalletMoney(int userId,int money);
	boolean addWalletMoney(int userId,int money);
	boolean valiteWallet(int userId, String password);
	int findWalletMoneyByUserId(int userId);
}
