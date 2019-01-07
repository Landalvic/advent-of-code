package annees.annee2015.jour9;

import java.util.List;

public class Chemin {

	private List<Lieu> lieux;
	private int distance;

	public Chemin(List<Lieu> lieux, int distance) {
		super();
		this.lieux = lieux;
		this.distance = distance;
	}

	public List<Lieu> getLieux() {
		return lieux;
	}

	public void setLieux(List<Lieu> lieux) {
		this.lieux = lieux;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}
