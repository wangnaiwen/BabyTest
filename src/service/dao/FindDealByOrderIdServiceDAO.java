package service.dao;

import java.util.List;

import domain.Deal;

public interface FindDealByOrderIdServiceDAO {
	List<Deal> findDealByOrderId(int orderId);
}
