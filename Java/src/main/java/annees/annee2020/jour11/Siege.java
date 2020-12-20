package annees.annee2020.jour11;

import java.util.ArrayList;
import java.util.List;

import commun.Case;
import commun.Direction;
import commun.MapCases;
import commun.Position;

public class Siege extends Case<Siege> {

	private Boolean occupe;
	private Boolean futurePlace;

	public Siege(MapCases<Siege> map, Position position, Boolean occupe) {
		super(map, position);
		this.occupe = occupe;
	}

	public List<Siege> getSiegesEnVus() {
		List<Siege> sieges = new ArrayList<>();
		for (Direction direction : Direction.liste8Directions()) {
			Siege c = bouger(direction);
			while (c != null && c.getOccupe() == null) {
				c = c.bouger(direction);
			}
			if (c != null) {
				sieges.add(c);
			}
		}
		return sieges;
	}

	public Boolean getOccupe() {
		return occupe;
	}

	public void setOccupe(Boolean occupe) {
		this.occupe = occupe;
	}

	public Boolean getFuturePlace() {
		return futurePlace;
	}

	public void setFuturePlace(Boolean futurePlace) {
		this.futurePlace = futurePlace;
	}

	@Override
	public String afficher() {
		if (occupe == null) {
			return ".";
		} else if (occupe.booleanValue()) {
			return "#";
		} else {
			return "L";
		}
	}

	@Override
	public Siege getThis() {
		return this;
	}

}
