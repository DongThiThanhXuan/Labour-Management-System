package entities;

import java.util.Date;

public class DateShi {
	private int day;
	private int month;
	private int year;
	private Date date;
	private int idShift;
	

	public DateShi(int day, int month, int year, Date date, int idShift) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.date = date;
		this.idShift = idShift;
	}

	public DateShi(int day, int month, int year, int idShift) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.idShift = idShift;
	}

	public DateShi(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getIdShift() {
		return idShift;
	}

	public void setIdShift(int idShift) {
		this.idShift = idShift;
	}


}
