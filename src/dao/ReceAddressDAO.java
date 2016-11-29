package dao;

import java.util.List;

import domain.ReceAddress;

public interface ReceAddressDAO{
	boolean insertReceAddress(ReceAddress address);
	boolean updateReceAddress(ReceAddress address);
	boolean deleteReceAddress(ReceAddress address);
	ReceAddress findReceAddressById(int id);
	List<ReceAddress> findReceAddressByUserId(int userId);
}
