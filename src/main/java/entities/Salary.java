package entities;

import java.util.Date;

public class Salary {
	private int idemp;
	private int month;
	private int standardday;
	private double numberAl;
	private double numberUL;
	private double numberSL;
	private double workingHL;
	private double workingoffday;
	private double workingday;
	private int totalworkfullday;
	private int totalshift3;
	private int totalshift4;
	private double totalOTonday;
	private double totalOToffday;
	private double totalOTHLday;
	private double totalOToffHL;
	private long mealallowance;
	private long nightshiftallowance;
	private long basicsalary;
	private long OTondaysalary;
	private long OToffdaysalary;
	private long OTHLsalary ;
	private long OToffHLsalary;
	private long OTsalary;
	private long totalsalary;
	private long salarydeduction;
	private long insurance;
	private long income;
	private Date  payday;
	
	
	
	
	
	public Salary(int idemp, int month, long basicsalary, long income) {
		super();
		this.idemp = idemp;
		this.month = month;
		this.basicsalary = basicsalary;
		this.income = income;
	}

	public Salary() {
		super();
	}
	
	public Salary(int idemp, int month, int standardday, double numberAl, double numberUL, double numberSL,
			double workingHL, double workingoffday, double workingday, int totalworkfullday, int totalshift3,
			int totalshift4, double totalOTonday, double totalOToffday, double totalOTHLday, double totalOToffHL,
			long mealallowance, long nightshiftallowance, long basicsalary, long oTondaysalary, long oToffdaysalary,
			long oTHLsalary, long oToffHLsalary, long oTsalary, long totalsalary, long salarydeduction, long insurance,
			long income, Date payday) {
		super();
		this.idemp = idemp;
		this.month = month;
		this.standardday = standardday;
		this.numberAl = numberAl;
		this.numberUL = numberUL;
		this.numberSL = numberSL;
		this.workingHL = workingHL;
		this.workingoffday = workingoffday;
		this.workingday = workingday;
		this.totalworkfullday = totalworkfullday;
		this.totalshift3 = totalshift3;
		this.totalshift4 = totalshift4;
		this.totalOTonday = totalOTonday;
		this.totalOToffday = totalOToffday;
		this.totalOTHLday = totalOTHLday;
		this.totalOToffHL = totalOToffHL;
		this.mealallowance = mealallowance;
		this.nightshiftallowance = nightshiftallowance;
		this.basicsalary = basicsalary;
		this.OTondaysalary = oTondaysalary;
		this.OToffdaysalary = oToffdaysalary;
		this.OTHLsalary = oTHLsalary;
		this.OToffHLsalary = oToffHLsalary;
		this.OTsalary = oTsalary;
		this.totalsalary = totalsalary;
		this.salarydeduction = salarydeduction;
		this.insurance = insurance;
		this.income = income;
		this.payday = payday;
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
	public int getStandardday() {
		return standardday;
	}
	public void setStandardday(int standardday) {
		this.standardday = standardday;
	}
	public double getNumberAl() {
		return numberAl;
	}
	public void setNumberAl(double numberAl) {
		this.numberAl = numberAl;
	}
	public double getNumberUL() {
		return numberUL;
	}
	public void setNumberUL(double numberUL) {
		this.numberUL = numberUL;
	}
	public double getNumberSL() {
		return numberSL;
	}
	public void setNumberSL(double numberSL) {
		this.numberSL = numberSL;
	}
	public double getWorkingHL() {
		return workingHL;
	}
	public double getTotalOTHLday() {
		return totalOTHLday;
	}

	public void setTotalOTHLday(double totalOTHLday) {
		this.totalOTHLday = totalOTHLday;
	}

	public double getTotalOToffHL() {
		return totalOToffHL;
	}

	public void setTotalOToffHL(double totalOToffHL) {
		this.totalOToffHL = totalOToffHL;
	}

	public long getOTondaysalary() {
		return OTondaysalary;
	}

	public void setOTondaysalary(long oTondaysalary) {
		OTondaysalary = oTondaysalary;
	}

	public long getOToffdaysalary() {
		return OToffdaysalary;
	}

	public void setOToffdaysalary(long oToffdaysalary) {
		OToffdaysalary = oToffdaysalary;
	}

	public long getOTHLsalary() {
		return OTHLsalary;
	}

	public void setOTHLsalary(long oTHLsalary) {
		OTHLsalary = oTHLsalary;
	}

	public long getOToffHLsalary() {
		return OToffHLsalary;
	}

	public void setOToffHLsalary(long oToffHLsalary) {
		OToffHLsalary = oToffHLsalary;
	}

	public void setOTsalary(long oTsalary) {
		OTsalary = oTsalary;
	}

	public void setWorkingHL(double workingHL) {
		this.workingHL = workingHL;
	}
	public double getWorkingoffday() {
		return workingoffday;
	}
	public void setWorkingoffday(double workingoffday) {
		this.workingoffday = workingoffday;
	}
	public double getWorkingday() {
		return workingday;
	}
	public void setWorkingday(double workingday) {
		this.workingday = workingday;
	}
	public int getTotalworkfullday() {
		return totalworkfullday;
	}
	public void setTotalworkfullday(int totalworkfullday) {
		this.totalworkfullday = totalworkfullday;
	}
	public int getTotalshift3() {
		return totalshift3;
	}
	public void setTotalshift3(int totalshift3) {
		this.totalshift3 = totalshift3;
	}
	public int getTotalshift4() {
		return totalshift4;
	}
	public void setTotalshift4(int totalshift4) {
		this.totalshift4 = totalshift4;
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
	public long getMealallowance() {
		return mealallowance;
	}
	public void setMealallowance(long mealallowance) {
		this.mealallowance = mealallowance;
	}
	public long getNightshiftallowance() {
		return nightshiftallowance;
	}
	public void setNightshiftallowance(long nightshiftallowance) {
		this.nightshiftallowance = nightshiftallowance;
	}
	public long getBasicsalary() {
		return basicsalary;
	}
	public void setBasicsalary(long basicsalary) {
		this.basicsalary = basicsalary;
	}
	public long getOTsalary() {
		return OTsalary;
	}
	public void setOTsalary(int oTsalary) {
		OTsalary = oTsalary;
	}
	public long getTotalsalary() {
		return totalsalary;
	}
	public void setTotalsalary(long totalsalary) {
		this.totalsalary = totalsalary;
	}
	public long getSalarydeduction() {
		return salarydeduction;
	}
	public void setSalarydeduction(long salarydeduction) {
		this.salarydeduction = salarydeduction;
	}
	public long getInsurance() {
		return insurance;
	}
	public void setInsurance(long insurance) {
		this.insurance = insurance;
	}
	public long getIncome() {
		return income;
	}
	public void setIncome(long income) {
		this.income = income;
	}
	public Date getPayday() {
		return payday;
	}
	public void setPayday(Date payday) {
		this.payday = payday;
	}
	@Override
	public String toString() {
		return "Salary [idemp=" + idemp + ", month=" + month + ", standardday=" + standardday + ", numberAl=" + numberAl
				+ ", numberUL=" + numberUL + ", numberSL=" + numberSL + ", workingHL=" + workingHL + ", workingoffday="
				+ workingoffday + ", workingday=" + workingday + ", totalworkfullday=" + totalworkfullday
				+ ", totalshift3=" + totalshift3 + ", totalshift4=" + totalshift4 + ", totalOTonday=" + totalOTonday
				+ ", totalOToffday=" + totalOToffday + ", mealallowance=" + mealallowance + ", nightshiftallowance="
				+ nightshiftallowance + ", basicsalary=" + basicsalary + ", OTsalary=" + OTsalary + ", totalsalary=" + totalsalary + ", salarydeduction=" + salarydeduction
				+ ", insurance=" + insurance + ", income=" + income + ", payday=" + payday + "]";
	}

	
	
	
}
