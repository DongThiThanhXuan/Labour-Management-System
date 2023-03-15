package entities;

public class Department {
	private String iddep;
	private String namedep;

	public Department() {

	}

	public Department(String iddep, String namedep) {

		this.iddep = iddep;
		this.namedep = namedep;
	}

	public String getIddep() {
		return iddep;
	}

	public void setIddep(String iddep) {
		this.iddep = iddep;
	}

	public String getNamedep() {
		return namedep;
	}

	public void setNamedep(String namedep) {
		this.namedep = namedep;
	}

	@Override
	public String toString() {
		return  namedep ;
	}

}
