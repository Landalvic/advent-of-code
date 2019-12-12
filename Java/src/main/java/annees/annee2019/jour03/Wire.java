package annees.annee2019.jour03;

public class Wire {

	private int x;
	private int y;
	private int xArrivee;
	private int yArrivee;
	boolean horizontal = false;
	boolean collision = false;
	private boolean wire = false;
	private int xCollision;
	private int yCollision;
	private int distance;
	private int distanceCollision1;
	private int distanceCollision2;

	public Wire(int x, int y, int xA, int yA, boolean horizontal, int distance) {
		super();
		this.x = x;
		this.y = y;
		this.xArrivee = xA;
		this.yArrivee = yA;
		this.horizontal = horizontal;
		this.distance = longueur() + distance;
	}

	public void collision(Wire wire) {
		if (!collision) {
			if (wire.horizontal && !horizontal) {
				if ((wire.y > y && wire.y < yArrivee || wire.y < y && wire.y > yArrivee)
						&& (wire.x < x && wire.xArrivee > x || wire.x > x && wire.xArrivee < x)) {
					collision = true;
					xCollision = x;
					yCollision = wire.y;
					distanceCollision1 = distance - longueur() + Math.abs(x - xCollision) + Math.abs(y - yCollision);
					distanceCollision2 = wire.distance - wire.longueur() + Math.abs(wire.x - xCollision) + Math.abs(wire.y - yCollision);
				}
			} else if (!wire.horizontal && horizontal) {
				if ((wire.x > x && wire.x < xArrivee || wire.x < x && wire.x > xArrivee)
						&& (wire.y < y && wire.yArrivee > y || wire.y > y && wire.yArrivee < y)) {
					collision = true;
					xCollision = wire.x;
					yCollision = y;
					distanceCollision1 = distance - longueur() + Math.abs(x - xCollision) + Math.abs(y - yCollision);
					distanceCollision2 = wire.distance - wire.longueur() + Math.abs(wire.x - xCollision) + Math.abs(wire.y - yCollision);
				}
			}
		}
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDistanceCollision1() {
		return distanceCollision1;
	}

	public void setDistanceCollision1(int distanceCollision1) {
		this.distanceCollision1 = distanceCollision1;
	}

	public int getDistanceCollision2() {
		return distanceCollision2;
	}

	public void setDistanceCollision2(int distanceCollision2) {
		this.distanceCollision2 = distanceCollision2;
	}

	public int distanceCollision() {
		return Math.abs(xCollision) + Math.abs(yCollision);
	}

	public int longueur() {
		return Math.abs(x - xArrivee) + Math.abs(y - yArrivee);
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	public boolean isCollision() {
		return collision;
	}

	public void setCollision(boolean collision) {
		this.collision = collision;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getxArrivee() {
		return xArrivee;
	}

	public void setxArrivee(int xArrivee) {
		this.xArrivee = xArrivee;
	}

	public int getyArrivee() {
		return yArrivee;
	}

	public void setyArrivee(int yArrivee) {
		this.yArrivee = yArrivee;
	}

	public boolean isWire() {
		return wire;
	}

	public void setWire(boolean wire) {
		this.wire = wire;
	}

	public int getxCollision() {
		return xCollision;
	}

	public void setxCollision(int xCollision) {
		this.xCollision = xCollision;
	}

	public int getyCollision() {
		return yCollision;
	}

	public void setyCollision(int yCollision) {
		this.yCollision = yCollision;
	}

}
