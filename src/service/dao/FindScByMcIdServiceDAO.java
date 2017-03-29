package service.dao;

import java.util.List;

import domain.Sc;

public interface FindScByMcIdServiceDAO {
	List<Sc> findScsByMcId(int mcId);
}
