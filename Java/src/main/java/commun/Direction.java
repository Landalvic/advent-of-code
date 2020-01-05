package commun;

public enum Direction {

	HAUT("^"), GAUCHE("<"), DROITE(">"), BAS("v");

	private String affichage;

	private Direction(String affichage) {
		this.affichage = affichage;
	}

	public String getAffichage() {
		return affichage;
	}

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
		default:
			return null;
		}
	}

	public Direction seRetourner() {
		switch (this) {
		case HAUT:
			return BAS;
		case GAUCHE:
			return DROITE;
		case BAS:
			return HAUT;
		case DROITE:
			return GAUCHE;
		default:
			return null;
		}
	}

}
