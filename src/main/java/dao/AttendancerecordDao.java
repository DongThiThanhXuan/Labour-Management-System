package dao;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entities.Attendancerecord;
import entities.DateShi;
import entities.Employee;

public class AttendancerecordDao {

	// ======================dac==================
		public Date getLastDate() {
			Date date = null;
			try (var conn = commom.ConnecDB.getConnect();
					var ps = conn.prepareStatement(
							"SELECT [date] FROM dbo.Attendancerecord ORDER BY [date] DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS only");) {

				var rs = ps.executeQuery();
				while (rs.next()) {
					date = rs.getDate(1);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return date;
		}

		public List<DateShi> getDateAndShift(int idemp) {
			List<DateShi> dateShis = new ArrayList<DateShi>();
			DateShi date1 = null;
			try (var conn = commom.ConnecDB.getConnect();
					var ps = conn.prepareStatement(
							"SELECT DAY([date]) as day, MONTH([date]) as month, YEAR([date]) as year, [date], idShift  FROM dbo.Attendancerecord WHERE idemp = ? ");) {
				ps.setInt(1, idemp);
				var rs = ps.executeQuery();
				while (rs.next()) {
					date1 = new DateShi(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getInt(5));
					dateShis.add(date1);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return dateShis;
		}

		public int countDay(Date dateFrom, Date dateTo, int idemp) {
			int i = 0;
			try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call countDay(?,?,?)}");) {
				ps.setDate(1,new java.sql.Date(dateFrom.getTime()));
				ps.setDate(2,new java.sql.Date(dateTo.getTime()));
				ps.setInt(3, idemp);
			var	rs = ps.executeQuery();
			
			while (rs.next()) {
				i=rs.getInt(1);
			}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return i;

		}
	// ======================lan==================

	// ======================xuan==================
	public int insertteam1(int month, int year, int namnhuan) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call team1and4shift(?,?,?)}");) {
			ps.setInt(1, month);
			ps.setInt(2, year);
			ps.setInt(3, namnhuan);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int insertteam2(int month, int year, int namnhuan) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call team2and4shift(?,?,?)}");) {
			ps.setInt(1, month);
			ps.setInt(2, year);
			ps.setInt(3, namnhuan);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}

