package bao;


import java.util.Date;
import java.util.List;

import dao.EmployeeDao;
import entities.Employee;

public class EmployeeBao {
	private EmployeeDao emd = new EmployeeDao();
	//==========Dac=========
    //emp theo username
	public Employee getEmployeeByUser(String username) {
		return emd.getEmpByUsername(username);
	}

	public int updatePassById(String pass, int idemp) {
		return emd.updatePass(pass, idemp);
	}

	public List<Employee> getHR() {
		return emd.selectHR();
	}

	public List<Employee> getADO() {
		return emd.selectADO();
	}

	public List<Employee> getEmpByShift(int shift,Date date) {
		return emd.getListEmpByShift(shift, date);
	}

	
	//===========LAN================
	
		public int AllEmp() {
			return emd.CountAllEmp();
		}

		// update emp leave
		public boolean updateLeave(int idemp, double rqAL, double rqUL, double rqSL) {
			return emd.updateEmpLeave(idemp, rqAL, rqUL, rqSL);
		}

		// check exist username
		public boolean checkUsername(String username) {
			return emd.checkExistUsername(username);
		}

		// check exist e-mail
		public boolean checkEmail(String email) {
			return emd.checkExistEmail(email);
		}

		// check exist phone-number
		public boolean checkPhone(String phone) {
			return emd.checkExistPhoneNumber(phone);
		}

		public int checkAge(Date dob) {
			return emd.checkAge(dob);
		}
		
		// insert new emp
		public boolean addNewEmp(Employee employee) {
			return emd.insertNewEmp(employee);
		}

		// get new
		public Employee NewEmp() {
			return emd.getNew();
		}

		// show top 1 new emp
		public List<Employee> ShowNew() {
			return emd.ShowNewEmp();
		}

		// update dept
		public boolean updateDepart(String iddep, int idemp) {
			return emd.updateDept(iddep, idemp);
		}

		// update type
		public boolean updateType(String typeid, int idemp) {
			return emd.updateType(typeid, idemp);
		}

		// update pass
		public boolean updatePass(String pass, int idemp) {
			return emd.updatePassword(pass, idemp);
		}

		// update info
		public boolean updateInfo(Employee emp, int idemp) {
			return emd.updateEmp(emp, idemp);
		}

		// update mail
		public boolean updateMail(String mail, int idemp) {
			return emd.updateMail(mail, idemp);
		}

		// update phone
		public boolean updatePhone(String phone, int idemp) {
			return emd.updatePhone(phone, idemp);
		}

		// delete info
		public boolean deleteEmpolyee(int idemp) {
			return emd.deleteInfo(idemp);
		}

		// update status
		public boolean updateStatus(int status, int idemp) {
			return emd.updateStatus(status, idemp);
		}

		// update leave month
		public boolean updateLeaveMonth(Date date) {
			return emd.updateMonthLeave((java.sql.Date) date);
		}

		// update leave year
		public boolean updateLeaveYear(Date date) {
			return emd.updateYearLeave((java.sql.Date) date);
		}

		// search emp by dept
		public List<Employee> showSearchEmpDept(String iddep) {
			return emd.SearchEmpByDept(iddep);
		}

		// search emp name
		public List<Employee> showSearchEmpName(String key) {
			return emd.SearchEmpName(key);
		}

		// search emp name
		public List<Employee> showSearchEmpId(String key) {
			return emd.SearchIDEmp(key);
		}

		// search emp name by dept
		public List<Employee> showSearchEmpNamebyDept(String iddep, String key) {
			return emd.SearchEmpNameByDept(iddep, key);
		}

		// search emp by dept & gender
		public List<Employee> showSearchEmpNamebyDeptGen(String iddep, String gender, String key) {
			return emd.SearchEmpNameByDeptGen(iddep, gender, key);
		}

		// search emp username
		public List<Employee> showSearchEmpUsername(String key) {
			return emd.SearchEmpUsername(key);
		}

		// search emp username by dept
		public List<Employee> showSearchEmpUseramebyDept(String iddep, String key) {
			return emd.SearchEmpUsernameByDept(iddep, key);
		}

