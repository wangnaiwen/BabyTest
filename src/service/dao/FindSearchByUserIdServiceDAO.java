package service.dao;

import java.util.List;

import domain.Search;

public interface FindSearchByUserIdServiceDAO {
	List<Search> findSearchByUserId(int userId);
}
