package dao;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Attendancerecord;
import entities.Employee;
import entities.Shift;

public class ShiftDao {
	//=================XUAN==================
	public LocalTime gettimecheckin(int idshift) {
		LocalTime checkintime = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
		try (var conn = commom.ConnecDB.getConnect();
				var ps = conn.prepareStatement("select timein from [Shift] where idShift=? ");) {
			ps.setInt(1, idshift);
			var rs = ps.executeQuery();
			if (rs.next()) {
				checkintime = rs.getTime(1).toLocalTime();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return checkintime;

	}
	public LocalTime gettimecheckout(int idshift) {
		LocalTime checkoutintime = null;
		try (var conn = commom.ConnecDB.getConnect();
		var ps = conn.prepareStatement("select timeout from [Shift] where idShift=?");) {
			ps.setInt(1, idshift);
			var rs = ps.executeQuery();
			if (rs.next()) {
				checkoutintime = rs.getTime(1).toLocalTime();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return checkoutintime;

	}
	
	public int checkchenhlech(int idShift, LocalTime nowtime) {
		int i = 0;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		Time time = Time.valueOf(nowtime.format(formatter));
		try (var conn = commom.ConnecDB.getConnect(); var ps = conn.prepareCall("{call chenhlechgio(?,?)}");) {
			ps.setInt(1, idShift);
			ps.setTime(2, time);
			var rs = ps.executeQuery();
			while (rs.next()) {
				i=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}
	public List<Shift> getListShift() {
		List<Shift> list = new ArrayList<Shift>();
		try (var conn = commom.ConnecDB.getConnect(); 
				var ps = conn.prepareStatement("select * from Shift");) {
			var rs = ps.executeQuery();
			while (rs.next()) {			
				var	Shift = new Shift(rs.getInt(1),rs.getTime(2).toLocalTime(),rs.getTime(3).toLocalTime());
				list.add(Shift);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//==============DAC=============
	public List<Shift> getHalfShift(int idShift) {
		List<Shift> list = new ArrayList<Shift>();
		try (var conn = commom.ConnecDB.getConnect(); 
				var ps = conn.prepareCall("{call dac_select_half_shift(?)}");) {
			ps.setString(1, String.valueOf(idShift));
			var rs = ps.executeQuery();
			while (rs.next()) {			
				var	Shift = new Shift(rs.getInt(1),rs.getTime(2).toLocalTime(),rs.getTime(3).toLocalTime());
				list.add(Shift);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Shift> getFullShift() {
		List<Shift> list = new ArrayList<Shift>();
		try (var conn = commom.ConnecDB.getConnect(); 
				var ps = conn.prepareCall(" SELECT * FROM [Shift] ORDER BY idShift OFFSET 0 ROWS FETCH NEXT 4 ROWS ONLY ");) {
			var rs = ps.executeQuery();
			while (rs.next()) {			
				var	Shift = new Shift(rs.getInt(1),rs.getTime(2).toLocalTime(),rs.getTime(3).toLocalTime());
				list.add(Shift);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
