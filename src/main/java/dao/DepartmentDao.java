package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Department;

public class DepartmentDao {
	//=====================================================
	//==========DAC========================================
	
	
	
	
	
	//=====================================================
	//==========LAN========================================
	
	public List<Department> findAllDept() {
		List<Department> listDept = new ArrayList<Department>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * FROM department");
				var rs = ps.executeQuery();) {
			while (rs.next()) {
				Department dept = new Department();
				dept.setIddep(rs.getString("iddep"));
				dept.setNamedep(rs.getString("namedep"));
				listDept.add(dept);
			}
		} catch (Exception e) {
			listDept = null;
		}
		return listDept;
	}
	//=====================================================
	//==========XUAN========================================
	public Department getdep(String iddep) {	
		Department dep=null;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * FROM Department where iddep=?");
			)
		{
				ps.setString(1, iddep);	
				var rs = ps.executeQuery();
			while (rs.next()) {				
				dep=new Department(rs.getString(1),rs.getString(2));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dep;
	}
}
