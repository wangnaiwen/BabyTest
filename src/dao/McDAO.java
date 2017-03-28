package dao;

import java.util.List;

import domain.Mc;

public interface McDAO {
	boolean insertMc(Mc mc);
	boolean updateMc(Mc mc);
	boolean deleteMc(int id);
	Mc findMcById(int id);
	List<Mc> findMcs();
}
