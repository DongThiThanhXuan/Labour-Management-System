package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Attendancemonthlyreport;

public class AttendancemonthlyreportDao {

	public List<Attendancemonthlyreport> ShowAllAttendReport(int month) {
		List<Attendancemonthlyreport> listAttend = new ArrayList<Attendancemonthlyreport>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from Attendancemonthlyreport where [month]=?");) {
			ps.setInt(1, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var attend = new Attendancemonthlyreport(rs.getInt("idemp"), rs.getInt("month"),
						rs.getDouble("totaltimekeeping"), rs.getDouble("totalworkHL"), rs.getDouble("totalworkoffday"),
						rs.getDouble("totalshift3"), rs.getDouble("totalshift4"), rs.getDouble("totalworkfullday"),
						rs.getDouble("totalOTonday"), rs.getDouble("totalOToffday"), rs.getDouble("totalOTHL"),
						rs.getDouble("totalOToffHL"), rs.getInt("validreason1"), rs.getInt("validreason2"),
						rs.getLong("totalsalarydeduction"));
				listAttend.add(attend);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listAttend;
	}

	// ----------------------XUAN-------------------------
	private int idcaonhat() {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call selectmaxid}");) {
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	// insert thang ko co nghi le, ko co ngay nghi bu
	public int inserttotableNoHL(int month) {
		var i = 0;
		var maxid = idcaonhat();
		var idemp = 1;
		while (idemp <= maxid) {
			double totaltimekeeping = gettotaltimekeeping(idemp, month);
			double totalworkHL = 0;
			double totalworkoffday = 0;
			double totalshift3 = totalshift3(idemp, month);
			double totalshift4 = totalshift4(idemp, month);
			int totalworkfullday = totalworkfullday(idemp, month);
			double totalOTonday = totalOTondayNoHL(idemp, month);
			double totalOToffday = totalOT_offdaymonth_noHL(idemp, month);
			double totalOTHL = 0;
			double totalOToffHL = 0;
			int validreason1 = validreason(idemp, 1, month);
			int validreason2 = validreason(idemp, 2, month);
			try (var conn = commom.ConnecDB.getConnect();
					var ps = conn.prepareCall("{call insertatdreport(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");) {
				ps.setInt(1, idemp);
				ps.setInt(2, month);
				ps.setDouble(3, totaltimekeeping);
				ps.setDouble(4, totalworkHL);
				ps.setDouble(5, totalworkoffday);
				ps.setDouble(6, totalshift3);
				ps.setDouble(7, totalshift4);
				ps.setInt(8, totalworkfullday);
				ps.setDouble(9, totalOTonday);
				ps.setDouble(10, totalOToffday);
				ps.setDouble(11, totalOTHL);
				ps.setDouble(12, totalOToffHL);
				ps.setInt(13, validreason1);
				ps.setInt(14, validreason2);
				i = ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}

			idemp += 1;
		}
		return i;

	}

	// insert thang vua co nghi le, vua co nghi bu
	public int inserttotableHL(int month, Date fromdateHl, Date todatehl, Date fromdateoffHL, Date todateoffHL) {
		var i = 0;
		var maxid = idcaonhat();
		var idemp = 1;
		while (idemp <= maxid) {
			double totaltimekeeping = gettotaltimekeeping(idemp, month);
			double totalworkHL = gettotalworkHL(idemp, fromdateHl, todatehl);
			double totalworkoffday = totalworkoffday(idemp, fromdateoffHL, todateoffHL);
			double totalshift3 = totalshift3(idemp, month);
			double totalshift4 = totalshift4(idemp, month);
			int totalworkfullday = totalworkfullday(idemp, month);
			double totalOTonday = totalOTOndaymonth_HLandOffHL(idemp, fromdateHl, todatehl, fromdateoffHL, todateoffHL);
			double totalOToffday = totalOToffdaymonthHLandOffHL(idemp, fromdateHl, todatehl, fromdateoffHL,
					todateoffHL);
			double totalOTHL = totalOTHL(idemp, fromdateHl, todatehl);
			double totalOToffHL = totalOTHL(idemp, fromdateoffHL, todateoffHL);
			int validreason1 = validreason(idemp, 1, month);
			int validreason2 = validreason(idemp, 2, month);
			try (var conn = commom.ConnecDB.getConnect();
					var ps = conn.prepareCall("{call insertatdreport(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");) {
				ps.setInt(1, idemp);
				ps.setInt(2, month);
				ps.setDouble(3, totaltimekeeping);
				ps.setDouble(4, totalworkHL);
				ps.setDouble(5, totalworkoffday);
				ps.setDouble(6, totalshift3);
				ps.setDouble(7, totalshift4);
				ps.setInt(8, totalworkfullday);
				ps.setDouble(9, totalOTonday);
				ps.setDouble(10, totalOToffday);
				ps.setDouble(11, totalOTHL);
				ps.setDouble(12, totalOToffHL);
				ps.setInt(13, validreason1);
				ps.setInt(14, validreason2);
				i = ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}

			idemp += 1;
		}
		return i;

	}

	// insert thang co nghi le
	public int inserttotableOnlyHL(int month, Date fromdateHl, Date todatehl) {
		var i = 0;
		var maxid = idcaonhat();
		var idemp = 1;
		while (idemp <= maxid) {
			double totaltimekeeping = gettotaltimekeeping(idemp, month);
			double totalworkHL = gettotalworkHL(idemp, fromdateHl, todatehl);
			double totalworkoffday = 0;
			double totalshift3 = totalshift3(idemp, month);
			double totalshift4 = totalshift4(idemp, month);
			int totalworkfullday = totalworkfullday(idemp, month);
			double totalOTonday = totalOTOnDaymaybeHL(idemp, fromdateHl, todatehl);
			double totalOToffday = totalOTOffDaymaybeHL(idemp, fromdateHl, todatehl);
			double totalOTHL = totalOTHL(idemp, fromdateHl, todatehl);
			double totalOToffHL = 0;
			int validreason1 = validreason(idemp, 1, month);
			int validreason2 = validreason(idemp, 2, month);
			try (var conn = commom.ConnecDB.getConnect();
					var ps = conn.prepareCall("{call insertatdreport(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");) {
				ps.setInt(1, idemp);
				ps.setInt(2, month);
				ps.setDouble(3, totaltimekeeping);
				ps.setDouble(4, totalworkHL);
				ps.setDouble(5, totalworkoffday);
				ps.setDouble(6, totalshift3);
				ps.setDouble(7, totalshift4);
				ps.setInt(8, totalworkfullday);
				ps.setDouble(9, totalOTonday);
				ps.setDouble(10, totalOToffday);
				ps.setDouble(11, totalOTHL);
				ps.setDouble(12, totalOToffHL);
				ps.setInt(13, validreason1);
				ps.setInt(14, validreason2);
				i = ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}

			idemp += 1;
		}
		return i;

	}

	// insert thang co NGHI BU
	public int inserttotableOnlyNghiBu(int month, Date fromdateHl, Date todatehl) {
		var i = 0;
		var maxid = idcaonhat();
		var idemp = 1;
		while (idemp <= maxid) {
			double totaltimekeeping = gettotaltimekeeping(idemp, month);
			double totalworkHL = 0;
			double totalworkoffday = gettotalworkHL(idemp, fromdateHl, todatehl);
			double totalshift3 = totalshift3(idemp, month);
			double totalshift4 = totalshift4(idemp, month);
			int totalworkfullday = totalworkfullday(idemp, month);
			double totalOTonday = totalOTOnDaymaybeHL(idemp, fromdateHl, todatehl);
			double totalOToffday = totalOTOffDaymaybeHL(idemp, fromdateHl, todatehl);
			double totalOTHL = 0;
			double totalOToffHL = totalOTHL(idemp, fromdateHl, todatehl);
			int validreason1 = validreason(idemp, 1, month);
			int validreason2 = validreason(idemp, 2, month);
			try (var conn = commom.ConnecDB.getConnect();
					var ps = conn.prepareCall("{call insertatdreport(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");) {
				ps.setInt(1, idemp);
				ps.setInt(2, month);
				ps.setDouble(3, totaltimekeeping);
				ps.setDouble(4, totalworkHL);
				ps.setDouble(5, totalworkoffday);
				ps.setDouble(6, totalshift3);
				ps.setDouble(7, totalshift4);
				ps.setInt(8, totalworkfullday);
				ps.setDouble(9, totalOTonday);
				ps.setDouble(10, totalOToffday);
				ps.setDouble(11, totalOTHL);
				ps.setDouble(12, totalOToffHL);
				ps.setInt(13, validreason1);
				ps.setInt(14, validreason2);
				i = ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}

			idemp += 1;
		}
		return i;

	}

	public int update(int month) {
		var i = 0;
		var maxid = idcaonhat();
		var idemp = 1;
		while (idemp <= maxid) {
			int validreason1 = getvalidateion1(idemp, month);
			int validreason2 = getvalidateion2(idemp, month);
			updatetotalsalarydeduction(idemp,month,validreason1,validreason2);
			idemp += 1;
		}
		return i;

	}
	private int updatetotalsalarydeduction(int idemp, int month, double validreason1, double validreason2) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call totalsalarydeduction(?,?,?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			ps.setDouble(3, validreason1);
			ps.setDouble(4, validreason2);
			var rs = ps.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private int getvalidateion1(int idemp, int month) {
		int validateion = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement(
						"select validreason1 from Attendancemonthlyreport where idemp=? and month = ?");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			if (rs.next()) {
				validateion=rs.getInt("validreason1");
					
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return validateion;
	}
	private int getvalidateion2(int idemp, int month) {
		int validateion = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select validreason2 from Attendancemonthlyreport where idemp=? and month =?");)
		{
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			if (rs.next()) {
				validateion=rs.getInt("validreason2");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return validateion;
	}
	// =============================method con=====================
	private int validreason(int idemp, int reason, int month) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call validreason(?,?,?)}");) {
			ps.setInt(1, idemp);
			ps.setInt(2, reason);
			ps.setInt(3, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	private int totalworkfullday(int idemp, int month) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call totalworkfullday(?,?)}");) {
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

	public double gettotaltimekeeping(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call totaltimekeeping(?,?)}");) {
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

	public double gettotalworkHL(int idemp, Date fromdate, Date todate) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call totalworkHL(?,?,?)}");) {
			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date) fromdate);
			ps.setDate(3, (java.sql.Date) todate);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public double totalworkoffday(int idemp, Date fromdate, Date todate) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call totalworkoffday(?,?,?)}");) {
			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date) fromdate);
			ps.setDate(3, (java.sql.Date) todate);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public double totalshift3(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call totalshift3(?,?)}");) {
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

	public double totalshift4(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call totalshift4(?,?)}");) {
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

	// --tinh OT lam OFF DAY thang ko co OT va ko co ngay nghi bu
	private double totalOT_offdaymonth_noHL(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call totalOT_offdaymonth_noHL(?,?)}");) {
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

	// tinh tong OT ngay on day ma thang ko có hl, ko co nghi bu
	private double totalOTondayNoHL(int idemp, int month) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call totalOTondayNoHL(?,?)}");) {
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

	// tinh tong OT ngay on day ma thang có hl, co nghi bu
	private double totalOTOndaymonth_HLandOffHL(int idemp, Date fromdateHl, Date todatehl, Date fromdateoffHL,
			Date todateoffHL) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call totalOTOndaymonth_HLandOffHL(?,?,?,?,?)}");) {
			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date) fromdateHl);
			ps.setDate(3, (java.sql.Date) todatehl);
			ps.setDate(4, (java.sql.Date) fromdateoffHL);
			ps.setDate(5, (java.sql.Date) todateoffHL);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	// --tinh OT OFF DAY co HL va co nghi bu
	private double totalOToffdaymonthHLandOffHL(int idemp, Date fromdateHl, Date todatehl, Date fromdateoffHL,
			Date todateoffHL) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call totalOToffdaymonthHLandOffHL(?,?,?,?,?)}");) {
			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date) fromdateHl);
			ps.setDate(3, (java.sql.Date) todatehl);
			ps.setDate(4, (java.sql.Date) fromdateoffHL);
			ps.setDate(5, (java.sql.Date) todateoffHL);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	// tinh OT neu lam vao ngay HL HOAC NGHI BU
	private double totalOTHL(int idemp, Date fromdate, Date todate) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call totalOTHLOrNghiBu(?,?,?)}");) {
			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date) fromdate);
			ps.setDate(3, (java.sql.Date) todate);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	// tinh OT neu lam vao ngay on day thang co nghi le HOAC nghi bu
	private double totalOTOnDaymaybeHL(int idemp, Date fromdate, Date todate) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call totalOTOnDaymaybeHL(?,?,?)}");) {
			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date) fromdate);
			ps.setDate(3, (java.sql.Date) todate);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	// tinh OT neu lam vao ngay nghi thang co nghi le HOAC nghi bu
	private double totalOTOffDaymaybeHL(int idemp, Date fromdate, Date todate) {
		double i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call totalOTOffDaymaybeHL(?,?,?)}");) {
			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date) fromdate);
			ps.setDate(3, (java.sql.Date) todate);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	// ============================================
	public int checkreport(int monnth) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call checkreport(?)}");) {
			ps.setInt(1, monnth);

			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int deletereport(int monnth) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call deletereport(?)}");) {
			ps.setInt(1, monnth);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	// ====================
	
	// ====check month exist xuất excel
	public boolean checkExistMonth(int month) {
		boolean check = false;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select month from Attendancemonthlyreport where month = ?");) {
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

}
