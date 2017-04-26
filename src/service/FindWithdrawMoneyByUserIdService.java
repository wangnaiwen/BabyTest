package service;

import dao.WithdrawDAO;
import service.dao.BaseWithdrawServiceDAO;
import service.dao.FindWithdrawMoneyByUserIServiceDAO;

public class FindWithdrawMoneyByUserIdService extends BaseWithdrawServiceDAO implements FindWithdrawMoneyByUserIServiceDAO{

	@Override
	public int findMoneyByuserId(int userId) {
		WithdrawDAO withdrawDAO = getWithdrawDAO();
		return withdrawDAO.findMoneyByuserId(userId);
	}

}
