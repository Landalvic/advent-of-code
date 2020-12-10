package commun;

import java.util.ArrayList;
import java.util.List;

public class Case {

	private static final String AFFICHAGE = ".";
	private Position position;
	private Map<? extends Case> map;
	private String value;
	private boolean mur;

	public Case(Map<? extends Case> map, Position position) {
		super();
		this.map = map;
		this.position = position;
		mur = false;
	}

	public Case(Map<? extends Case> map, Position position, String value) {
		super();
		this.map = map;
		this.position = position;
		this.value = value;
		mur = false;
	}

	public boolean isMur() {
		return mur;
	}

	public void setMur(boolean mur) {
		this.mur = mur;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String afficher() {
		return AFFICHAGE;
	}

	public Case bougerOuRester(Direction direction) {
		Case bouger = bouger(direction);
		return bouger == null ? this : bouger;
	}

	public Case bouger(Direction direction) {
		switch (direction) {
		case HAUT:
			return map.getCase((int) position.getX(), (int) position.getY() - 1);
		case BAS:
			return map.getCase((int) position.getX(), (int) position.getY() + 1);
		case GAUCHE:
			return map.getCase((int) position.getX() - 1, (int) position.getY());
		case DROITE:
			return map.getCase((int) position.getX() + 1, (int) position.getY());
		default:
			return null;
		}
	}

	public List<Case> getCasesAdjacentes() {
		List<Case> cases = new ArrayList<>();
		for (Direction direction : Direction.values()) {
			Case c = bouger(direction);
			if (c != null) {
				cases.add(c);
			}
		}
		return cases;
	}

	public List<Case> deplacement(Case destination) {
		List<List<Case>> chemins = new ArrayList<>();
		List<Case> cheminDepart = new ArrayList<>();
		cheminDepart.add(this);
		chemins.add(cheminDepart);

		List<List<Case>> bonChemin = new ArrayList<>();
		boolean trouve = false;
		while (!trouve && chemins.size() != 0) {
			List<List<Case>> newChemins = new ArrayList<>();
			for (List<Case> chemin : chemins) {
				for (Case case1 : chemin.get(chemin.size() - 1).getCasesAdjacentes()) {
					if (destination == case1) {
						List<Case> newChemin = new ArrayList<>(chemin);
						newChemin.add(case1);
						bonChemin.add(newChemin);
						trouve = true;
					} else if (!case1.isMur() && !chemin.contains(case1)) {
						boolean cheminInutile = false;
						for (Case adj : case1.getCasesAdjacentes()) {
							if (adj != chemin.get(chemin.size() - 1) && chemin.contains(adj)) {
								cheminInutile = true;
								break;
							}
						}
						if (!cheminInutile) {
							for (List<Case> cheminAutre : chemins) {
								if (cheminAutre.contains(case1)) {
									cheminInutile = true;
									break;
								}
							}
						}
						if (!cheminInutile) {
							for (List<Case> cheminAutre : newChemins) {
								if (cheminAutre.get(cheminAutre.size() - 1) == case1) {
									cheminInutile = true;
									break;
								}
							}
						}
						if (!cheminInutile) {
							List<Case> newChemin = new ArrayList<>(chemin);
							newChemin.add(case1);
							newChemins.add(newChemin);
						}
					}
				}
			}
			chemins = newChemins;
		}
		if (trouve) {
			return bonChemin.get(0);
		}
		return null;
	}

	@Override
	public String toString() {
		return "Case [position=" + position + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
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
		Case other = (Case) obj;
		if (getPosition() == null) {
			if (other.getPosition() != null) {
				return false;
			}
		} else if (!getPosition().equals(other.getPosition())) {
			return false;
		}
		return true;
	}

}
