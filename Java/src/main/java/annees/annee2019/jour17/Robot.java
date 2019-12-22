package annees.annee2019.jour17;

public class Robot {

	private int x;
	private int y;
	private Direction direction;
	private Case position;

	public Robot(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		direction = Direction.HAUT;
	}

	public Case getPosition() {
		return position;
	}

	public void setPosition(Case position) {
		this.position = position;
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

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Robot [x=" + x + ", y=" + y + ", direction=" + direction + ", position=" + position + "]";
	}

}
