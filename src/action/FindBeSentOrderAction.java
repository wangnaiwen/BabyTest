package action;

import java.util.List;

import service.dao.FindSentOrderServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Order;

public class FindBeSentOrderAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int page;
	private FindSentOrderServiceDAO findSentOrderServiceDAO;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public FindSentOrderServiceDAO getFindSentOrderServiceDAO() {
		return findSentOrderServiceDAO;
	}

	public void setFindSentOrderServiceDAO(
			FindSentOrderServiceDAO findSentOrderServiceDAO) {
		this.findSentOrderServiceDAO = findSentOrderServiceDAO;
	}

	@Override
	public String execute() throws Exception {
		List<Order> orders = findSentOrderServiceDAO.findbeSentOrders(page);
		
		if(orders != null){
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
}
