package dao;

import domain.Wallet;

public interface WalletDAO {
	boolean insertWallet(Wallet wallet);
	boolean updateWalletPassword(int userId, int password);
	boolean subWalletMoney(int userId,int money);
	boolean addWalletMoney(int userId,int money);
	boolean valiteWallet(int userId, int password);
	int findWalletMoneyByUserId(int userId);
}
