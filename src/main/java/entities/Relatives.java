package entities;

public class Relatives {
	private int idemp;
	private String fullname;
	private String relationship ;
	private String phone;
	
	
	public Relatives() {
		super();
	}


	public Relatives(int idemp, String fullname, String relationship, String phone) {
		super();
		this.idemp = idemp;
		this.fullname = fullname;
		this.relationship = relationship;
		this.phone = phone;
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


	public String getRelationship() {
		return relationship;
	}


	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Relatives [idemp=" + idemp + ", fullname=" + fullname + ", relationship=" + relationship + ", phone="
				+ phone + "]";
	}

	
	
}
