package annees.annee2020.jour11;

import java.util.ArrayList;
import java.util.List;

import commun.Case;
import commun.Direction;
import commun.Map;
import commun.Position;

public class Siege extends Case {

	private Boolean occupe;
	private Boolean futurePlace;

	public Siege(Map<? extends Case> map, Position position, Boolean occupe) {
		super(map, position);
		this.occupe = occupe;
	}

	public List<Siege> getSiegesVus() {
		List<Siege> sieges = new ArrayList<>();
		for (Direction direction : Direction.liste8Directions()) {
			Siege c = (Siege) bouger(direction);
			while (c != null && c.getOccupe() == null) {
				c = (Siege) c.bouger(direction);
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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((occupe == null) ? 0 : occupe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Siege other = (Siege) obj;
		if (occupe == null) {
			if (other.occupe != null)
				return false;
		} else if (!occupe.equals(other.occupe))
			return false;
		return true;
	}

}
