package annees.annee2019.jour11;

public enum Direction {

	HAUT, GAUCHE, DROITE, BAS;

	public Direction tourner(boolean gauche) {
		switch (this) {
		case HAUT:
			if (gauche) {
				return GAUCHE;
			} else {
				return DROITE;
			}
		case GAUCHE:
			if (gauche) {
				return BAS;
			} else {
				return HAUT;
			}
		case BAS:
			if (gauche) {
				return DROITE;
			} else {
				return GAUCHE;
			}
		case DROITE:
			if (gauche) {
				return HAUT;
			} else {
				return BAS;
			}
		}
		return null;
	}

}
