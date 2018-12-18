package jours.jour13;

public enum Direction {

	HAUT,
	GAUCHE,
	BAS,
	DROITE;

	public static Direction tournerAGauche(Direction direction) {
		switch (direction) {
		case HAUT:
			return Direction.GAUCHE;
		case GAUCHE:
			return Direction.BAS;
		case BAS:
			return Direction.DROITE;
		case DROITE:
			return Direction.HAUT;
		}
		return null;
	}

	public static Direction tournerADroite(Direction direction) {
		switch (direction) {
		case HAUT:
			return Direction.DROITE;
		case GAUCHE:
			return Direction.HAUT;
		case BAS:
			return Direction.GAUCHE;
		case DROITE:
			return Direction.BAS;
		}
		return null;
	}

}
