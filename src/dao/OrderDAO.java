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
	List<Order> findOrderByShopId(int shopId, int number);
	List<Order> findOrderByInvitee(int invitee, int number);
	
	List<Order> findbeSentOrders(int page);
	List<Order> findFinishOrders(int page);
	
	//发货订单
	boolean updateOrderType(int id, int type);
	//已取消的订单
	List<Order> findQuitOrders(int userId);
}
