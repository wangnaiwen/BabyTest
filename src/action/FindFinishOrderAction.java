package action;

import java.util.List;

import service.dao.FindFinishOrderServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Order;

public class FindFinishOrderAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private int page;
	private FindFinishOrderServiceDAO findFinishOrderServiceDAO;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public FindFinishOrderServiceDAO getFindFinishOrderServiceDAO() {
		return findFinishOrderServiceDAO;
	}
	public void setFindFinishOrderServiceDAO(
			FindFinishOrderServiceDAO findFinishOrderServiceDAO) {
		this.findFinishOrderServiceDAO = findFinishOrderServiceDAO;
	}
	@Override
	public String execute() throws Exception {
		List<Order> orders = findFinishOrderServiceDAO.findFinishOrders(page);
		if(orders != null){
			
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
}
