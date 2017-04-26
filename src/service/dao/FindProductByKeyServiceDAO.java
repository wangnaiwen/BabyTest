package service.dao;

import java.util.List;

import domain.Product;

public interface FindProductByKeyServiceDAO {
	List<Product> findProductByKey(String key);
}
