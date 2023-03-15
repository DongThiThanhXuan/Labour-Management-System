package entities;

public class Typeaccount {
	private String typeid;
	private String typename;

	public Typeaccount() {
	}

	public Typeaccount(String typeid, String typename) {
		this.typeid = typeid;
		this.typename = typename;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@Override
	public String toString() {
		return typename;
	}

	
}
