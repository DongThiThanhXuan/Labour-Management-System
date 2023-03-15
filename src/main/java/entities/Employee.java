package entities;

import java.util.Date;

public class Employee {
	private int idemp;
	private String fullname;
	private String username;
	private String pass;
	private String typeid;
	private Date dob;
	private String address;
	private String gender;
	private String email;
	private String phone;
	private String iddep;
	private long basicsalary;
	private Date onboarddate;
	private double annualleave;
	private double unpaidleave;
	private double sickleave;
	private int sttemp;

	public Employee() {

	}
	
	
	public Employee(int idemp) {
		super();
		this.idemp = idemp;
	}


	public Employee(int idemp, String fullname, String username, String pass, String typeid, Date dob, String address,
			String gender, String email, String phone, String iddep, long basicsalary, Date onboarddate,
			double annualleave, double unpaidleave, double sickleave, int sttemp) {
		super();
		this.idemp = idemp;
		this.fullname = fullname;
		this.username = username;
		this.pass = pass;
		this.typeid = typeid;
		this.dob = dob;
		this.address = address;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.iddep = iddep;
		this.basicsalary = basicsalary;
		this.onboarddate = onboarddate;
		this.annualleave = annualleave;
		this.unpaidleave = unpaidleave;
		this.sickleave = sickleave;
		this.sttemp = sttemp;
	}


	public Employee(int idemp, String fullname) {
		super();
		this.idemp = idemp;
		this.fullname = fullname;
	}


	public int getIdemp() {
		return idemp;
	}

	public void setIdemp(int idemp) {
		this.idemp = idemp;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIddep() {
		return iddep;
	}

	public void setIddep(String iddep) {
		this.iddep = iddep;
	}

	public long getBasicsalary() {
		return basicsalary;
	}

	public void setBasicsalary(long basicsalary) {
		this.basicsalary = basicsalary;
	}

	public Date getOnboarddate() {
		return onboarddate;
	}

	public void setOnboarddate(Date onboarddate) {
		this.onboarddate = onboarddate;
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

	public int getSttemp() {
		return sttemp;
	}

	public void setSttemp(int sttemp) {
		this.sttemp = sttemp;
	}

	@Override
	public String toString() {
		return "Id: "+idemp+ ", "+ fullname;
	}



	

	
	

}
