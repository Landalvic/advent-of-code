package commun;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Map<T extends Case> {

	private static final int TAILLE_DEFAUT = 100;
	private List<List<T>> cases;
	private int decalageX;
	private int decalageY;
	private int minX;
	private int maxX;
	private int minY;
	private int maxY;
	private int nombreNonNull;

	public Map() {
		this(TAILLE_DEFAUT, TAILLE_DEFAUT);
		decalageX = TAILLE_DEFAUT / 2;
		decalageY = TAILLE_DEFAUT / 2;
		minX = 0;
		maxX = 0;
		minY = 0;
		maxY = 0;
	}

	public Map(int tailleX, int tailleY) {
		super();
		cases = tableauVide(tailleX, tailleY);
		decalageX = 0;
		decalageY = 0;
		minX = 0;
		maxX = tailleX;
		minY = 0;
		maxY = tailleY;
	}

	private List<List<T>> tableauVide(int tailleX, int tailleY) {
		List<List<T>> liste = new ArrayList<>(tailleX);
		for (int i = 0; i < tailleX; i++) {
			List<T> lignes = new ArrayList<>(tailleY);
			for (int j = 0; j < tailleY; j++) {
				lignes.add(null);
			}
			liste.add(lignes);
		}
		return liste;
	}

	public void setCase(T t) {
		nombreNonNull++;
		verifierMinX(t);
		verifierMaxX(t);
		verifierMinY(t);
		verifierMaxY(t);
		cases.get((int) t.getPosition().getX() + decalageX).set((int) t.getPosition().getY() + decalageY, t);
	}

	private void verifierMaxY(T t) {
		if (t.getPosition().getY() > maxY) {
			maxY = (int) t.getPosition().getY();
			if (t.getPosition().getY() + decalageY >= cases.get(0).size()) {
				List<T> ligne = new ArrayList<>(TAILLE_DEFAUT);
				for (int i = 0; i < TAILLE_DEFAUT; i++) {
					ligne.add(null);
				}
				for (List<T> lignes : cases) {
					lignes.addAll(new ArrayList<>(ligne));
				}
			}
		}
	}

	private void verifierMinY(T t) {
		if (t.getPosition().getY() < minY) {
			minY = (int) t.getPosition().getY();
			if (t.getPosition().getY() + decalageY < 0) {
				List<T> ligne = new ArrayList<>(TAILLE_DEFAUT);
				for (int i = 0; i < TAILLE_DEFAUT; i++) {
					ligne.add(null);
				}
				for (List<T> lignes : cases) {
					lignes.addAll(0, new ArrayList<>(ligne));
				}
				decalageY += TAILLE_DEFAUT;
			}
		}
	}

	private void verifierMinX(T t) {
		if (t.getPosition().getX() < minX) {
			minX = (int) t.getPosition().getX();
			if (t.getPosition().getX() + decalageX < 0) {
				cases.addAll(0, tableauVide(TAILLE_DEFAUT, cases.get(0).size()));
				decalageX += TAILLE_DEFAUT;
			}
		}
	}

	private void verifierMaxX(T t) {
		if (t.getPosition().getX() > maxX) {
			maxX = (int) t.getPosition().getX();
			if (t.getPosition().getX() + decalageX >= cases.size()) {
				cases.addAll(tableauVide(TAILLE_DEFAUT, cases.get(0).size()));
			}
		}
	}

	public int getNombreNonNull() {
		return nombreNonNull;
	}

	public T getCase(Position position) {
		return getCase((int) position.getX(), (int) position.getY());
	}

	public T getCase(int x, int y) {
		if (x + decalageX < 0) {
			return null;
		}
		if (x + decalageX >= cases.size()) {
			return null;
		}
		if (y + decalageY < 0) {
			return null;
		}
		if (y + decalageY >= cases.get(0).size()) {
			return null;
		}
		return cases.get(x + decalageX).get(y + decalageY);
	}

	public String dessiner() {
		return dessiner(null, null);
	}

	public String dessiner(Position position, String replacement) {
		var builder = new StringBuilder("\n\n");
		for (int i = minY; i <= maxY; i++) {
			for (int j = minX; j <= maxX; j++) {
				var positionTemp = new Position(j, i);
				if (Objects.equals(position, positionTemp)) {
					builder.append(replacement);
				} else {
					var case1 = getCase(positionTemp);
					if (case1 != null) {
						builder.append(case1.afficher());
					} else {
						builder.append(" ");
					}
				}
			}
			builder.append("\n");
		}
		return builder.toString();
	}

}
