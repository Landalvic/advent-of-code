package commun;

import java.util.Arrays;
import java.util.List;

public enum Direction {

	HAUT("^"), GAUCHE("<"), DROITE(">"), BAS("v"), HAUT_GAUCHE("F"), HAUT_DROITE("7"), BAS_GAUCHE("L"), BAS_DROITE("J");

	private String affichage;

	private Direction(String affichage) {
		this.affichage = affichage;
	}

	public String getAffichage() {
		return affichage;
	}

	public static List<Direction> listeAxes() {
		return Arrays.asList(HAUT, BAS, GAUCHE, DROITE);
	}

	public static List<Direction> listeDiagonales() {
		return Arrays.asList(HAUT_GAUCHE, BAS_GAUCHE, HAUT_DROITE, BAS_DROITE);
	}

	public static List<Direction> liste8Directions() {
		return Arrays.asList(HAUT, BAS, GAUCHE, DROITE, HAUT_GAUCHE, BAS_GAUCHE, HAUT_DROITE, BAS_DROITE);
	}

	public Direction tourner(boolean gauche) {
		return gauche ? tournerGauche() : tournerDroite();
	}

	public Direction tournerDroite() {
		switch (this) {
		case HAUT:
			return DROITE;
		case GAUCHE:
			return HAUT;
		case BAS:
			return GAUCHE;
		case DROITE:
			return BAS;
		case HAUT_GAUCHE:
			return HAUT_DROITE;
		case HAUT_DROITE:
			return HAUT_GAUCHE;
		case BAS_GAUCHE:
			return HAUT_GAUCHE;
		case BAS_DROITE:
			return BAS_GAUCHE;
		default:
			return null;
		}
	}

	public Direction tournerGauche() {
		switch (this) {
		case HAUT:
			return GAUCHE;
		case GAUCHE:
			return BAS;
		case BAS:
			return DROITE;
		case DROITE:
			return HAUT;
		case HAUT_GAUCHE:
			return BAS_GAUCHE;
		case HAUT_DROITE:
			return HAUT_GAUCHE;
		case BAS_GAUCHE:
			return BAS_DROITE;
		case BAS_DROITE:
			return HAUT_DROITE;
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
		case HAUT_GAUCHE:
			return BAS_DROITE;
		case HAUT_DROITE:
			return BAS_GAUCHE;
		case BAS_GAUCHE:
			return HAUT_DROITE;
		case BAS_DROITE:
			return HAUT_GAUCHE;
		default:
			return null;
		}
	}

}
