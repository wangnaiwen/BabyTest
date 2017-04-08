package service;

import dao.ShoppingCarDAO;
import service.dao.BaseShoppingCarServiceDAO;
import service.dao.UpdateShoppingCarAddOneProductServiceDAO;

public class UpdateShoppingCarAddOneProductService extends BaseShoppingCarServiceDAO 
	implements UpdateShoppingCarAddOneProductServiceDAO{

	@Override
	public boolean updateShoppingCarAddOneProduct(int id) {
		ShoppingCarDAO shoppingCarDAO = getShoppingCarDAO();
		return shoppingCarDAO.updateShoppingCarAddOneProduct(id);
	}

}
