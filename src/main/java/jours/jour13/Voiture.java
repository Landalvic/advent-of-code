package jours.jour13;

public class Voiture implements Comparable<Voiture> {

	private int positionX;
	private int positionY;
	private Direction direction;
	private Direction intersection;

	public Voiture(int positionX, int positionY, Direction direction) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.direction = direction;
		intersection = Direction.GAUCHE;
	}

	public Direction reagirIntersection() {
		Direction retour = intersection;
		switch (intersection) {
		case GAUCHE:
			intersection = Direction.HAUT;
			direction = Direction.tournerAGauche(direction);
			break;
		case HAUT:
			intersection = Direction.DROITE;
			break;
		case DROITE:
			intersection = Direction.GAUCHE;
			direction = Direction.tournerADroite(direction);
			break;
		default:
			break;
		}
		return retour;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	@Override
	public int compareTo(Voiture o) {
		int compareY = Integer.compare(positionY, o.positionY);
		if (compareY == 0) {
			return Integer.compare(positionX, o.positionX);
		} else {
			return compareY;
		}
	}

}
