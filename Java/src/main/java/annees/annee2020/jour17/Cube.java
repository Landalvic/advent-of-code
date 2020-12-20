package annees.annee2020.jour17;

import commun.Case;
import commun.MapCases;
import commun.Position;

public class Cube extends Case<Cube> {

	public Cube(MapCases<Cube> map, Position position, boolean actif) {
		super(map, position);
		this.actif = actif;
	}

	private boolean actif;
	private boolean futureActif;

	public boolean getFutureActif() {
		return futureActif;
	}

	public void setFutureActif(boolean futureActif) {
		this.futureActif = futureActif;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	@Override
	public Cube getThis() {
		return this;
	}

	@Override
	public String toString() {
		return "Cube [actif=" + actif + "-" + getPosition() + "]";
	}

}
