package commun;

import java.util.Arrays;

public class Position {

	private double[] coordonnees;

	public Position() {
		super();
	}

	public Position(double... coordonnees) {
		super();
		this.coordonnees = coordonnees;
	}

	public Position(int... coordonnees) {
		super();
		this.coordonnees = Arrays.stream(coordonnees).mapToDouble(i -> i).toArray();
	}

	public Position(Position position) {
		super();
		coordonnees = position.coordonnees.clone();
	}

	public Position voisin(Direction direction) {
		var p = new Position(Arrays.copyOf(coordonnees, coordonnees.length));
		p.bouger(direction);
		return p;
	}

	public void bouger(Direction direction) {
		bouger(direction, 1);
	}

	public void bouger(Direction direction, int distance) {
		switch (direction) {
			case HAUT:
				coordonnees[1] += -distance;
				break;
			case BAS:
				coordonnees[1] += distance;
				break;
			case GAUCHE:
				coordonnees[0] += -distance;
				break;
			case DROITE:
				coordonnees[0] += distance;
				break;
			case HAUT_GAUCHE:
				coordonnees[1] += -distance;
				coordonnees[0] += -distance;
				break;
			case BAS_GAUCHE:
				coordonnees[1] += distance;
				coordonnees[0] += -distance;
				break;
			case HAUT_DROITE:
				coordonnees[1] += -distance;
				coordonnees[0] += distance;
				break;
			case BAS_DROITE:
				coordonnees[1] += distance;
				coordonnees[0] += distance;
				break;
		}
	}

	public void ajouter(Position position) {
		for (int i = 0; i < coordonnees.length; i++) {
			coordonnees[i] += position.coordonnees[i];
		}
	}

	public double distanceFromCenter() {
		return distance(new Position(0, 0));
	}

	public double distance(Position position) {
		double distance = 0;
		for (int i = 0; i < coordonnees.length; i++) {
			distance += Math.abs(coordonnees[i] - position.coordonnees[i]);
		}
		return distance;
	}

	public double getT() {
		return coordonnees[3];
	}

	public void setT(double t) {
		coordonnees[3] = t;
	}

	public void addT(double dt) {
		coordonnees[3] += dt;
	}

	public double getX() {
		return coordonnees[0];
	}

	public void setX(double x) {
		coordonnees[0] = x;
	}

	public void addX(double dx) {
		coordonnees[0] += dx;
	}

	public double getY() {
		return coordonnees[1];
	}

	public void setY(double y) {
		coordonnees[1] = y;
	}

	public void addY(double dy) {
		coordonnees[1] += dy;
	}

	public double getZ() {
		return coordonnees[2];
	}

	public void setZ(double z) {
		coordonnees[2] = z;
	}

	public void addZ(double dz) {
		coordonnees[2] += dz;
	}

	public double[] getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(double[] coordonnees) {
		this.coordonnees = coordonnees;
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(coordonnees);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Position other = (Position) obj;
		return Arrays.equals(coordonnees, other.coordonnees);
	}

	@Override
	public String toString() {
		return "Position [coordonnees=" + Arrays.toString(coordonnees) + "]";
	}

}
