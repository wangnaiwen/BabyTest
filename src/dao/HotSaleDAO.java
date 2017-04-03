package dao;

import java.util.List;

import domain.HotSale;

public interface HotSaleDAO {

	boolean insertHotSale(HotSale hotSale);
	/*boolean updateNewProduct(NewProduct newProduct);
	boolean deleteNewProduct(int id);*/
	List<HotSale> findHotSales();
}
