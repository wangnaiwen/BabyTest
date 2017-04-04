package service.dao;

import java.util.List;

import domain.Pr;

public interface FindPrsByProductIdServiceDAO {
	List<Pr> findPrsByProductId(int productId, int number);
}
