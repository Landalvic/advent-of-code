package commun;

import java.awt.geom.Line2D;
import java.util.Objects;

public class Vecteur {

	private Position positionDepart;
	private Position positionArrivee;

	public Vecteur(Position positionDepart, Position positionArrivee) {
		super();
		this.positionDepart = positionDepart;
		this.positionArrivee = positionArrivee;
	}

	public Vecteur(double xDepart, double yDepart, double xArrivee, double yArrivee) {
		super();
		positionDepart = new Position(xDepart, yDepart);
		positionArrivee = new Position(xArrivee, yArrivee);
	}

	public Position pointOfIntersectionLine(Vecteur vecteur) {
		double a1 = positionArrivee.getY() - positionDepart.getY();
		double b1 = positionDepart.getX() - positionArrivee.getX();
		double c1 = a1 * (positionDepart.getX()) + b1 * (positionDepart.getY());
		double a2 = vecteur.positionArrivee.getY() - vecteur.positionDepart.getY();
		double b2 = vecteur.positionDepart.getX() - vecteur.positionArrivee.getX();
		double c2 = a2 * (vecteur.positionDepart.getX()) + b2 * (vecteur.positionDepart.getY());
		double determinant = a1 * b2 - a2 * b1;
		if (determinant == 0) {
			return null;
		} else {
			double x = (b2 * c1 - b1 * c2) / determinant;
			double y = (a1 * c2 - a2 * c1) / determinant;
			return new Position(x, y);
		}
	}

	public Position pointOfIntersectionSegmentWithoutLimit(Vecteur vecteur) {
		if (intersectionSegmentWithoutBord(vecteur)) {
			return pointOfIntersectionLine(vecteur);
		} else {
			return null;
		}
	}

	public Position pointOfIntersectionSegmentWithLimit(Vecteur vecteur) {
		if (intersectionSegmentWithBord(vecteur)) {
			return pointOfIntersectionLine(vecteur);
		} else {
			return null;
		}
	}

	public boolean intersectionSegmentWithoutBord(Vecteur vecteur) {
		if (Objects.equals(positionDepart, vecteur.positionDepart) || Objects.equals(positionDepart, vecteur.positionArrivee)
				|| Objects.equals(positionArrivee, vecteur.positionDepart) || Objects.equals(positionArrivee, vecteur.positionArrivee)) {
			return false;
		} else {
			return intersectionSegmentWithBord(vecteur);
		}
	}

	public boolean intersectionSegmentWithBord(Vecteur vecteur) {
		int o1 = orientation(vecteur.positionDepart);
		int o2 = orientation(vecteur.positionArrivee);
		int o3 = vecteur.orientation(positionDepart);
		int o4 = vecteur.orientation(positionArrivee);
		if (o1 != o2 && o3 != o4) {
			return true;
		}
		if (o1 == 0 && onSegment(vecteur.positionDepart)) {
			return true;
		}
		if (o2 == 0 && onSegment(vecteur.positionArrivee)) {
			return true;
		}
		if (o3 == 0 && vecteur.onSegment(positionDepart)) {
			return true;
		}
		return o4 == 0 && vecteur.onSegment(positionArrivee);
	}

	public boolean intersectionLine(Vecteur vecteur) {
		return Line2D.linesIntersect(positionDepart.getX(), positionDepart.getY(), positionArrivee.getX(), positionArrivee.getY(), vecteur.positionDepart
				.getX(), vecteur.positionDepart.getY(), vecteur.positionArrivee.getX(), vecteur.positionArrivee.getY());
	}

	public boolean onSegment(Position position) {
		return position.getX() <= Math.max(positionDepart.getX(), positionArrivee.getX())
				&& position.getX() >= Math.min(positionDepart.getX(), positionArrivee.getX())
				&& position.getY() <= Math.max(positionDepart.getY(), positionArrivee.getY())
				&& position.getY() >= Math.min(positionDepart.getY(), positionArrivee.getY());
	}

	public int orientation(Position position) {
		double val = (position.getY() - positionDepart.getY()) * (positionArrivee.getX() - position.getX())
				- (position.getX() - positionDepart.getX()) * (positionArrivee.getY() - position.getY());
		if (val == 0) {
			return 0;
		} else if (val > 0) {
			return 1;
		} else {
			return -1;
		}
	}

	public double longueur() {
		return positionDepart.distance(positionArrivee);
	}

	public Position getPositionDepart() {
		return positionDepart;
	}

	public void setPositionDepart(Position positionDepart) {
		this.positionDepart = positionDepart;
	}

	public Position getPositionArrivee() {
		return positionArrivee;
	}

	public void setPositionArrivee(Position positionArrivee) {
		this.positionArrivee = positionArrivee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(positionDepart, positionArrivee);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Vecteur other = (Vecteur) obj;
		return Objects.equals(positionDepart, other.positionDepart) && Objects.equals(positionArrivee, other.positionArrivee);
	}

	@Override
	public String toString() {
		return "Vecteur [positionDepart=" + positionDepart + ", positionArrivee=" + positionArrivee + "]";
	}

}
