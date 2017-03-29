package service.dao;

import domain.Product;

public interface FindProductByNumberingServiceDAO {
	Product findProductByNumbering(String numbering);
}
