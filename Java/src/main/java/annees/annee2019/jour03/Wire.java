package annees.annee2019.jour03;

import commun.Position;
import commun.Vecteur;

public class Wire extends Vecteur {

	private double distanceDepuisDebut;

	public Wire(Position positionDepart, Position positionArrivee, double distanceDepuisDebut) {
		super(positionDepart, positionArrivee);
		this.distanceDepuisDebut = distanceDepuisDebut;
	}

	public Wire(double xDepart, double yDepart, double xArrivee, double yArrivee, double distanceDepuisDebut) {
		super(xDepart, yDepart, xArrivee, yArrivee);
		this.distanceDepuisDebut = distanceDepuisDebut;
	}

	public double calculDistance(Position intersect) {
		var vecteur = new Vecteur(getPositionDepart(), intersect);
		return distanceDepuisDebut + vecteur.longueur();
	}

	public double getDistanceDepuisDebut() {
		return distanceDepuisDebut;
	}

	public void setDistanceDepuisDebut(double distanceDepuisDebut) {
		this.distanceDepuisDebut = distanceDepuisDebut;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(distanceDepuisDebut);
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
		return Double.doubleToLongBits(distanceDepuisDebut) == Double.doubleToLongBits(other.distanceDepuisDebut);
	}

}
