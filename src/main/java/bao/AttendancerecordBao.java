package bao;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.AttendancerecordDao;
import entities.Attendancerecord;
import entities.DateShi;

public class AttendancerecordBao {
	AttendancerecordDao atddao = new AttendancerecordDao();



	//==========Dac========
	
	public Date lastDate() {
		return atddao.getLastDate();
	}
	public List<DateShi> getDate(int idemp) {
		return atddao.getDateAndShift(idemp);
	}
	public int countDay(Date dateFrom, Date dateTo, int idemp) {
		return atddao.countDay(dateFrom, dateTo, idemp);
	}
	//==========XUAN========
	
	public int insertteam1(int month, int year, int namnhuan) {
		return atddao.insertteam1(month, year, namnhuan);
	}

	public int insertteam2(int month, int year, int namnhuan) { 
		return atddao.insertteam2(month, year, namnhuan);
	}

	public int insertteam3(int month, int year, int namnhuan) {
		return atddao.insertteam3(month, year, namnhuan);
	}

	public int insertteam4(int month, int year, int namnhuan) {
		return atddao.insertteam4(month, year, namnhuan);
	}

	public int insertteam5(int month, int year, int namnhuan) {
		return atddao.insertteam5(month, year, namnhuan);
	}

	public int insertshiftofoffice(int month, int year, int namnhuan) {
		return atddao.Xuaninsertshiftofoffice(month, year, namnhuan);
	}

	public int updatehlforOF(Date fromdate, Date todate) {
		return atddao.updatehlforOF(fromdate, todate);
	}

	public int updatenghibuhlforOF(Date fromdate, Date todate) {
		return atddao.updatenghibuhlforOF(fromdate, todate);

	}
	

	public int updatehlforOP(Date fromdate, Date todate,int season) {
		return atddao.updatehlforOP(fromdate, todate, season);
	}
	// ====lay ra ca lam cua 1 nv theo ngay====
	public int getshift(int idemp, Date day) {
		return atddao.getshift(idemp, day);

	}

	public Date getOldDay(Date day) {
		return atddao.getOldDay(day);
	}

	public int updatecheckin(LocalTime timein, int idemp, Date day) {
		return atddao.updatecheckin(timein, idemp, day);

	}

	public int updatecheckout(LocalTime timeout, int idemp, Date day) {
		return atddao.updatecheckout(timeout, idemp, day);

	}

	public LocalTime checkcheckintime(int idemp, Date day) {
		return atddao.checkcheckintime(idemp, day);
	}

	public LocalTime checkcheckouttime(int idemp, Date day) {
		return atddao.checkcheckouttime(idemp, day);
	}

	public Attendancerecord getinfo(int idemp, Date day) {
		return atddao.getinfo(idemp, day); 
	}

	public int validreason(int vali, int idemp, Date day) {
		return atddao.validreason(vali, idemp, day);
	}

	public int updatereasonCheckin(String reason, int idemp, Date day) {
		return atddao.updatereasonCheckin(reason, idemp, day);
	}

	public int updatShift(int idshift, int idemp, Date day) {
		return atddao.updatShift(idshift, idemp, day);
	}

	public int updatereasonCheckout(String reason, int idemp, Date day) {
		return atddao.updatereasonCheckout(reason, idemp, day);
	}

	public int updatevalidreason(int Ovalidreason, Date day) {
		return atddao.updatevalidreason(Ovalidreason, day);

	}

	public int updatevalidreasonForOneEmp(int validreason, Date day, int idemp) {
		return atddao.updatevalidreasonForOneEmp(validreason, day, idemp);

	}

	public List<Attendancerecord> Showbyday(Date day) {
		return atddao.Showbyday(day);
	}

	public int updatetimekeepingbyday(Date day) {
		return atddao.updatetimekeepingbyday(day);
	}

	public int updateOT(double OT, int idemp, Date day) {
		return atddao.updateOT(OT, idemp, day);
	}

	public double sumOT(int idemp, Date date) {
		return atddao.sumOT(idemp, date);
	}

	public int differenceMonth(Date date) {
		return atddao.differenceMonth(date);
	}

	public List<Attendancerecord> Searchallonday(Date day, String name, int idshift) {
		return atddao.Searchallonday(day, name, idshift);
	}

	public List<Attendancerecord> SearchDateAndName(Date day, String name) {
		return atddao.SearchDateAndName(day, name);
	}

	public List<Attendancerecord> SearchDateAndShift(Date day, int idshift) {
		return atddao.SearchDateAndShift(day, idshift);
	}

	public int differencetime(LocalTime timein, LocalTime timeout) {
		return atddao.differencetime(timein, timeout);
	}

	public int showmonth(Date day) {
		return atddao.showmonth(day);
	}

	public int differenceDate(Date date) {
		return atddao.differenceDate(date);
	}

	public List<Attendancerecord> loaddatatoShowlic(int idrq) {
		return atddao.loaddatatoShowlic(idrq);
	}

	public int updateleaveforemp(int idemp, Date fromdate, Date todate) {
		return atddao.updateleaveforemp(idemp, fromdate, todate);

	}

	public int updateleaveforemp2(int idemp, Date date, int idshift) {
		return atddao.updateleaveforemp2(idemp, date, idshift);

	}
	public int chenhlechgiua2ngay (Date fromdate,Date todate) {
		return atddao.chenhlechgiua2ngay(fromdate, todate);
	}
	
	
	public Attendancerecord getvaluefromemprqs(int idrqs) {
		return atddao.getvaluefromemprqs(idrqs);
	}
	
	public Attendancerecord getvaluetoemprqs(int idrqs) {
		return atddao.getvaluetoemprqs(idrqs);
	}
	
	public List<Attendancerecord> showDetailsAtdEmpbyMonth(int idemp, int month) {
		return atddao.showDetailsAtdEmpbyMonth(idemp, month);
	}
	public Date getFromDate(int month,int seasondate) {
		return atddao.getFromDate(month, seasondate);
	}
	public Date getToDate(int month,int seasondate) {
		return atddao.getToDate(month, seasondate);
	}
	public int checkexist(int month,int seasondate) {
		return atddao.checkexist(month,seasondate);
	}
	
	public List<Attendancerecord> showDetailsAtdEmpbyMonth(int month) {
		return atddao.showDetailsAtdEmpbyMonth(month);
	}
	public boolean checkMonth(int month) {
		return atddao.checkExistMonth(month);
	}
	
	public int delete(int month) {
		return atddao.delete(month);
	}
	public int checkhl(Date date) {
		return atddao.checkhl(date);
	}
	public int updateseasondate(int idemp,Date day,int seasondate ) {
		return atddao.updateseasondate(idemp, day, seasondate);
	}
	public int checkattd(Date date) {
		return  atddao.checkattd(date);

	}
	public int updateseason(int season,int idemp,Date fromdate, Date todate) {
		return  atddao.updateseason(season, idemp, fromdate, todate);

	}
}
