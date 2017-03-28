package dao;

import java.util.List;

import domain.Deal;

public interface DealDAO {
	boolean insertDeal(Deal deal);
	boolean updateDeal(Deal deal);
	boolean deleteDeal(int id);
	Deal findDealById(int id);
	List<Deal> findDealByOrderId(int orderId);
}
