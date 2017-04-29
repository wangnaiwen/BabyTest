package service;

import dao.AdminDAO;
import domain.Admin;
import service.dao.BaseAdminServiceDAO;
import service.dao.FindAdminServiceDAO;

public class FindAdminService extends BaseAdminServiceDAO implements FindAdminServiceDAO{

	@Override
	public boolean findAdmin(Admin admin) {
		AdminDAO adminDAO = getAdminDAO();
		return adminDAO.findAdmin(admin);
	}

}
