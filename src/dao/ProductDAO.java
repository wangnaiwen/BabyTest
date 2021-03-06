package dao;

import java.util.List;

import domain.Product;

public interface ProductDAO {
	boolean insertProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(int id);
	Product findProductById(int id);
	Product findProductByNumbering(String numbering);
	List<Product> findProductByScId(int scId, int number);
	List<Product> findProductByKey(String key);
	int findProductCountById(int id);
	boolean updateProductCountById(int id, int count);
}
