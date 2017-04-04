package dao;

import java.util.List;

import domain.Pr;

public interface PrDAO {
	boolean insertPr(Pr pr);
	//boolean updatePr(Pr pr);
	boolean deletePr(int id);
	Pr findPrById(int id);
	List<Pr> findPrsByUserId(int userId, int number);
	List<Pr> findPrsByDealId(int dealId);
	List<Pr> findPrsByProductId(int productId, int number); //这里number表示第几次分页查询
}
