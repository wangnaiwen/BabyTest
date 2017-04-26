package dao;

import domain.Withdraw;

public interface WithdrawDAO {
	boolean insertWithdraw(Withdraw withdraw);
	int findMoneyByuserId(int userId);
}
