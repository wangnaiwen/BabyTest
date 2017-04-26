package service;

import dao.WithdrawDAO;
import domain.Withdraw;
import service.dao.BaseWithdrawServiceDAO;
import service.dao.InsertWithdrawServiceDAO;

public class InsertWithdrawService extends BaseWithdrawServiceDAO implements InsertWithdrawServiceDAO{

	@Override
	public boolean insertWithdraw(Withdraw withdraw) {
		WithdrawDAO withdrawDAO = getWithdrawDAO();
		return withdrawDAO.insertWithdraw(withdraw);
	}
	

}
