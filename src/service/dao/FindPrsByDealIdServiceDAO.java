package service.dao;

import java.util.List;

import domain.Pr;

public interface FindPrsByDealIdServiceDAO {
	List<Pr> findPrsByDealId(int dealId);
}
