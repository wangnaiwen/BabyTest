package dao;

import java.util.List;

import domain.NewProduct;

public interface NewProductDAO {
	boolean insertNewProduct(NewProduct newPrduct);
	/*boolean updateNewProduct(NewProduct newProduct);
	boolean deleteNewProduct(int id);*/
	List<NewProduct> findNewProducts();
}
