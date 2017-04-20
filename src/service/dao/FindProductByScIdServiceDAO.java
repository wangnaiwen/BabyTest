package service.dao;

import java.util.List;

import domain.Product;

public interface FindProductByScIdServiceDAO {
	List<Product> findProductByScId(int scId, int number);
}
