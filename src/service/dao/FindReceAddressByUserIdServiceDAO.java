package service.dao;

import java.util.List;

import domain.ReceAddress;

public interface FindReceAddressByUserIdServiceDAO {
	List<ReceAddress> findReceAddressByUserId(int userId);
}
