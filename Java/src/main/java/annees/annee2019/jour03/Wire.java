package annees.annee2019.jour03;

import commun.Position;
import commun.Vecteur;

public class Wire extends Vecteur {

	private double distance;

	public Wire(Position positionDepart, Position positionArrivee, double distance) {
		super(positionDepart, positionArrivee);
		this.distance = distance;
	}

	public Wire(double xDepart, double yDepart, double xArrivee, double yArrivee, double distance) {
		super(xDepart, yDepart, xArrivee, yArrivee);
		this.distance = distance;
	}

	public double calculDistance(Position intersect) {
		var vecteur = new Vecteur(getPositionDepart(), intersect);
		return distance + vecteur.longueur();
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Wire other = (Wire) obj;
		return Double.doubleToLongBits(distance) == Double.doubleToLongBits(other.distance);
	}

}
