package entities;

import java.util.Date;

public class Requestleave {

	private int idrqleave;
	private int idemp;
	private Date fromdate;
	private Date todate;
	private double annualleave;
	private double unpaidleave;
	private double sickleave;
	private int sendrequesttoadmin;
	private int sttrequestleave;
	private int note;
	private Date deadline;

	public Requestleave() {
		super();
	}
	public Requestleave(int idemp, Date fromDate, Date toDate, double annualleave, double unpaidleave, double sickleave,
			int sendrequesttoadmin, int sttrequestleave) {
		super();
		this.idemp = idemp;
		this.fromdate = fromDate;
		this.todate = toDate;
		this.annualleave = annualleave;
		this.unpaidleave = unpaidleave;
		this.sickleave = sickleave;
		this.sendrequesttoadmin = sendrequesttoadmin;
		this.sttrequestleave = sttrequestleave;
	}

	public Requestleave(int idemp, Date fromDate, Date toDate, double annualleave, double unpaidleave, double sickleave,
			int sendrequesttoadmin, int sttrequestleave, int note) {
		super();
		this.idemp = idemp;
		this.fromdate = fromDate;
		this.todate = toDate;
		this.annualleave = annualleave;
		this.unpaidleave = unpaidleave;
		this.sickleave = sickleave;
		this.sendrequesttoadmin = sendrequesttoadmin;
		this.sttrequestleave = sttrequestleave;
		this.note = note;
	}

	public Requestleave(int idrqleave, int idemp, Date fromDate, Date toDate, double annualleave, double unpaidleave,
			double sickleave, int sendrequesttoadmin, int sttrequestleave, int note) {
		super();
		this.idrqleave = idrqleave;
		this.idemp = idemp;
		this.fromdate = fromDate;
		this.todate = toDate;
		this.annualleave = annualleave;
		this.unpaidleave = unpaidleave;
		this.sickleave = sickleave;
		this.sendrequesttoadmin = sendrequesttoadmin;
		this.sttrequestleave = sttrequestleave;
		this.note = note;
	}

	public Requestleave(int idrqleave, int idemp, Date fromDate, Date toDate, double annualleave, double unpaidleave,
			double sickleave, int sendrequesttoadmin, int sttrequestleave) {
		super();
		this.idrqleave = idrqleave;
		this.idemp = idemp;
		this.fromdate = fromDate;
		this.todate = toDate;
		this.annualleave = annualleave;
		this.unpaidleave = unpaidleave;
		this.sickleave = sickleave;
		this.sendrequesttoadmin = sendrequesttoadmin;
		this.sttrequestleave = sttrequestleave;
	}
	
	public Requestleave(int idrqleave, int idemp, Date fromdate, Date todate, double annualleave, double unpaidleave,
			double sickleave, int sendrequesttoadmin, int sttrequestleave, int note, Date deadline) {
		super();
		this.idrqleave = idrqleave;
		this.idemp = idemp;
		this.fromdate = fromdate;
		this.todate = todate;
		this.annualleave = annualleave;
		this.unpaidleave = unpaidleave;
		this.sickleave = sickleave;
		this.sendrequesttoadmin = sendrequesttoadmin;
		this.sttrequestleave = sttrequestleave;
		this.note = note;
		this.deadline = deadline;
	}
	public int getIdrqleave() {
		return idrqleave;
	}
	public void setIdrqleave(int idrqleave) {
		this.idrqleave = idrqleave;
	}
	public int getIdemp() {
		return idemp;
	}
	public void setIdemp(int idemp) {
		this.idemp = idemp;
	}
	public Date getFromdate() {
		return fromdate;
	}
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	public double getAnnualleave() {
		return annualleave;
	}
	public void setAnnualleave(double annualleave) {
		this.annualleave = annualleave;
	}
	public double getUnpaidleave() {
		return unpaidleave;
	}
	public void setUnpaidleave(double unpaidleave) {
		this.unpaidleave = unpaidleave;
	}
	public double getSickleave() {
		return sickleave;
	}
	public void setSickleave(double sickleave) {
		this.sickleave = sickleave;
	}
	public int getSendrequesttoadmin() {
		return sendrequesttoadmin;
	}
	public void setSendrequesttoadmin(int sendrequesttoadmin) {
		this.sendrequesttoadmin = sendrequesttoadmin;
	}
	public int getSttrequestleave() {
		return sttrequestleave;
	}
	public void setSttrequestleave(int sttrequestleave) {
		this.sttrequestleave = sttrequestleave;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	@Override
	public String toString() {
		return "Requestleave [idrqleave=" + idrqleave + ", idemp=" + idemp + ", fromdate=" + fromdate + ", todate="
				+ todate + ", annualleave=" + annualleave + ", unpaidleave=" + unpaidleave + ", sickleave=" + sickleave
				+ ", sendrequesttoadmin=" + sendrequesttoadmin + ", sttrequestleave=" + sttrequestleave + ", note="
				+ note + "]";
	}

	
	
	
	
	
}
