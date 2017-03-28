package service.dao;

import domain.ReceAddress;

public interface FindFinalReceAddressByUserIdServiceDAO {
	ReceAddress findFinalReceAddressByUserId(int userId);
}
