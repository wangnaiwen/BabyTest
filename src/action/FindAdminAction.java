package action;

import java.util.HashMap;
import java.util.Map;

import service.dao.FindAdminServiceDAO;
import util.JavaWebToken;
import util.Md5Encode;

import com.opensymphony.xwork2.ActionSupport;

import domain.Admin;
import dto.DTO;

public class FindAdminAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private FindAdminServiceDAO findAdminServiceDAO;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FindAdminServiceDAO getFindAdminServiceDAO() {
		return findAdminServiceDAO;
	}

	public void setFindAdminServiceDAO(FindAdminServiceDAO findAdminServiceDAO) {
		this.findAdminServiceDAO = findAdminServiceDAO;
	}

	@Override
	public String execute() throws Exception {
		Admin admin = new Admin();
		admin.setName(name);
		admin.setPassword(Md5Encode.getEd5EncodePassword(password));
		
		DTO dto = new DTO();
		if (findAdminServiceDAO.findAdmin(admin)) {
          //把用户登录信息放进Session
            Map<String, Object> loginInfo = new HashMap<>();
            loginInfo.put("name", admin.getName());
            String sessionId = JavaWebToken.createJavaWebToken(loginInfo);
            System.out.println("sessionID"+sessionId);
            dto.data = sessionId;
			return SUCCESS;
		}else{
			dto.code = "-1";
            dto.msg = "Have not registered";
			return ERROR;
		}
	}	
}
