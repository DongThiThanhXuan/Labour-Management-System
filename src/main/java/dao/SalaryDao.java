package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Attendancemonthlyreport;
import entities.Salary;

public class SalaryDao {

	public List<Salary> showListSalary() {
		List<Salary> list = new ArrayList<Salary>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from salary");
				var rs = ps.executeQuery();) {
			while (rs.next()) {
				var salary = new Salary(rs.getInt("idemp"), rs.getInt("month"), rs.getInt("standardday"),
						rs.getDouble("numberAl"), rs.getDouble("numberSL"), rs.getDouble("numberUL"),
						rs.getDouble("workingHL"), rs.getDouble("workingoffday"), rs.getDouble("workingday"),
						rs.getInt("totalworkfullday"), rs.getInt("totalshift3"), rs.getInt("totalshift4"),
						rs.getDouble("totalOTonday"), rs.getDouble("totalOToffday"), rs.getDouble("totalOTHL"),
						rs.getDouble("totalOToffHL"), rs.getLong("mealallowance"), rs.getLong("nightshiftallowance"),
						rs.getLong("basicsalary"), rs.getLong("OTondaysalary"), rs.getLong("OToffdaysalary"),
						rs.getLong("OTHLsalary"), rs.getLong("totalOToffHL"), rs.getLong("OTsalary"),
						rs.getLong("totalsalary"), rs.getLong("salarydeduction"), rs.getLong("insurance"),
						rs.getLong("income"), rs.getDate("payday"));
				list.add(salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Salary findSalaryById(int idemp, int month) {
		Salary salary = null;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from salary where idemp = ? and month = ?");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				salary = new Salary(rs.getInt("idemp"), rs.getInt("month"), rs.getInt("standardday"),
						rs.getDouble("numberAl"), rs.getDouble("numberSL"), rs.getDouble("numberUL"),
						rs.getDouble("workingHL"), rs.getDouble("workingoffday"), rs.getDouble("workingday"),
						rs.getInt("totalworkfullday"), rs.getInt("totalshift3"), rs.getInt("totalshift4"),
						rs.getDouble("totalOTonday"), rs.getDouble("totalOToffday"), rs.getDouble("totalOTHL"),
						rs.getDouble("totalOToffHL"), rs.getLong("mealallowance"), rs.getLong("nightshiftallowance"),
						rs.getLong("basicsalary"), rs.getLong("OTondaysalary"), rs.getLong("OToffdaysalary"),
						rs.getLong("OTHLsalary"), rs.getLong("totalOToffHL"), rs.getLong("OTsalary"),
						rs.getLong("totalsalary"), rs.getLong("salarydeduction"), rs.getLong("insurance"),
						rs.getLong("income"), rs.getDate("payday"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salary;
	}

	public List<Salary> SearchSalaryById(String key) {
		List<Salary> list = new ArrayList<Salary>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from salary where idemp = ?");) {
			ps.setString(1, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var salary = new Salary(rs.getInt("idemp"), rs.getInt("month"), rs.getInt("standardday"),
						rs.getDouble("numberAl"), rs.getDouble("numberSL"), rs.getDouble("numberUL"),
						rs.getDouble("workingHL"), rs.getDouble("workingoffday"), rs.getDouble("workingday"),
						rs.getInt("totalworkfullday"), rs.getInt("totalshift3"), rs.getInt("totalshift4"),
						rs.getDouble("totalOTonday"), rs.getDouble("totalOToffday"), rs.getDouble("totalOTHL"),
						rs.getDouble("totalOToffHL"), rs.getLong("mealallowance"), rs.getLong("nightshiftallowance"),
						rs.getLong("basicsalary"), rs.getLong("OTondaysalary"), rs.getLong("OToffdaysalary"),
						rs.getLong("OTHLsalary"), rs.getLong("totalOToffHL"), rs.getLong("OTsalary"),
						rs.getLong("totalsalary"), rs.getLong("salarydeduction"), rs.getLong("insurance"),
						rs.getLong("income"), rs.getDate("payday"));
				list.add(salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Salary> SearchSalaryByName(String key) {
		List<Salary> list = new ArrayList<Salary>();
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call Lan_salary_search_name(?)}");) {
			ps.setString(1, "%" + key + "%");
			var rs = ps.executeQuery();
			while (rs.next()) {
				var salary = new Salary(rs.getInt("idemp"), rs.getInt("month"), rs.getInt("standardday"),
						rs.getDouble("numberAl"), rs.getDouble("numberSL"), rs.getDouble("numberUL"),
						rs.getDouble("workingHL"), rs.getDouble("workingoffday"), rs.getDouble("workingday"),
						rs.getInt("totalworkfullday"), rs.getInt("totalshift3"), rs.getInt("totalshift4"),
						rs.getDouble("totalOTonday"), rs.getDouble("totalOToffday"), rs.getDouble("totalOTHL"),
						rs.getDouble("totalOToffHL"), rs.getLong("mealallowance"), rs.getLong("nightshiftallowance"),
						rs.getLong("basicsalary"), rs.getLong("OTondaysalary"), rs.getLong("OToffdaysalary"),
						rs.getLong("OTHLsalary"), rs.getLong("totalOToffHL"), rs.getLong("OTsalary"),
						rs.getLong("totalsalary"), rs.getLong("salarydeduction"), rs.getLong("insurance"),
						rs.getLong("income"), rs.getDate("payday"));
				list.add(salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Salary> SearchSalaryByMonth(String key) {
		List<Salary> list = new ArrayList<Salary>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from salary where month = ?");) {
			ps.setString(1, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var salary = new Salary(rs.getInt("idemp"), rs.getInt("month"), rs.getInt("standardday"),
						rs.getDouble("numberAl"), rs.getDouble("numberSL"), rs.getDouble("numberUL"),
						rs.getDouble("workingHL"), rs.getDouble("workingoffday"), rs.getDouble("workingday"),
						rs.getInt("totalworkfullday"), rs.getInt("totalshift3"), rs.getInt("totalshift4"),
						rs.getDouble("totalOTonday"), rs.getDouble("totalOToffday"), rs.getDouble("totalOTHL"),
						rs.getDouble("totalOToffHL"), rs.getLong("mealallowance"), rs.getLong("nightshiftallowance"),
						rs.getLong("basicsalary"), rs.getLong("OTondaysalary"), rs.getLong("OToffdaysalary"),
						rs.getLong("OTHLsalary"), rs.getLong("totalOToffHL"), rs.getLong("OTsalary"),
						rs.getLong("totalsalary"), rs.getLong("salarydeduction"), rs.getLong("insurance"),
						rs.getLong("income"), rs.getDate("payday"));
				list.add(salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Salary> SearchSalaryByMonthDesc(String key) {
		List<Salary> list = new ArrayList<Salary>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from salary where month = ? order by income desc");) {
			ps.setString(1, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var salary = new Salary(rs.getInt("idemp"), rs.getInt("month"), rs.getInt("standardday"),
						rs.getDouble("numberAl"), rs.getDouble("numberSL"), rs.getDouble("numberUL"),
						rs.getDouble("workingHL"), rs.getDouble("workingoffday"), rs.getDouble("workingday"),
						rs.getInt("totalworkfullday"), rs.getInt("totalshift3"), rs.getInt("totalshift4"),
						rs.getDouble("totalOTonday"), rs.getDouble("totalOToffday"), rs.getDouble("totalOTHL"),
						rs.getDouble("totalOToffHL"), rs.getLong("mealallowance"), rs.getLong("nightshiftallowance"),
						rs.getLong("basicsalary"), rs.getLong("OTondaysalary"), rs.getLong("OToffdaysalary"),
						rs.getLong("OTHLsalary"), rs.getLong("totalOToffHL"), rs.getLong("OTsalary"),
						rs.getLong("totalsalary"), rs.getLong("salarydeduction"), rs.getLong("insurance"),
						rs.getLong("income"), rs.getDate("payday"));
				list.add(salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Salary> SearchSalaryByMonthAsc(String key) {
		List<Salary> list = new ArrayList<Salary>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from salary where month = ? order by income asc");) {
			ps.setString(1, key);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var salary = new Salary(rs.getInt("idemp"), rs.getInt("month"), rs.getInt("standardday"),
						rs.getDouble("numberAl"), rs.getDouble("numberSL"), rs.getDouble("numberUL"),
						rs.getDouble("workingHL"), rs.getDouble("workingoffday"), rs.getDouble("workingday"),
						rs.getInt("totalworkfullday"), rs.getInt("totalshift3"), rs.getInt("totalshift4"),
						rs.getDouble("totalOTonday"), rs.getDouble("totalOToffday"), rs.getDouble("totalOTHL"),
						rs.getDouble("totalOToffHL"), rs.getLong("mealallowance"), rs.getLong("nightshiftallowance"),
						rs.getLong("basicsalary"), rs.getLong("OTondaysalary"), rs.getLong("OToffdaysalary"),
						rs.getLong("OTHLsalary"), rs.getLong("totalOToffHL"), rs.getLong("OTsalary"),
						rs.getLong("totalsalary"), rs.getLong("salarydeduction"), rs.getLong("insurance"),
						rs.getLong("income"), rs.getDate("payday"));
				list.add(salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Salary> SortSalaryByDeptMonth(int month, String iddep) {
		List<Salary> list = new ArrayList<Salary>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_salary_sort_DeptMonth(?,?)}");) {
			ps.setInt(1, month);
			ps.setString(2, iddep);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var salary = new Salary(rs.getInt("idemp"), rs.getInt("month"), rs.getInt("standardday"),
						rs.getDouble("numberAl"), rs.getDouble("numberSL"), rs.getDouble("numberUL"),
						rs.getDouble("workingHL"), rs.getDouble("workingoffday"), rs.getDouble("workingday"),
						rs.getInt("totalworkfullday"), rs.getInt("totalshift3"), rs.getInt("totalshift4"),
						rs.getDouble("totalOTonday"), rs.getDouble("totalOToffday"), rs.getDouble("totalOTHL"),
						rs.getDouble("totalOToffHL"), rs.getLong("mealallowance"), rs.getLong("nightshiftallowance"),
						rs.getLong("basicsalary"), rs.getLong("OTondaysalary"), rs.getLong("OToffdaysalary"),
						rs.getLong("OTHLsalary"), rs.getLong("totalOToffHL"), rs.getLong("OTsalary"),
						rs.getLong("totalsalary"), rs.getLong("salarydeduction"), rs.getLong("insurance"),
						rs.getLong("income"), rs.getDate("payday"));
				list.add(salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Salary> SortSalaryByDeptMonthDesc(int month, String iddep) {
		List<Salary> list = new ArrayList<Salary>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_salary_sort_DeptMonthDesc(?,?)}");) {
			ps.setInt(1, month);
			ps.setString(2, iddep);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var salary = new Salary(rs.getInt("idemp"), rs.getInt("month"), rs.getInt("standardday"),
						rs.getDouble("numberAl"), rs.getDouble("numberSL"), rs.getDouble("numberUL"),
						rs.getDouble("workingHL"), rs.getDouble("workingoffday"), rs.getDouble("workingday"),
						rs.getInt("totalworkfullday"), rs.getInt("totalshift3"), rs.getInt("totalshift4"),
						rs.getDouble("totalOTonday"), rs.getDouble("totalOToffday"), rs.getDouble("totalOTHL"),
						rs.getDouble("totalOToffHL"), rs.getLong("mealallowance"), rs.getLong("nightshiftallowance"),
						rs.getLong("basicsalary"), rs.getLong("OTondaysalary"), rs.getLong("OToffdaysalary"),
						rs.getLong("OTHLsalary"), rs.getLong("totalOToffHL"), rs.getLong("OTsalary"),
						rs.getLong("totalsalary"), rs.getLong("salarydeduction"), rs.getLong("insurance"),
						rs.getLong("income"), rs.getDate("payday"));
				list.add(salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Salary> SortSalaryByDeptMonthAsc(int month, String iddep) {
		List<Salary> list = new ArrayList<Salary>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Lan_salary_sort_DeptMonthAsc(?,?)}");) {
			ps.setInt(1, month);
			ps.setString(2, iddep);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var salary = new Salary(rs.getInt("idemp"), rs.getInt("month"), rs.getInt("standardday"),
						rs.getDouble("numberAl"), rs.getDouble("numberSL"), rs.getDouble("numberUL"),
						rs.getDouble("workingHL"), rs.getDouble("workingoffday"), rs.getDouble("workingday"),
						rs.getInt("totalworkfullday"), rs.getInt("totalshift3"), rs.getInt("totalshift4"),
						rs.getDouble("totalOTonday"), rs.getDouble("totalOToffday"), rs.getDouble("totalOTHL"),
						rs.getDouble("totalOToffHL"), rs.getLong("mealallowance"), rs.getLong("nightshiftallowance"),
						rs.getLong("basicsalary"), rs.getLong("OTondaysalary"), rs.getLong("OToffdaysalary"),
						rs.getLong("OTHLsalary"), rs.getLong("totalOToffHL"), rs.getLong("OTsalary"),
						rs.getLong("totalsalary"), rs.getLong("salarydeduction"), rs.getLong("insurance"),
						rs.getLong("income"), rs.getDate("payday"));
				list.add(salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Salary> SearchSalaryByIdMonth(int idemp, int month) {
		List<Salary> list = new ArrayList<Salary>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from salary where idemp = ? and month = ?");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var salary = new Salary(rs.getInt("idemp"), rs.getInt("month"), rs.getInt("standardday"),
						rs.getDouble("numberAl"), rs.getDouble("numberSL"), rs.getDouble("numberUL"),
						rs.getDouble("workingHL"), rs.getDouble("workingoffday"), rs.getDouble("workingday"),
						rs.getInt("totalworkfullday"), rs.getInt("totalshift3"), rs.getInt("totalshift4"),
						rs.getDouble("totalOTonday"), rs.getDouble("totalOToffday"), rs.getDouble("totalOTHL"),
						rs.getDouble("totalOToffHL"), rs.getLong("mealallowance"), rs.getLong("nightshiftallowance"),
						rs.getLong("basicsalary"), rs.getLong("OTondaysalary"), rs.getLong("OToffdaysalary"),
						rs.getLong("OTHLsalary"), rs.getLong("totalOToffHL"), rs.getLong("OTsalary"),
						rs.getLong("totalsalary"), rs.getLong("salarydeduction"), rs.getLong("insurance"),
						rs.getLong("income"), rs.getDate("payday"));
				list.add(salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int maxIdemp() {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call  Lan_select_maxid}");) {
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	// check exist month in payroll
	public boolean checkExistMonth(int month) {
		boolean check = false;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select month from salary where month = ?");) {
			ps.setInt(1, month);
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

	// check latest month in attmonthly report
	public int checkLatestMonth() {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call Lan_select_maxMonth}");) {
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	// check latest month in salary
	public int checkLatestMonthSal() {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); 
				var ps = conn.prepareStatement("select max([month]) as maxM from salary");) {
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public boolean updatePayday(Salary salary, int month) {
		boolean result = true;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("update salary set payday = ? where month = ?");) {
			ps.setDate(1, new java.sql.Date(salary.getPayday().getTime()));
			ps.setInt(2, month);
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public int EditPayroll(int month) {
		var i = 0;
		var maxid = maxIdemp();
		var idemp = 1;
		while (idemp <= maxid) {
			double numberAL = numberAL(idemp, month);
			double numberUL = numberUL(idemp, month);
			double numberSL = numberSL(idemp, month);
			double workingHL = workingHL(idemp, month);
			double workingoffday = workingOffday(idemp, month);
			double workingday = 22 - numberAL - numberSL - numberUL - workingHL - workingoffday;
			double totalFullday = totalFullday(idemp, month);
			double totalshift3 = totalShift3(idemp, month);
			double totalshift4 = totalShift4(idemp, month);
			double totalOTonday = totalOTonday(idemp, month);
			double totalOToffday = totalOToffday(idemp, month);
			double totalOTHL = totalOTHL(idemp, month);
			double totaloffOTHL = totalOToffHL(idemp, month);
			long basicsalary = basicsalary(idemp);
			long deduction = deduction(idemp, month);
			long insurance = insurance(idemp);
			long meal = meal(idemp, month);
			long night = nightshift(idemp, month);
			long OTondaySal = OTondaySal(idemp, month);
			long OToffdaySal = OToffdaySal(idemp, month);
			long OTHLSal = OTHLSalary(idemp, month);
			long OTHLoffSal = OToffHLSalary(idemp, month);
			long totalOTSal = OTondaySal + OToffdaySal + OTHLSal + OTHLoffSal;
			long totalSalary = (long) ((basicsalary / 22)
					* ((22 - numberUL - numberSL) + workingHL * 3 + workingoffday * 2) + night + meal + totalOTSal);
			long income = totalSalary - insurance - deduction;
			try (var conn = commom.ConnecDB.getConnect();
					var ps = conn.prepareCall(
							"{call edit_salary(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");) {
				ps.setInt(1, 22);
				ps.setDouble(2, numberAL);
				ps.setDouble(3, numberUL);
				ps.setDouble(4, numberSL);
				ps.setDouble(5, workingHL);
				ps.setDouble(6, workingoffday);
				ps.setDouble(7, workingday);
				ps.setDouble(8, totalFullday);
				ps.setDouble(9, totalshift3);
				ps.setDouble(10, totalshift4);
				ps.setDouble(11, totalOTonday);
				ps.setDouble(12, totalOToffday);
				ps.setDouble(13, totalOTHL);
				ps.setDouble(14, totaloffOTHL);
				ps.setLong(15, OTondaySal);
				ps.setLong(16, OToffdaySal);
				ps.setLong(17, OTHLSal);
				ps.setLong(18, OTHLoffSal);
				ps.setLong(19, meal);
				ps.setLong(20, night);
				ps.setLong(21, basicsalary);
				ps.setLong(22, totalOTSal);
				ps.setLong(23, totalSalary);
				ps.setLong(24, deduction);
				ps.setLong(25, insurance);
				ps.setLong(26, income);
				ps.setInt(27, idemp);
				ps.setInt(28, month);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			idemp += 1;
		}
		return i;
	}

	// =================salary summary month================
	public int CountAllEmp(int month) {
		int NumEmp = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_countAllEmp_rp(?)}");) {
			cs.setInt(1, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				NumEmp = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NumEmp;
	}

	public int CountEmpByDept(String iddep, int month) {
		int NumEmp = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_countEmpbyDept_rp(?,?)}");) {
			cs.setString(1, iddep);
			cs.setInt(2, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				NumEmp = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NumEmp;
	}

	public long totalMeal(int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_sumMeal_rp(?)}");) {
			cs.setInt(1, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalMealDept(String iddep, int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_sumMealDept_rp(?,?)}");) {
			cs.setString(1, iddep);
			cs.setInt(2, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalNight(int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_sumNight_rp(?)}");) {
			cs.setInt(1, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalNightDept(String iddep, int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_sumNightDept_rp(?,?)}");) {
			cs.setString(1, iddep);
			cs.setInt(2, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalOTSal(int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_sumOTSal_rp(?)}");) {
			cs.setInt(1, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalOTSalDept(String iddep, int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_sumOTSalDept_rp(?,?)}");) {
			cs.setString(1, iddep);
			cs.setInt(2, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalSal(int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_sumTotalSal_rp(?)}");) {
			cs.setInt(1, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalSalDept(String iddep, int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("{call Lan_sumTotalSalDept_rp(?,?)}");) {
			cs.setString(1, iddep);
			cs.setInt(2, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalSalDeduc(int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_sumSalDeduc_rp(?)}");) {
			cs.setInt(1, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalSalDeducDept(String iddep, int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("{call Lan_sumSalDeducDept_rp(?,?)}");) {
			cs.setString(1, iddep);
			cs.setInt(2, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalInsur(int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_sumInsurance_rp(?)}");) {
			cs.setInt(1, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalInsurDept(String iddep, int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("{call Lan_sumInsuranceDept_rp(?,?)}");) {
			cs.setString(1, iddep);
			cs.setInt(2, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalNetpay(int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_sumNetpay_rp(?)}");) {
			cs.setInt(1, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalNetpayDept(String iddep, int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_sumNetpayDept_rp(?,?)}");) {
			cs.setString(1, iddep);
			cs.setInt(2, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long AvgNetpay(int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_AvgNetpay_rp(?)}");) {
			cs.setInt(1, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long AvgNetpayDept(String iddep, int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_AvgNetpayDept_rp(?,?)}");) {
			cs.setString(1, iddep);
			cs.setInt(2, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long MaxNetpay(int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_MaxNetpay_rp(?)}");) {
			cs.setInt(1, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long MaxNetpayDept(String iddep, int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_MaxNetpayDept_rp(?,?)}");) {
			cs.setString(1, iddep);
			cs.setInt(2, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long MinNetpay(int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_MinNetpay_rp(?)}");) {
			cs.setInt(1, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long MinNetpayDept(String iddep, int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Lan_MinNetpayDept_rp(?,?)}");) {
			cs.setString(1, iddep);
			cs.setInt(2, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	// ===============salary summary employee================
	public int CountMonth(int idemp) {
		int NumEmp = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareStatement("select count(month) from salary where idemp = ?");) {
			cs.setInt(1, idemp);
			var rs = cs.executeQuery();
			while (rs.next()) {
				NumEmp = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NumEmp;
	}

	public long totalMealEmp(int idemp) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("select sum(mealallowance) from salary where idemp = ?");) {
			cs.setInt(1, idemp);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalNightEmp(int idemp) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("select sum(nightshiftallowance) from salary where idemp = ?");) {
			cs.setInt(1, idemp);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalOTSalEmp(int idemp) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("select sum(OTsalary) from salary where idemp = ?");) {
			cs.setInt(1, idemp);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalSalEmp(int idemp) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("select sum(totalsalary) from salary where idemp = ?");) {
			cs.setInt(1, idemp);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalSalDeducEmp(int idemp) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("select sum(salarydeduction) from salary where idemp = ?");) {
			cs.setInt(1, idemp);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalInsurEmp(int idemp) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("select sum(insurance) from salary where idemp = ?");) {
			cs.setInt(1, idemp);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long totalNetpayEmp(int idemp) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("select sum(income) from salary where idemp = ?");) {
			cs.setInt(1, idemp);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long AvgNetpayEmp(int idemp) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("select sum(income)/count(month) from salary where idemp = ?");) {
			cs.setInt(1, idemp);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long MaxNetpayEmp(int idemp) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("select MAX(income) from salary where idemp = ?");) {
			cs.setInt(1, idemp);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	public long MinNetpayEmp(int month) {
		long total = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("select MIN(income) from salary where idemp = ?");) {
			cs.setInt(1, month);
			var rs = cs.executeQuery();
			while (rs.next()) {
				total = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	// ===============insert salary=================
	public int insertPayroll(int month) {
		var i = 0;
		var maxid = maxIdemp();
		var idemp = 1;
		while (idemp <= maxid) {
			double numberAL = numberAL(idemp, month);
			double numberUL = numberUL(idemp, month);
			double numberSL = numberSL(idemp, month);
			double workingHL = workingHL(idemp, month);
			double workingoffday = workingOffday(idemp, month);
			double workingday = 22 - numberAL - numberSL - numberUL - workingHL - workingoffday;
			double totalFullday = totalFullday(idemp, month);
			double totalshift3 = totalShift3(idemp, month);
			double totalshift4 = totalShift4(idemp, month);
			double totalOTonday = totalOTonday(idemp, month);
			double totalOToffday = totalOToffday(idemp, month);
			double totalOTHL = totalOTHL(idemp, month);
			double totaloffOTHL = totalOToffHL(idemp, month);
			long basicsalary = basicsalary(idemp);
			long deduction = deduction(idemp, month);
			long insurance = insurance(idemp);
			long meal = meal(idemp, month);
			long night = nightshift(idemp, month);
			long OTondaySal = OTondaySal(idemp, month);
			long OToffdaySal = OToffdaySal(idemp, month);
			long OTHLSal = OTHLSalary(idemp, month);
			long OTHLoffSal = OToffHLSalary(idemp, month);
			long totalOTSal = OTondaySal + OToffdaySal + OTHLSal + OTHLoffSal;
			long totalSalary = (long) ((basicsalary / 22)
					* ((22 - numberUL - numberSL) + workingHL * 3 + workingoffday * 2) + night + meal + totalOTSal);
			long income = totalSalary - insurance - deduction;
			try (var conn = commom.ConnecDB.getConnect();
					var ps = conn.prepareCall(
							"{call insert_salary(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");) {
				ps.setInt(1, idemp);
				ps.setInt(2, month);
				ps.setInt(3, 22);
				ps.setDouble(4, numberAL);
				ps.setDouble(5, numberUL);
				ps.setDouble(6, numberSL);
				ps.setDouble(7, workingHL);
				ps.setDouble(8, workingoffday);
				ps.setDouble(9, workingday);
				ps.setDouble(10, totalFullday);
				ps.setDouble(11, totalshift3);
				ps.setDouble(12, totalshift4);
				ps.setDouble(13, totalOTonday);
				ps.setDouble(14, totalOToffday);
				ps.setDouble(15, totalOTHL);
				ps.setDouble(16, totaloffOTHL);
				ps.setLong(17, OTondaySal);
				ps.setLong(18, OToffdaySal);
				ps.setLong(19, OTHLSal);
				ps.setLong(20, OTHLoffSal);
				ps.setLong(21, meal);
				ps.setLong(22, night);
				ps.setLong(23, basicsalary);
				ps.setLong(24, totalOTSal);
				ps.setLong(25, totalSalary);
				ps.setLong(26, deduction);
				ps.setLong(27, insurance);
				ps.setLong(28, income);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			idemp += 1;
		}
		return i;
	}

	// ==============insert tung phan==================
	public double numberAL(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call numberAL(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public double numberUL(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call numberUL(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public double numberSL(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call numberSL(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private double workingHL(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sal_workingHL(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private double workingOffday(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sal_workingOffday(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private double totalFullday(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sal_totalFullday(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private double totalShift3(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sal_totalShift3(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private double totalShift4(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sal_totalShift4(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private double totalOTonday(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sal_totalOTonday(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private double totalOToffday(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sal_totalOToffday(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private double totalOTHL(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sal_totalOTHL(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private double totalOToffHL(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sal_totalOToffHL(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private long basicsalary(int idemp) {
		long i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sal_basicsalary(?)}");) {
			ps.setInt(1, idemp);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private long deduction(int idemp, int month) {
		long i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sal_deduction(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private long insurance(int idemp) {
		long i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sal_insurance(?)}");) {
			ps.setInt(1, idemp);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private long meal(int idemp, int month) {
		long i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sal_meal(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private long nightshift(int idemp, int month) {
		long i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sal_nightshift(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private long OTondaySal(int idemp, int month) {
		long i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call OTondaySalary(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private long OToffdaySal(int idemp, int month) {
		long i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call OToffdaySalary(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private long OTHLSalary(int idemp, int month) {
		long i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call OTHLSalary(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private long OToffHLSalary(int idemp, int month) {
		long i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call OToffHLSalary(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
