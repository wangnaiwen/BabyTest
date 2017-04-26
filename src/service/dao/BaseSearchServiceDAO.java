package service.dao;

import dao.SearchDAO;

public class BaseSearchServiceDAO {
	private SearchDAO searchDAO;

	public SearchDAO getSearchDAO() {
		return searchDAO;
	}

	public void setSearchDAO(SearchDAO searchDAO) {
		this.searchDAO = searchDAO;
	}
	
}
