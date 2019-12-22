package annees.annee2019.jour18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Nous implements Comparable<Nous> {

	private Case emplacement;
	private List<Cle> cles;
	private Cle lastKey;
	private int distance;
	private Zone zone;

	public Nous(Case emplacement, List<Cle> cles) {
		super();
		this.emplacement = emplacement;
		this.cles = new ArrayList<Cle>(cles);
		distance = 0;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Cle getLastKey() {
		return lastKey;
	}

	public void setLastKey(Cle lastKey) {
		this.lastKey = lastKey;
	}

	public boolean avoirCle(String porte) {
		if (porte == null) {
			return true;
		} else {
			return cles.stream().filter(cle -> StringUtils.equals(cle.getId(), porte.toLowerCase())).findAny()
					.isPresent();
		}
	}

	public String id() {
		var id = new StringBuilder();
		for (Cle string : cles) {
			id.append(string.getId());
		}
		id.append(lastKey);
		return id.toString();
	}

	public String id2() {
		var id = new StringBuilder();
		for (Cle string : cles) {
			id.append(string);
		}
		return id.toString();
	}

	public Case getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(Case emplacement) {
		this.emplacement = emplacement;
	}

	public void addCle(Cle cle) {
		cles.add(cle);
		Collections.sort(cles);
		lastKey = cle;
	}

	public List<Cle> getCles() {
		return cles;
	}

	public void setCles(List<Cle> cles) {
		this.cles = cles;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(Nous o) {
		return id().compareTo(o.id());
	}

	@Override
	public String toString() {
		return "Nous [cles=" + cles + ", distance=" + distance + "]";
	}

}
