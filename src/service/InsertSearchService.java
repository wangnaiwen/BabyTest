package service;

import dao.SearchDAO;
import domain.Search;
import service.dao.BaseSearchServiceDAO;
import service.dao.InsertSearchServiceDAO;

public class InsertSearchService extends BaseSearchServiceDAO implements InsertSearchServiceDAO{

	@Override
	public boolean insertSearch(Search search) {
		SearchDAO searchDAO = getSearchDAO();
		return searchDAO.insertSearch(search);
	}
	
	
}
