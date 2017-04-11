package service.dao;

import domain.Order;

public interface FindOrderByOrderNumberServiceDAO {
	Order findOrderByNumbering(String order_number);

}
