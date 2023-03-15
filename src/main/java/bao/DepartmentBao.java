package bao;

import java.util.List;

import dao.DepartmentDao;
import entities.Department;

public class DepartmentBao {
	private DepartmentDao depd = new DepartmentDao();

	// ========lan===============
	public List<Department> getAllList() {
		return depd.findAllDept();
	}

	// ========xuan===============
// ham nay lay ra 1 dep voi iddep truyen vao
	public Department getdep(String iddep) {
		return depd.getdep(iddep);
	}

}
