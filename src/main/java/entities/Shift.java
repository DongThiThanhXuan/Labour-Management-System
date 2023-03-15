package entities;

import java.time.LocalTime;

public class Shift {
	private int idShift;
	private LocalTime timein;
	private LocalTime timeout;

	
	
	public Shift() {
		super();
	}

	public Shift(int idShift, LocalTime timein, LocalTime timeout) {
		super();
		this.idShift = idShift;
		this.timein = timein;
		this.timeout = timeout;
	}

	public int getIdShift() {
		return idShift;
	}

	public void setIdShift(int idShift) {
		this.idShift = idShift;
	}

	public LocalTime getTimein() {
		return timein;
	}

	public void setTimein(LocalTime timein) {
		this.timein = timein;
	}

	public LocalTime getTimeout() {
		return timeout;
	}

	public void setTimeout(LocalTime timeout) {
		this.timeout = timeout;
	}

	@Override
	public String toString() {
		return "Shift " + idShift + ", " + timein + ", " + timeout ;
	}

	
}

