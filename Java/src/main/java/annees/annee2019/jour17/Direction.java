package annees.annee2019.jour17;

public enum Direction {

	HAUT(1L), GAUCHE(3L), DROITE(4L), BAS(2L);

	private Long intCode;

	private Direction(Long intCode) {
		this.intCode = intCode;
	}

	public Long getIntCode() {
		return intCode;
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
		}
		return null;
	}

}
