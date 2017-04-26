package dao;

import java.util.List;

import domain.Search;

public interface SearchDAO {
	boolean insertSearch(Search search);
	List<Search> findSearchByUserId(int userId);
}
