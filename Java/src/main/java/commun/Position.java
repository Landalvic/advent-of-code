package commun;

public class Position {

	private double x;
	private double y;
	private double z;

	public Position() {
		super();
	}

	public Position(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Position(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Position(Position position) {
		super();
		x = position.x;
		y = position.y;
		z = position.z;
	}

	public void bouger(Direction direction) {
		switch (direction) {
		case HAUT:
			y += -1;
			break;
		case BAS:
			y += 1;
			break;
		case GAUCHE:
			x += -1;
			break;
		case DROITE:
			x += 1;
			break;
		}
	}

	public void ajouter(Position position) {
		x += position.x;
		y += position.y;
		z += position.z;
	}

	public double distanceFromCenter() {
		return distance(new Position(0, 0));
	}

	public double distance(Position position) {
		return Math.abs(x - position.x) + Math.abs(y - position.y) + Math.abs(z - position.z);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void addX(double dx) {
		x += dx;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void addY(double dy) {
		y += dy;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public void addZ(double dz) {
		z += dz;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Position other = (Position) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
			return false;
		}
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
			return false;
		}
		return Double.doubleToLongBits(z) == Double.doubleToLongBits(other.z);
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

}
