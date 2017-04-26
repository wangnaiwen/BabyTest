package service.dao;

import dao.WithdrawDAO;

public class BaseWithdrawServiceDAO {
	private WithdrawDAO withdrawDAO;

	public WithdrawDAO getWithdrawDAO() {
		return withdrawDAO;
	}

	public void setWithdrawDAO(WithdrawDAO withdrawDAO) {
		this.withdrawDAO = withdrawDAO;
	}
	
}