	public int insertteam3(int month, int year, int namnhuan) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call team3and4shift(?,?,?)}");) {
			ps.setInt(1, month);
			ps.setInt(2, year);
			ps.setInt(3, namnhuan);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}

	public int insertteam4(int month, int year, int namnhuan) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call team4and4shift(?,?,?)}");) {
			ps.setInt(1, month);
			ps.setInt(2, year);
			ps.setInt(3, namnhuan);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}

	public int insertteam5(int month, int year, int namnhuan) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call team5and4shift(?,?,?)}");) {
			ps.setInt(1, month);
			ps.setInt(2, year);
			ps.setInt(3, namnhuan);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}

	public int Xuaninsertshiftofoffice(int month, int year, int namnhuan) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareCall("{call Xuaninsertshiftofoffice(?,?,?)}");) {
			ps.setInt(1, month);
			ps.setInt(2, year);
			ps.setInt(3, namnhuan);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int updatehlforOF(Date fromdate, Date todate) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call updatehlforOF(?,?)}");) {
			ps.setDate(1, (java.sql.Date) fromdate);
			ps.setDate(2, (java.sql.Date) todate);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}


	public int updateseason(int season,int idemp,Date fromdate, Date todate ) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
			var ps = conn.prepareStatement("update Attendancerecord set seasondate=? where idemp=? and date between ? and ?");) {
			ps.setInt(1, season);
			ps.setInt(2, idemp);
			ps.setDate(3, (java.sql.Date) fromdate);
			ps.setDate(4, (java.sql.Date) todate);

			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}
	
	
	
	
	
	public int updatenghibuhlforOF(Date fromdate, Date todate) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call updatenghibuhlforOF(?,?)}");) {
			ps.setDate(1, (java.sql.Date) fromdate);
			ps.setDate(2, (java.sql.Date) todate);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}
	public int updatehlforOP(Date fromdate, Date todate,int season) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call updatehlforOP(?,?,?)}");) {
			ps.setDate(1, (java.sql.Date) fromdate);
			ps.setDate(2, (java.sql.Date) todate);
			ps.setInt(3, season);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}
	
	public int updateseasondate(int idemp,Date day,int seasondate ) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("update  Attendancerecord set seasondate=? where idemp=? and [date]=? ");) {
			ps.setInt(1, seasondate);			
			ps.setInt(2, idemp);
			ps.setDate(3, (java.sql.Date) day);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}
	
	
	
	
	// ======================================================================

	

	// ============================
	public Date getOldDay(Date day) {
		Calendar date1 = Calendar.getInstance();
		date1.setTime(day);
		date1.add(Calendar.DAY_OF_YEAR, -1);
		Date date2 = date1.getTime();
		return new java.sql.Date(date2.getTime());

	}

	public int showmonth(Date day) {
		int i = 0;

		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sovoingay1thangsau(?)}");) {
			ps.setDate(1, (java.sql.Date) day);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}

	public int getshift(int idemp, Date day) {
		int i = 0;

		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call layshifttheongay(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date) day);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}

	public int updatecheckin(LocalTime timein, int idemp, Date day) {
		int i = 0;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		Time time = Time.valueOf(timein.format(formatter));
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("update Attendancerecord set checkin=? where idemp=? and [date]=? ");) {
			ps.setTime(1, time);
			ps.setInt(2, idemp);
			ps.setDate(3, (java.sql.Date) day);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public int updatecheckout(LocalTime timeout, int idemp, Date day) {
		int i = 0;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		Time time = Time.valueOf(timeout.format(formatter));
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("update Attendancerecord set checkout=? where idemp=? and [date]=? ");) {
			ps.setTime(1, time);
			ps.setInt(2, idemp);
			ps.setDate(3, (java.sql.Date) day);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public int validreason(int vali, int idemp, Date day) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn
						.prepareStatement("update Attendancerecord set validreason=? where idemp=? and [date]=? ");) {
			ps.setInt(1, vali);
			ps.setInt(2, idemp);
			ps.setDate(3, (java.sql.Date) day);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public int updatShift(int idshift, int idemp, Date day) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("update Attendancerecord set idShift=? where idemp=? and [date]=? ");) {
			ps.setInt(1, idshift);
			ps.setInt(2, idemp);
			ps.setDate(3, (java.sql.Date) day);

			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public int updatereasonCheckin(String reason, int idemp, Date day) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn
						.prepareStatement("update Attendancerecord set reasoncheckin=? where idemp=? and [date]=? ");) {
			ps.setString(1, reason);
			ps.setInt(2, idemp);
			ps.setDate(3, (java.sql.Date) day);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public int updatereasonCheckout(String reason, int idemp, Date day) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement(
						"update Attendancerecord set reasoncheckout=? where idemp=? and [date]=? ");) {
			ps.setString(1, reason);
			ps.setInt(2, idemp);
			ps.setDate(3, (java.sql.Date) day);

			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public int updateOT(double OT, int idemp, Date day) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("update Attendancerecord set OT=? where idemp=? and [date]=? ");) {
			ps.setDouble(1, OT);
			ps.setInt(2, idemp);
			ps.setDate(3, (java.sql.Date) day);

			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public int updatevalidreason(int validreason, Date day) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement(
						"update Attendancerecord set validreason=? where [date]=? and reasoncheckin is null and reasoncheckout is null ");) {
			ps.setInt(1, validreason);
			ps.setDate(2, (java.sql.Date) day);

			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public int updatevalidreasonForOneEmp(int validreason, Date day, int idemp) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn
						.prepareStatement("update Attendancerecord set validreason=? where [date]=? and idemp=? ");) {
			ps.setInt(1, validreason);
			ps.setDate(2, (java.sql.Date) day);
			ps.setInt(3, idemp);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public int updatetimekeepingbyday(Date day) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call updateTimekyeepingbyday(?)}");) {
			ps.setDate(1, (java.sql.Date) day);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public double sumOT(int idemp, Date date) {
		double i = 0;

		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call sumot(?,?)}");) {
			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date) date);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}

	public LocalTime checkcheckintime(int idemp, Date day) {
		LocalTime checkintime = null;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select checkin from Attendancerecord where idemp=? and [date]=? ");) {

			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date) day);
			var rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getTime(1) != null) {
					checkintime = rs.getTime(1).toLocalTime();
				} else {
					checkintime = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkintime;
	}

	public LocalTime checkcheckouttime(int idemp, Date day) {
		LocalTime checkouttime = null;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select checkout from Attendancerecord where idemp=? and [date]=? ");) {

			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date) day);
			var rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getTime(1) != null) {
					checkouttime = rs.getTime(1).toLocalTime();
				} else {
					checkouttime = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkouttime;
	}

	public Attendancerecord getinfo1(int idemp, Date day) {
		Attendancerecord atd = null;
		var date = new java.sql.Date(day.getTime());
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from Attendancerecord where idemp=? and [date]=? ");) {

			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date) date);
			var rs = ps.executeQuery();
			if (rs.next()) {

				LocalTime checkin = rs.getTime("checkin").toLocalTime();
				LocalTime checkout = rs.getTime("checkout").toLocalTime();

				atd = new Attendancerecord(rs.getInt("idemp"), rs.getInt("idShift"), rs.getDate("date"), checkin,
						checkout, rs.getDouble("OT"), rs.getString("reasoncheckin"), rs.getString("reasoncheckout"),
						rs.getInt("validreason"), rs.getDouble("Timekeepingbyday"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return atd;
	}

	public Attendancerecord getinfo(int idemp, Date day) {
		Attendancerecord atd = null;
		var date = new java.sql.Date(day.getTime());
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from Attendancerecord where idemp=? and [date]=? ");) {

			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date) date);
			var rs = ps.executeQuery();
			if (rs.next()) {
				atd = new Attendancerecord(rs.getInt("idemp"), rs.getInt("idShift"), rs.getDate("date"),
						rs.getDouble("OT"), rs.getString("reasoncheckin"), rs.getString("reasoncheckout"),
						rs.getInt("validreason"), rs.getDouble("Timekeepingbyday"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return atd;
	}

	public List<Attendancerecord> Showbyday(Date day) {
		List<Attendancerecord> list = new ArrayList<Attendancerecord>();
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call showattendancebyday(?)}");) {
			cs.setDate(1, (java.sql.Date) day);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var scheckin = rs.getString("checkin");
				var scheckout = rs.getString("checkout");
				LocalTime checkin1 = null;
				LocalTime checkout1 = null;
				if (scheckin == null) {
					checkin1 = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
				}
				if (scheckout == null) {
					checkout1 = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
				}
				if (scheckin != null) {
					checkin1 = rs.getTime("checkin").toLocalTime();
				}
				if (scheckout != null) {
					checkout1 = rs.getTime("checkout").toLocalTime();
				}

				var atd = new Attendancerecord(rs.getInt("idemp"), rs.getInt("idShift"), rs.getDate("date"),rs.getInt("seasondate"), checkin1,
						checkout1, rs.getDouble("OT"), rs.getString("reasoncheckin"), rs.getString("reasoncheckout"),
						rs.getInt("validreason"), rs.getDouble("Timekeepingbyday"));

				list.add(atd);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Attendancerecord> Searchallonday(Date day, String name, int idshift) {
		List<Attendancerecord> list = new ArrayList<Attendancerecord>();
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("{call searchattendancebyday2(?,?,?)}");) {
			cs.setDate(1, (java.sql.Date) day);
			cs.setString(2, "%" + name + "%");
			cs.setInt(3, idshift);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var scheckin = rs.getString("checkin");
				var scheckout = rs.getString("checkout");
				LocalTime checkin1 = null;
				LocalTime checkout1 = null;
				if (scheckin == null) {
					checkin1 = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
				}
				if (scheckout == null) {
					checkout1 = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
				}
				if (scheckin != null) {
					checkin1 = rs.getTime("checkin").toLocalTime();
				}
				if (scheckout != null) {
					checkout1 = rs.getTime("checkout").toLocalTime();
				}

				var atd = new Attendancerecord(rs.getInt("idemp"), rs.getInt("idShift"), rs.getDate("date"),rs.getInt("seasondate"), checkin1,
						checkout1, rs.getDouble("OT"), rs.getString("reasoncheckin"), rs.getString("reasoncheckout"),
						rs.getInt("validreason"), rs.getDouble("Timekeepingbyday"));
				list.add(atd);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Attendancerecord> SearchDateAndName(Date day, String name) {
		List<Attendancerecord> list = new ArrayList<Attendancerecord>();
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("{call searchattendancebyday1(?,?)}");) {
			cs.setDate(1, (java.sql.Date) day);
			cs.setString(2, "%" + name + "%");
			var rs = cs.executeQuery();
			while (rs.next()) {
				var scheckin = rs.getString("checkin");
				var scheckout = rs.getString("checkout");
				LocalTime checkin1 = null;
				LocalTime checkout1 = null;
				if (scheckin == null) {
					checkin1 = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
				}
				if (scheckout == null) {
					checkout1 = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
				}
				if (scheckin != null) {
					checkin1 = rs.getTime("checkin").toLocalTime();
				}
				if (scheckout != null) {
					checkout1 = rs.getTime("checkout").toLocalTime();
				}

				var atd = new Attendancerecord(rs.getInt("idemp"), rs.getInt("idShift"), rs.getDate("date"),rs.getInt("seasondate"), checkin1,
						checkout1, rs.getDouble("OT"), rs.getString("reasoncheckin"), rs.getString("reasoncheckout"),
						rs.getInt("validreason"), rs.getDouble("Timekeepingbyday"));

				list.add(atd);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Attendancerecord> SearchDateAndShift(Date day, int idshift) {
		List<Attendancerecord> list = new ArrayList<Attendancerecord>();
		try (var conn = commom.ConnecDB.getConnect();
				var cs = conn.prepareCall("{call searchattendancebyday3(?,?)}");) {
			cs.setDate(1, (java.sql.Date) day);
			cs.setInt(2, idshift);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var scheckin = rs.getString("checkin");
				var scheckout = rs.getString("checkout");
				LocalTime checkin1 = null;
				LocalTime checkout1 = null;
				if (scheckin == null) {
					checkin1 = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
				}
				if (scheckout == null) {
					checkout1 = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
				}
				if (scheckin != null) {
					checkin1 = rs.getTime("checkin").toLocalTime();
				}
				if (scheckout != null) {
					checkout1 = rs.getTime("checkout").toLocalTime();
				}

				var atd = new Attendancerecord(rs.getInt("idemp"), rs.getInt("idShift"), rs.getDate("date"),rs.getInt("seasondate"), checkin1,
						checkout1, rs.getDouble("OT"), rs.getString("reasoncheckin"), rs.getString("reasoncheckout"),
						rs.getInt("validreason"), rs.getDouble("Timekeepingbyday"));

				list.add(atd);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int differenceMonth(Date date) {
		int i = 0;

		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call chenhlechthang(?)}");) {
			ps.setDate(1, (java.sql.Date) date);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}

	public int differencetime(LocalTime timein, LocalTime timeout) {
		int i = 0;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		Time timeinsdtb = Time.valueOf(timein.format(formatter));
		Time timeoutsdtb = Time.valueOf(timeout.format(formatter));
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call chenhlechcheckinvaOut(?,?)}");) {

			ps.setTime(1, timeinsdtb);
			ps.setTime(2, timeoutsdtb);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}

	public int differenceDate(Date date) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call chenhlechngay(?)}");) {
			ps.setDate(1, (java.sql.Date) date);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}

	public List<Attendancerecord> loaddatatoShowlic(int idrq) {
		List<Attendancerecord> list = new ArrayList<Attendancerecord>();
		try (var conn = commom.ConnecDB.getConnect(); var cs = conn.prepareCall("{call Showdateleavebyid(?)}");) {
			cs.setInt(1, idrq);
			var rs = cs.executeQuery();
			while (rs.next()) {

				var atd = new Attendancerecord(rs.getInt("idemp"), rs.getInt("idShift"), rs.getDate("date"));

				list.add(atd);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int updateleaveforemp(int idemp, Date fromdate, Date todate) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call updateleaveforemp(?,?,?)}");) {
			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date) fromdate);
			ps.setDate(3, (java.sql.Date) todate);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}

	public int updateleaveforemp2(int idemp, Date date, int idshift) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call updateleaveforemp2(?,?,?)}");) {
			ps.setInt(1, idemp);
			ps.setDate(2, (java.sql.Date) date);
			ps.setInt(3, idshift);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return i;

	}

	public int chenhlechgiua2ngay(Date fromdate, Date todate) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call chenhlech2ngay(?,?)}");) {
			ps.setDate(1, (java.sql.Date) fromdate);
			ps.setDate(2, (java.sql.Date) todate);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public Attendancerecord getvaluefromemprqs(int idrqs) {
		Attendancerecord atd = null;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call getvaluefromemprqs(?)}");) {
			ps.setInt(1, idrqs);

			var rs = ps.executeQuery();
			if (rs.next()) {
				atd = new Attendancerecord(rs.getInt(1), rs.getInt(2), rs.getDate(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return atd;
	}

	public Attendancerecord getvaluetoemprqs(int idrqs) {
		Attendancerecord atd = null;
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call getvaluetoemprqs(?)}");) {
			ps.setInt(1, idrqs);

			var rs = ps.executeQuery();
			if (rs.next()) {
				atd = new Attendancerecord(rs.getInt(1), rs.getInt(2), rs.getDate(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return atd;
	}

	public List<Attendancerecord> showDetailsAtdEmpbyMonth(int idemp, int month) {
		List<Attendancerecord> list = new ArrayList<Attendancerecord>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from Attendancerecord where idemp=? and month(date)=? ");) {
			ps.setInt(1, idemp);
			ps.setInt(2, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var scheckin = rs.getString("checkin");
				var scheckout = rs.getString("checkout");
				LocalTime checkin1 = null;
				LocalTime checkout1 = null;
				if (scheckin == null) {
					checkin1 = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
				}
				if (scheckout == null) {
					checkout1 = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
				}
				if (scheckin != null) {
					checkin1 = rs.getTime("checkin").toLocalTime();
				}
				if (scheckout != null) {
					checkout1 = rs.getTime("checkout").toLocalTime();
				}

				var atd = new Attendancerecord(rs.getInt("idemp"), rs.getInt("idShift"), rs.getDate("date"),rs.getInt("seasondate"), checkin1,
						checkout1, rs.getDouble("OT"), rs.getString("reasoncheckin"), rs.getString("reasoncheckout"),
						rs.getInt("validreason"), rs.getDouble("Timekeepingbyday"));
				list.add(atd);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Date getFromDate(int month, int seasondate) {
		Date date = null;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement(
						"select top 1( date) from Attendancerecord where month(date)=? and seasondate=? group by date order by date asc");) {
			ps.setInt(1, month);
			ps.setInt(2, seasondate);
			var rs = ps.executeQuery();
			while (rs.next()) {
				date = rs.getDate(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public Date getToDate(int month, int seasondate) {
		Date date = null;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement(
						"select top 1( date) from Attendancerecord where month(date)=? and seasondate=? group by date order by date DESC");) {
			ps.setInt(1, month);
			ps.setInt(2, seasondate);
			var rs = ps.executeQuery();
			while (rs.next()) {
				date = rs.getDate(1);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public int checkexist(int month, int seasondate) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement(
						"select count(date) from Attendancerecord where month(date)=? and seasondate=?  ");) {
			ps.setInt(1, month);
			ps.setInt(2, seasondate);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int delete(int month) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement(
						"delete from Attendancerecord where month(date)=? ");) {
			ps.setInt(1, month);
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int checkhl(Date date) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement(
						"select   seasondate from Attendancerecord where (date=? and seasondate is not null) group by seasondate ");) {
			ps.setDate(1, (java.sql.Date) date);
			var rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getStatement()!=null || rs.getInt(1)!=0) {
					i = rs.getInt(1);
					}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
////====check month exist xuất excel
	public boolean checkExistMonth(int month) {
		boolean check = false;
		try (var conn = commom.ConnecDB.getConnect();
			var ps = conn.prepareStatement("select month(date) from Attendancerecord where month(date)=?");) {
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
	
	public List<Attendancerecord> showDetailsAtdEmpbyMonth(int month) {
		List<Attendancerecord> list = new ArrayList<Attendancerecord>();
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select * from Attendancerecord where month(date)=? order by date ASC");) {
			ps.setInt(1, month);
			var rs = ps.executeQuery();
			while (rs.next()) {
				var scheckin = rs.getString("checkin");
				var scheckout = rs.getString("checkout");
				LocalTime checkin1 = null;
				LocalTime checkout1 = null;
				if (scheckin == null) {
					checkin1 = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
				}
				if (scheckout == null) {
					checkout1 = LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
				}
				if (scheckin != null) {
					checkin1 = rs.getTime("checkin").toLocalTime();
				}
				if (scheckout != null) {
					checkout1 = rs.getTime("checkout").toLocalTime();
				}

				var atd = new Attendancerecord(rs.getInt("idemp"), rs.getInt("idShift"), rs.getDate("date"),rs.getInt("seasondate"), checkin1,
						checkout1, rs.getDouble("OT"), rs.getString("reasoncheckin"), rs.getString("reasoncheckout"),
						rs.getInt("validreason"), rs.getDouble("Timekeepingbyday"));

				list.add(atd);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int checkattd(Date date) {
		int i = 0;
		try (var conn = commom.ConnecDB.getConnect(); 
				var ps = conn.prepareStatement("select sum(Timekeepingbyday) as t from Attendancerecord where date=?");) {
			ps.setDate(1, (java.sql.Date) date);
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
