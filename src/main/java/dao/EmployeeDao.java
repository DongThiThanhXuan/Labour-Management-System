package dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Employee;

public class EmployeeDao {

	/*==================================================================*/
	/*Code cho nay cua Dac*/
	public Employee getEmpByUsername(String username) {
		Employee emp = null;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * FROM employee where username=?");) {
			ps.setString(1, username);
			var rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	public int updatePass(String pass, int idemp) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("update employee set pass = ? where idemp = ?");) {
			ps.setString(1, pass);
			ps.setInt(2, idemp);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<Employee> selectHR() {
		List<Employee> list = new ArrayList<Employee>();
		Employee emp = null;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call selectHR}");) {
			var rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Employee> selectADO() {
		List<Employee> list = new ArrayList<Employee>();
		Employee emp = null;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call selectADO}");) {
			var rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Employee> getListEmpByShift(int shift, Date date) {
		List<Employee> list = new ArrayList<Employee>();
		Employee emp = null;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call select_emp_by_shift(?,?)}");) {
			ps.setInt(1, shift);
			ps.setDate(2,  new java.sql.Date(date.getTime()));
			var rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
				list.add(emp);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/* ================================================================== */
	/* Code cho nay cua Lan */



	public boolean updateEmpLeave(int idemp, double rqAL, double rqUL, double rqSL) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_update_emp_leave(?,?,?,?)}");) {
			ps.setInt(1, idemp);
			ps.setDouble(2, rqAL);
			ps.setDouble(3, rqUL);
			ps.setDouble(4, rqSL);
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public boolean checkExistUsername(String username) {
		boolean check = false;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select username FROM employee where username=?");) {
			ps.setString(1, username);
			var rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	public boolean checkExistEmail(String email) {
		boolean check = false;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select email FROM employee where email=?");) {
			ps.setString(1, email);
			var rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	public boolean checkExistPhoneNumber(String phone) {
		boolean check = false;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select phone FROM employee where phone=?");) {
			ps.setString(1, phone);
			var rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}
	
	//check age
	public int checkAge(Date dob) {
		int age = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call age(?)}");) {
			ps.setDate(1,new java.sql.Date(dob.getTime()));
			var rs = ps.executeQuery();
			while (rs.next()) {
				age = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return age;
	}

	public boolean insertNewEmp(Employee emp) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_insert_emp(?,?,?,?,?,?,?,?,?,?,?,?)}");) {
			ps.setString(1, emp.getFullname());
			ps.setString(2, emp.getUsername());
			ps.setString(3, emp.getPass());
			ps.setString(4, emp.getTypeid());
			ps.setDate(5, new java.sql.Date(emp.getDob().getTime()));
			ps.setString(6, emp.getAddress());
			ps.setString(7, emp.getGender());
			ps.setString(8, emp.getEmail());
			ps.setString(9, emp.getPhone());
			ps.setString(10, emp.getIddep());
			ps.setLong(11, emp.getBasicsalary());
			ps.setDate(12, new java.sql.Date(emp.getOnboarddate().getTime()));
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public Employee getNew() {
		Employee emp = null;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareStatement("select top 1 * from employee order by idemp desc");) {
			var rs = cs.executeQuery();
			if (rs.next()) {
				emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	public boolean updateDept(String iddep, int idemp) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("update employee set iddep = ? where idemp = ?");) {
			ps.setString(1, iddep);
			ps.setInt(2, idemp);
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public boolean updateType(String typeid, int idemp) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("update employee set typeid = ? where idemp = ?");) {
			ps.setString(1, typeid);
			ps.setInt(2, idemp);
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public boolean updatePassword(String pass, int idemp) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("update employee set pass = ? where idemp = ?");) {
			ps.setString(1, pass);
			ps.setInt(2, idemp);
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public boolean updateMail(String mail, int idemp) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("update employee set email = ? where idemp = ?");) {
			ps.setString(1, mail);
			ps.setInt(2, idemp);
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public boolean updatePhone(String phone, int idemp) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("update employee set phone = ? where idemp = ?");) {
			ps.setString(1, phone);
			ps.setInt(2, idemp);
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	/// update stt = 0, username & pass = null
	public boolean deleteInfo(int idemp) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_delete_info(?)}");) {
			cs.setInt(1, idemp);
			result = cs.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public boolean updateStatus(int status, int idemp) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_update_status(?,?)}");) {
			cs.setInt(1, status);
			cs.setInt(2, idemp);
			result = cs.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public boolean updateEmp(Employee emp, int idemp) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareStatement(
						"update employee set fullname = ?, basicsalary = ?, dob = ?, gender = ?, [address] = ?, "
								+ "sttemp = ?, onboarddate = ? where idemp = ?");) {
			cs.setString(1, emp.getFullname());
			cs.setLong(2, emp.getBasicsalary());
			cs.setDate(3, new java.sql.Date(emp.getDob().getTime()));
			cs.setString(4, emp.getGender());
			cs.setString(5, emp.getAddress());
			cs.setInt(6, emp.getSttemp());
			cs.setDate(7, new java.sql.Date(emp.getOnboarddate().getTime()));
			cs.setInt(8, idemp);
			result = cs.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public List<Employee> ShowNewEmp() {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select top 1 * from employee order by idemp desc");) {
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));

				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int CountAllEmp() {
		int NumEmp = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select count(idemp) from employee where username is not null");) {
			var rs = ps.executeQuery();
			while (rs.next()) {
				NumEmp = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NumEmp;
	}

	public boolean updateMonthLeave(Date date) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_updateleave_month (?)}");) {
			cs.setDate(1, (java.sql.Date) date);
			result = cs.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public boolean updateYearLeave(Date date) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_updateleave_year (?)}");) {
			cs.setDate(1, (java.sql.Date) date);
			result = cs.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	// -----------------search & sort emp-------------------------------------

	// search name
	public List<Employee> SearchEmpName(String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call Lan_search_emp_name(?)}");) {
			ps.setString(1, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search idemp
	public List<Employee> SearchIDEmp(String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call Lan_search_idemp(?)}");) {
			ps.setString(1, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search name by Dept
	public List<Employee> SearchEmpNameByDept(String iddep, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_emp_name_byDept(?,?)}");) {
			ps.setString(1, iddep);
			ps.setString(2, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search name by Dept - Gender
	public List<Employee> SearchEmpNameByDeptGen(String iddep, String gender, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_emp_name_byDept_Gen(?,?,?)}");) {
			ps.setString(1, iddep);
			ps.setString(2, gender);
			ps.setString(3, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search emp by dept
	public List<Employee> SearchEmpByDept(String iddep) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call Lan_search_by_dept(?)}");) {
			ps.setString(1, iddep);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search username
	public List<Employee> SearchEmpUsername(String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call Lan_search_emp_username(?)}");) {
			ps.setString(1, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search username by Dept
	public List<Employee> SearchEmpUsernameByDept(String iddep, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_emp_username_byDept(?,?)}");) {
			ps.setString(1, iddep);
			ps.setString(2, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search username by Dept - gender
	public List<Employee> SearchEmpUsernameByDeptGen(String iddep, String gender, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_emp_username_byDept_Gen(?,?,?)}");) {
			ps.setString(1, iddep);
			ps.setString(2, gender);
			ps.setString(3, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search dob
	public List<Employee> SearchEmpByDob(String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call Lan_search_dob(?)}");) {
			ps.setString(1, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search dob by dept
	public List<Employee> SearchEmpByDeptDob(String iddep, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_dob_by_dept(?,?)}");) {
			ps.setString(1, iddep);
			ps.setString(2, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search dob by dept - gender
	public List<Employee> SearchEmpByDeptDobGen(String iddep, String gender, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_dob_by_dept_Gen(?,?,?)}");) {
			ps.setString(1, iddep);
			ps.setString(2, gender);
			ps.setString(3, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search onboard date
	public List<Employee> SearchEmpByOnboard(String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call Lan_search_onboard(?)}");) {
			ps.setString(1, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search onboard date by dept
	public List<Employee> SearchEmpByDeptOnboard(String iddep, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_onboard_by_dept(?,?)}");) {
			ps.setString(1, iddep);
			ps.setString(2, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));

				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search onboard date by dept gender
	public List<Employee> SearchEmpByDeptOnboardGen(String iddep, String gender, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_onboard_by_dept_Gen(?,?,?)}");) {
			ps.setString(1, iddep);
			ps.setString(2, gender);
			ps.setString(3, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));

				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search phone
	public List<Employee> SearchEmpByPhone(String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call Lan_search_phone(?)}");) {
			ps.setString(1, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));

				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search phone by dept
	public List<Employee> SearchEmpByDeptPhone(String iddep, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_phone_by_dept(?,?)}");) {
			ps.setString(1, iddep);
			ps.setString(2, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));

				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search address
	public List<Employee> SearchEmpByAdd(String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call Lan_search_address(?)}");) {
			ps.setString(1, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));

				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search address by dept
	public List<Employee> SearchEmpByDeptAdd(String iddep, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_address_by_dept(?,?)}");) {
			ps.setString(1, iddep);
			ps.setString(2, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));

				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search address by dept gender
	public List<Employee> SearchEmpByDeptAddGen(String iddep, String gender, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_address_by_dept_Gen(?,?,?)}");) {
			ps.setString(1, iddep);
			ps.setString(2, gender);
			ps.setString(3, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));

				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// sort gender
	public List<Employee> SearchEmpByGender(String gender) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call Lan_sort_gender(?)}");) {
			ps.setString(1, gender);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));

				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// sort by gender and dep
	public List<Employee> SearchEmpByGenDept(String iddep, String gender) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call Lan_sort_genderbyDept(?,?)}");) {
			ps.setString(1, iddep);
			ps.setString(2, gender);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));

				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search name by gender
	public List<Employee> SearchEmpNameByGen(String gender, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_name_by_gender(?,?)}");) {
			ps.setString(1, gender);
			ps.setString(2, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));

				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search username by gender
	public List<Employee> SearchEmpUsernameByGen(String gender, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_username_by_gender(?,?)}");) {
			ps.setString(1, gender);
			ps.setString(2, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));

				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search dob by gender
	public List<Employee> SearchEmpDobByGen(String gender, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_dob_by_gender(?,?)}");) {
			ps.setString(1, gender);
			ps.setString(2, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));

				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search onboard by gender
	public List<Employee> SearchEmpOnboardByGen(String gender, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_onboard_by_gender(?,?)}");) {
			ps.setString(1, gender);
			ps.setString(2, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// search address by gender
	public List<Employee> SearchEmpAddressdByGen(String gender, String key) {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_search_address_by_gender(?,?)}");) {
			ps.setString(1, gender);
			ps.setString(2, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("pass"), rs.getString("typeid"), rs.getDate("dob"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getString("phone"), rs.getString("iddep"),
						rs.getLong("basicsalary"), rs.getDate("onboarddate"), rs.getDouble("annualleave"),
						rs.getDouble("unpaidleave"), rs.getDouble("sickleave"), rs.getInt("sttemp"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/* ================================================================== */
	/* Code cho nay cua Xuan */

	public Employee getacc(int idemp) {
		Employee emp = null;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * FROM employee where idemp=?");) {
			ps.setInt(1, idemp);
			var rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employee(rs.getInt("idemp"),rs.getString("fullname"),rs.getString("username"), rs.getString("pass"), rs.getString("typeid"),
						rs.getDate("dob"),rs.getString("address"),rs.getString("gender"),rs.getString("email"),rs.getString("phone"),rs.getString("iddep"),
						rs.getLong("basicsalary"),rs.getDate("onboarddate"),rs.getDouble("annualleave"),rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sttemp"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return emp;
	}

	public List<Employee> ShowListEmployeeFromDatabase() {
		List<Employee> list = new ArrayList<Employee>();
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call ShowlistEmployee}");) {

			var rs = cs.executeQuery();
			while (rs.next()) {
				var emp = new Employee(rs.getInt("idemp"),rs.getString("fullname"),rs.getString("username"), rs.getString("pass"), rs.getString("typeid"),
						rs.getDate("dob"),rs.getString("address"),rs.getString("gender"),rs.getString("email"),rs.getString("phone"),rs.getString("iddep"),
						rs.getLong("basicsalary"),rs.getDate("onboarddate"),rs.getDouble("annualleave"),rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sttemp"));
				list.add(emp);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Employee XuansearchonAttendancerecord(String phone) {
		Employee emp = null;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("{call Xuan_searchonAttendancerecord(?)}");) {
			cs.setString(1, phone);
			var rs = cs.executeQuery();
			while (rs.next()) {
				emp = new Employee(rs.getInt("idemp"),rs.getString("fullname"),rs.getString("username"), rs.getString("pass"), rs.getString("typeid"),
						rs.getDate("dob"),rs.getString("address"),rs.getString("gender"),rs.getString("email"),rs.getString("phone"),rs.getString("iddep"),
						rs.getLong("basicsalary"),rs.getDate("onboarddate"),rs.getDouble("annualleave"),rs.getDouble("unpaidleave"),rs.getDouble("sickleave"),rs.getInt("sttemp"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	
	public int countempopteam() {
		int i = 0;
		
		try(var conn = commom.ConnecDB.getConnect(); 
				var ps = conn.prepareCall("{call countempopteam}");) {
	     var rs =ps.executeQuery();
	     while (rs.next()) {
			i=rs.getInt(1);		
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public int selectEmpHR(int rownum) {
		int idemp=0;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("{call selectEmpHR(?)}");) {
			cs.setInt(1, rownum);
			var rs = cs.executeQuery();
			while (rs.next()) {
				idemp =rs.getInt("idemp");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return idemp;
	}
	

}
