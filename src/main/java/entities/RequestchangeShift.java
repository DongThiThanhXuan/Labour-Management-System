package entities;

import java.util.Date;

public class RequestchangeShift {
	private int idrqcShift;
	private int fromidemp;
	private int fromidShift;
	private Date datechange;
	private int toidemp;
	private int toidShift;
	private int sendrequesttoadmin;
	private int sttrequestchangeShift;
	private Date deadline;

	public RequestchangeShift() {
		super();
	}

	public RequestchangeShift(int fromidemp, int fromidShift, Date datechange, int toidemp, int toidShift,
			int sttrequestchangeShift) {
		super();
		this.fromidemp = fromidemp;
		this.fromidShift = fromidShift;
		this.datechange = datechange;
		this.toidemp = toidemp;
		this.toidShift = toidShift;
		this.sttrequestchangeShift = sttrequestchangeShift;
	}

	public RequestchangeShift(int idrqcShift, int fromidemp, int fromidShift, Date datechange, int toidemp,
			int toidShift, int sendrequesttoadmin, int sttrequestchangeShift) {
		super();
		this.idrqcShift = idrqcShift;
		this.fromidemp = fromidemp;
		this.fromidShift = fromidShift;
		this.datechange = datechange;
		this.toidemp = toidemp;
		this.toidShift = toidShift;
		this.sendrequesttoadmin = sendrequesttoadmin;
		this.sttrequestchangeShift = sttrequestchangeShift;
	}

	public RequestchangeShift(int idrqcShift, int fromidemp, int fromidShift, Date datechange, int toidemp,
			int toidShift, int sendrequesttoadmin, int sttrequestchangeShift, Date deadline) {
		super();
		this.idrqcShift = idrqcShift;
		this.fromidemp = fromidemp;
		this.fromidShift = fromidShift;
		this.datechange = datechange;
		this.toidemp = toidemp;
		this.toidShift = toidShift;
		this.sendrequesttoadmin = sendrequesttoadmin;
		this.sttrequestchangeShift = sttrequestchangeShift;
		this.deadline = deadline;
	}

	public int getIdrqcShift() {
		return idrqcShift;
	}

	public void setIdrqcShift(int idrqcShift) {
		this.idrqcShift = idrqcShift;
	}

	public int getFromidemp() {
		return fromidemp;
	}

	public void setFromidemp(int fromidemp) {
		this.fromidemp = fromidemp;
	}

	public int getFromidShift() {
		return fromidShift;
	}

	public void setFromidShift(int fromidShift) {
		this.fromidShift = fromidShift;
	}

	public Date getDatechange() {
		return datechange;
	}

	public void setDatechange(Date datechange) {
		this.datechange = datechange;
	}

	public int getToidemp() {
		return toidemp;
	}

	public void setToidemp(int toidemp) {
		this.toidemp = toidemp;
	}

	public int getToidShift() {
		return toidShift;
	}

	public void setToidShift(int toidShift) {
		this.toidShift = toidShift;
	}

	public int getSendrequesttoadmin() {
		return sendrequesttoadmin;
	}

	public void setSendrequesttoadmin(int sendrequesttoadmin) {
		this.sendrequesttoadmin = sendrequesttoadmin;
	}

	public int getSttrequestchangeShift() {
		return sttrequestchangeShift;
	}

	public void setSttrequestchangeShift(int sttrequestchangeShift) {
		this.sttrequestchangeShift = sttrequestchangeShift;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	@Override
	public String toString() {
		return "RequestchangeShift [idrqcShift=" + idrqcShift + ", fromidemp=" + fromidemp + ", fromidShift="
				+ fromidShift + ", datechange=" + datechange + ", toidemp=" + toidemp + ", toidShift=" + toidShift
				+ ", sendrequesttoadmin=" + sendrequesttoadmin + ", sttrequestchangeShift=" + sttrequestchangeShift
				+ "]";
	}

}
