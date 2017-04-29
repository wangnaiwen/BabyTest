package service.dao;

import dao.AdminDAO;

public class BaseAdminServiceDAO {
	private AdminDAO adminDAO;

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}
	
}
