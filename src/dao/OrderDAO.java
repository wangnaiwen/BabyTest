package dao;

import java.util.List;
import domain.Order;

public interface OrderDAO {
	boolean insertOrder(Order order);
	boolean updateOrder(Order order);
	boolean deleteOrder(int id);
	Order findOrderById(int id);
	Order findOrderByNumbering(String order_number);
	List<Order> findOrderByUserId(int userId);
	List<Order> findOrderByShopId(int shopId);
}
