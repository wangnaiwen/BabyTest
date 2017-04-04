package service.dao;

import java.util.List;

import domain.Pr;

public interface FindPrsByUserIdServiceDAO {
	List<Pr> findPrsByUserId(int userId, int number);
}
