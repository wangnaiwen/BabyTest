package service;

import java.util.List;

import dao.DealDAO;
import bean.ProductSaleCount;
import service.dao.BaseDealServiceDAO;
import service.dao.FindProductSaleCountServiceDAO;

public class FindProductSaleCountService extends BaseDealServiceDAO implements FindProductSaleCountServiceDAO{

	@Override
	public List<ProductSaleCount> findPoductSaleCount() {
		DealDAO dealDAO = getDealDAO();
		return dealDAO.findPoductSaleCount();
	}

}