		// search emp username by dept
		public List<Employee> showSearchEmpUseramebyDeptGen(String iddep, String gender, String key) {
			return emd.SearchEmpUsernameByDeptGen(iddep, gender, key);
		}

		// search emp by dob
		public List<Employee> showEmpByDob(String key) {
			return emd.SearchEmpByDob(key);
		}

		// sort emp by dept - dob
		public List<Employee> showEmpByDeptDob(String iddep, String key) {
			return emd.SearchEmpByDeptDob(iddep, key);
		}

		// sort emp by dept - dob - gender
		public List<Employee> showEmpByDeptDobGen(String iddep, String gender, String key) {
			return emd.SearchEmpByDeptDobGen(iddep, gender, key);
		}

		// search emp by onboard
		public List<Employee> showEmpByOnboard(String key) {
			return emd.SearchEmpByOnboard(key);
		}

		// sort emp by dept - onboard
		public List<Employee> showEmpByDeptOnboard(String iddep, String key) {
			return emd.SearchEmpByDeptOnboard(iddep, key);
		}

		// sort emp by dept - onboard - gender
		public List<Employee> showEmpByDeptOnboardGen(String iddep, String gender, String key) {
			return emd.SearchEmpByDeptOnboardGen(iddep, gender, key);
		}

		// search emp by phone
		public List<Employee> showEmpPhone(String key) {
			return emd.SearchEmpByPhone(key);
		}

		// sort by dept - phone
		public List<Employee> showEmpByDeptPhone(String iddep, String key) {
			return emd.SearchEmpByDeptPhone(iddep, key);
		}

		// search emp by address
		public List<Employee> showEmpAdd(String key) {
			return emd.SearchEmpByAdd(key);
		}

		// sort by dept - phone
		public List<Employee> showEmpByDeptAdd(String iddep, String key) {
			return emd.SearchEmpByDeptAdd(iddep, key);
		}

		// sort by dept - phone - gender
		public List<Employee> showEmpByDeptAddGen(String iddep, String gender, String key) {
			return emd.SearchEmpByDeptAddGen(iddep, gender, key);
		}

		// search emp by gender
		public List<Employee> showEmpGender(String gender) {
			return emd.SearchEmpByGender(gender);
		}

		// sort by gender and dept
		public List<Employee> showEmpByDepGender(String iddep, String gender) {
			return emd.SearchEmpByGenDept(iddep, gender);
		}

		// search emp name by gender
		public List<Employee> showEmpNameGender(String gender, String key) {
			return emd.SearchEmpNameByGen(gender, key);
		}

		// search emp username by gender
		public List<Employee> showEmpUsernameGender(String gender, String key) {
			return emd.SearchEmpUsernameByGen(gender, key);
		}

		// search emp dob by gender
		public List<Employee> showEmpDobGender(String gender, String key) {
			return emd.SearchEmpDobByGen(gender, key);
		}

		// search emp onboard by gender
		public List<Employee> showEmpOnboardGender(String gender, String key) {
			return emd.SearchEmpOnboardByGen(gender, key);
		}

		// search emp address by gender
		public List<Employee> showEmpAddressGender(String gender, String key) {
			return emd.SearchEmpAddressdByGen(gender, key);
		}
	// ===========Xuan================
	
	//lay ra employee theo id truyen vao
	public Employee getacc(int idemp) {
		return emd.getacc(idemp);
	}

	//lay ra danh sach tat ca employee
	public List<Employee> ShowListEmployeeFromDatabase() {
		return emd.ShowListEmployeeFromDatabase();
	}
	
	//search o Attendancerecord
	public Employee XuansearchonAttendancerecord(String key) {
		return emd.XuansearchonAttendancerecord(key);
	}
	//dem so nhan vien thuoc 1 tem
	public int countempopteam() {
		return emd.countempopteam();
	}
	public int selectEmpHR(int rownum) {
		return emd.selectEmpHR(rownum);
	}
}
