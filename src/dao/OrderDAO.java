package dao;

import java.util.List;
import domain.Order;

public interface OrderDAO {
	boolean insertOrder(Order order);
	boolean updateOrder(Order order);
	boolean deleteOrder(int id);
	Order findOrderById(int id);
	List<Order> findOrderByUserId(int userId);
	List<Order> findOrderByShopId(int shopId);
}
