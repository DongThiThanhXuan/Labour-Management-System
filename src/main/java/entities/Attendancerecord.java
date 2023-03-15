package entities;

import java.time.LocalTime;
import java.util.Date;

public class Attendancerecord {
	private int idemp;
	private int idShift;
	private Date date;
	private int seasondate;
	private LocalTime checkin;
	private LocalTime checkout;
	private double OT;
	private String reasoncheckin;
	private String reasoncheckout;
	private int validreason;
	private double Timekeepingbyday;

	public Attendancerecord() {
	}

	public Attendancerecord(int idemp, int idShift, Date date) {
		super();
		this.idemp = idemp;
		this.idShift = idShift;
		this.date = date;
	}

	public Attendancerecord(int idemp, int idShift, Date date, double oT, String reasoncheckin, String reasoncheckout,
			int validreason, double timekeepingbyday) {
		super();
		this.idemp = idemp;
		this.idShift = idShift;
		this.date = date;
		OT = oT;
		this.reasoncheckin = reasoncheckin;
		this.reasoncheckout = reasoncheckout;
		this.validreason = validreason;
		Timekeepingbyday = timekeepingbyday;
	}

	public Attendancerecord(int idemp, int idShift, Date date, LocalTime checkin, LocalTime checkout, double oT,
			String reasoncheckin, String reasoncheckout, int validreason, double timekeepingbyday) {
		super();
		this.idemp = idemp;
		this.idShift = idShift;
		this.date = date;
		this.checkin = checkin;
		this.checkout = checkout;
		OT = oT;
		this.reasoncheckin = reasoncheckin;
		this.reasoncheckout = reasoncheckout;
		this.validreason = validreason;
		Timekeepingbyday = timekeepingbyday;
	}

	public Attendancerecord(int idemp, int idShift, Date date, int seasondate, LocalTime checkin, LocalTime checkout,
			double oT, String reasoncheckin, String reasoncheckout, int validreason, double timekeepingbyday) {
		super();
		this.idemp = idemp;
		this.idShift = idShift;
		this.date = date;
		this.seasondate = seasondate;
		this.checkin = checkin;
		this.checkout = checkout;
		OT = oT;
		this.reasoncheckin = reasoncheckin;
		this.reasoncheckout = reasoncheckout;
		this.validreason = validreason;
		Timekeepingbyday = timekeepingbyday;
	}

	public int getIdemp() {
		return idemp;
	}

	public void setIdemp(int idemp) {
		this.idemp = idemp;
	}

	public int getIdShift() {
		return idShift;
	}

	public void setIdShift(int idShift) {
		this.idShift = idShift;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalTime getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalTime checkin) {
		this.checkin = checkin;
	}

	public LocalTime getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalTime checkout) {
		this.checkout = checkout;
	}

	public double getOT() {
		return OT;
	}

	public void setOT(double oT) {
		OT = oT;
	}

	public String getReasoncheckin() {
		return reasoncheckin;
	}

	public void setReasoncheckin(String reasoncheckin) {
		this.reasoncheckin = reasoncheckin;
	}

	public String getReasoncheckout() {
		return reasoncheckout;
	}

	public void setReasoncheckout(String reasoncheckout) {
		this.reasoncheckout = reasoncheckout;
	}

	public int getValidreason() {
		return validreason;
	}

	public void setValidreason(int validreason) {
		this.validreason = validreason;
	}

	public double getTimekeepingbyday() {
		return Timekeepingbyday;
	}

	public void setTimekeepingbyday(double timekeepingbyday) {
		Timekeepingbyday = timekeepingbyday;
	}

	public int getSeasondate() {
		return seasondate;
	}

	public void setSeasondate(int seasondate) {
		this.seasondate = seasondate;
	}

	@Override
	public String toString() {
		return "Attendancerecord [idemp=" + idemp + ", idShift=" + idShift + ", date=" + date + ", checkin=" + checkin
				+ ", checkout=" + checkout + ", OT=" + OT + ", reasoncheckin=" + reasoncheckin + ", reasoncheckout="
				+ reasoncheckout + ", validreason=" + validreason + ", Timekeepingbyday=" + Timekeepingbyday + "]";
	}

}
