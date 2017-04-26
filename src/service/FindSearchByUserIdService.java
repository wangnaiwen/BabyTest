package service;

import java.util.List;

import dao.SearchDAO;
import domain.Search;
import service.dao.BaseSearchServiceDAO;
import service.dao.FindSearchByUserIdServiceDAO;

public class FindSearchByUserIdService extends BaseSearchServiceDAO implements FindSearchByUserIdServiceDAO{

	@Override
	public List<Search> findSearchByUserId(int userId) {
		SearchDAO searchDAO = getSearchDAO();
		return searchDAO.findSearchByUserId(userId);
	}
	

}
