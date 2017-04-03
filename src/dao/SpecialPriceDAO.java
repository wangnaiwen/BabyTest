package dao;

import java.util.List;

import domain.SpecialPrice;

public interface SpecialPriceDAO {
	boolean insertSpecialPrice(SpecialPrice specialPrice);
	/*boolean updateNewProduct(NewProduct newProduct);
	boolean deleteNewProduct(int id);*/
	List<SpecialPrice> findSpecialPrices();
}
