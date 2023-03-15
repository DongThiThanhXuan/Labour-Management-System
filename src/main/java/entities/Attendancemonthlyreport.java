package entities;

public class Attendancemonthlyreport {
	private int idemp;
	private int month;
	private double totaltimekeeping;
	private double totalworkHL;
	private double totalworkoffday;
	private double totalshift3;
	private double totalshift4;
	private double totalworkfullday;
	private double totalOTonday;
	private double totalOToffday;
	private double totalOTHL;
	private double totalOToffHL;
	private int validreason1;
	private int validreason2;
	private long totalsalarydeduction;
	
	
	
	public Attendancemonthlyreport() {
	}
	


	public Attendancemonthlyreport(int idemp, int month, double totaltimekeeping, double totalworkHL,
			double totalworkoffday, double totalshift3, double totalshift4, double totalworkfullday,
			double totalOTonday, double totalOToffday, double totalOTHL, double totalOToffHL, int validreason1,
			int validreason2, long totalsalarydeduction) {
		super();
		this.idemp = idemp;
		this.month = month;
		this.totaltimekeeping = totaltimekeeping;
		this.totalworkHL = totalworkHL;
		this.totalworkoffday = totalworkoffday;
		this.totalshift3 = totalshift3;
		this.totalshift4 = totalshift4;
		this.totalworkfullday = totalworkfullday;
		this.totalOTonday = totalOTonday;
		this.totalOToffday = totalOToffday;
		this.totalOTHL = totalOTHL;
		this.totalOToffHL = totalOToffHL;
		this.validreason1 = validreason1;
		this.validreason2 = validreason2;
		this.totalsalarydeduction = totalsalarydeduction;
	}



	public int getIdemp() {
		return idemp;
	}

	public void setIdemp(int idemp) {
		this.idemp = idemp;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public double getTotaltimekeeping() {
		return totaltimekeeping;
	}

	public void setTotaltimekeeping(double totaltimekeeping) {
		this.totaltimekeeping = totaltimekeeping;
	}

	public double getTotalworkHL() {
		return totalworkHL;
	}

	public void setTotalworkHL(double totalworkHL) {
		this.totalworkHL = totalworkHL;
	}

	public double getTotalworkoffday() {
		return totalworkoffday;
	}

	public void setTotalworkoffday(double totalworkoffday) {
		this.totalworkoffday = totalworkoffday;
	}

	public double getTotalshift3() {
		return totalshift3;
	}

	public void setTotalshift3(double totalshift3) {
		this.totalshift3 = totalshift3;
	}

	public double getTotalshift4() {
		return totalshift4;
	}

	public void setTotalshift4(double totalshift4) {
		this.totalshift4 = totalshift4;
	}

	public double getTotalworkfullday() {
		return totalworkfullday;
	}

	public void setTotalworkfullday(double totalworkfullday) {
		this.totalworkfullday = totalworkfullday;
	}

	public double getTotalOTonday() {
		return totalOTonday;
	}

	public void setTotalOTonday(double totalOTonday) {
		this.totalOTonday = totalOTonday;
	}

	public double getTotalOToffday() {
		return totalOToffday;
	}

	public void setTotalOToffday(double totalOToffday) {
		this.totalOToffday = totalOToffday;
	}

	public double getTotalOTHL() {
		return totalOTHL;
	}



	public void setTotalOTHL(double totalOTHL) {
		this.totalOTHL = totalOTHL;
	}



	public double getTotalOToffHL() {
		return totalOToffHL;
	}



	public void setTotalOToffHL(double totalOToffHL) {
		this.totalOToffHL = totalOToffHL;
	}



	public int getValidreason1() {
		return validreason1;
	}

	public void setValidreason1(int validreason1) {
		this.validreason1 = validreason1;
	}

	public int getValidreason2() {
		return validreason2;
	}

	public void setValidreason2(int validreason2) {
		this.validreason2 = validreason2;
	}

	public long getTotalsalarydeduction() {
		return totalsalarydeduction;
	}

	public void setTotalsalarydeduction(long totalsalarydeduction) {
		this.totalsalarydeduction = totalsalarydeduction;
	}

	@Override
	public String toString() {
		return "Attendancemonthlyreport [idemp=" + idemp + ", month=" + month + ", totaltimekeeping=" + totaltimekeeping
				+ ", totalworkHL=" + totalworkHL + ", totalworkoffday=" + totalworkoffday + ", totalshift3="
				+ totalshift3 + ", totalshift4=" + totalshift4 + ", totalworkfullday=" + totalworkfullday
				+ ", totalOTonday=" + totalOTonday + ", totalOToffday=" + totalOToffday + ", validreason1="
				+ validreason1 + ", validreason2=" + validreason2 + ", totalsalarydeduction=" + totalsalarydeduction
				+ "]";
	}

	
	
}
