package dao;

import java.util.List;

import domain.Sc;

public interface ScDAO {
	boolean insertSc(Sc sc);
	boolean updateSc(Sc sc);
	boolean deleteSc(int id);
	Sc findScById(int id);
	List<Sc> findScsByMcId(int mcId);
	
}
