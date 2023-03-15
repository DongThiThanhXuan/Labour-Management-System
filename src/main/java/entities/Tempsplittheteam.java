package entities;

public class Tempsplittheteam {
	private int idemp;
	private int idteam;

	public Tempsplittheteam(int idemp, int idteam) {
		super();
		this.idemp = idemp;
		this.idteam = idteam;
	}

	public int getIdemp() {
		return idemp;
	}

	public void setIdemp(int idemp) {
		this.idemp = idemp;
	}

	public int getIdteam() {
		return idteam;
	}

	public void setIdteam(int idteam) {
		this.idteam = idteam;
	}

	@Override
	public String toString() {
		return "Tempsplittheteam [idemp=" + idemp + ", idteam=" + idteam + "]";
	}
}
