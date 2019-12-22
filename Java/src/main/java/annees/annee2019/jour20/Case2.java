package annees.annee2019.jour20;

import java.util.ArrayList;
import java.util.List;

public class Case2 implements Comparable<Case2> {

	private int positionX;
	private int positionY;
	private boolean mur;
	private List<Case2> casesAdjacentes;
	private Case2 nord;
	private Case2 sud;
	private Case2 est;
	private Case2 ouest;
	private Portail portail;

	public Case2(int positionX, int positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.mur = false;
		casesAdjacentes = new ArrayList<>(4);
	}

	public Portail getPortail() {
		return portail;
	}

	public void setPortail(Portail portail) {
		this.portail = portail;
	}

	public Direction getDirection(Case2 adj) {
		if (nord == adj) {
			return Direction.HAUT;
		}
		if (ouest == adj) {
			return Direction.GAUCHE;
		}
		if (est == adj) {
			return Direction.DROITE;
		}
		if (sud == adj) {
			return Direction.BAS;
		}
		return null;
	}

	public Case2 getNord() {
		return nord;
	}

	public void setNord(Case2 nord) {
		if (nord != null) {
			casesAdjacentes.add(nord);
			this.nord = nord;
			if (nord.getSud() == null) {
				nord.setSud(this);
			}
		}
	}

	public Case2 getSud() {
		return sud;
	}

	public void setSud(Case2 sud) {
		if (sud != null) {
			casesAdjacentes.add(sud);
			this.sud = sud;
			if (sud.getNord() == null) {
				sud.setNord(this);
			}
		}
	}

	public Case2 getEst() {
		return est;
	}

	public void setEst(Case2 est) {
		if (est != null) {
			casesAdjacentes.add(est);
			this.est = est;
			if (est.getOuest() == null) {
				est.setOuest(this);
			}
		}
	}

	public Case2 getOuest() {
		return ouest;
	}

	public void setOuest(Case2 ouest) {
		if (ouest != null) {
			casesAdjacentes.add(ouest);
			this.ouest = ouest;
			if (ouest.getEst() == null) {
				ouest.setEst(this);
			}
		}
	}

	public int distance(Case2 case1) {
		return Math.abs(positionX - case1.positionX) + Math.abs(positionY - case1.positionY);
	}

	public List<Case2> getCasesAdjacentes() {
		return casesAdjacentes;
	}

	public void setCasesAdjacentes(List<Case2> casesAdjacentes) {
		this.casesAdjacentes = casesAdjacentes;
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

	public boolean isMur() {
		return mur;
	}

	public void setMur(boolean mur) {
		this.mur = mur;
	}

	public List<Case2> deplacement(Case2 destination) {
		List<List<Case2>> chemins = new ArrayList<>();
		List<Case2> cheminDepart = new ArrayList<>();
		cheminDepart.add(this);
		chemins.add(cheminDepart);

		List<List<Case2>> bonChemin = new ArrayList<>();
		boolean trouve = false;
		while (!trouve && chemins.size() != 0) {
			List<List<Case2>> newChemins = new ArrayList<>();
			for (List<Case2> chemin : chemins) {
				for (Case2 case1 : chemin.get(chemin.size() - 1).getCasesAdjacentes()) {
					if (destination == case1) {
						List<Case2> newChemin = new ArrayList<>(chemin);
						newChemin.add(case1);
						bonChemin.add(newChemin);
						trouve = true;
					} else if (!case1.isMur() && !chemin.contains(case1)) {
						boolean cheminInutile = false;
						for (Case2 adj : case1.getCasesAdjacentes()) {
							if (adj != chemin.get(chemin.size() - 1) && chemin.contains(adj)) {
								cheminInutile = true;
								break;
							}
						}
						if (!cheminInutile) {
							for (List<Case2> cheminAutre : chemins) {
								if (cheminAutre.contains(case1)) {
									cheminInutile = true;
									break;
								}
							}
						}
						if (!cheminInutile) {
							for (List<Case2> cheminAutre : newChemins) {
								if (cheminAutre.get(cheminAutre.size() - 1) == case1) {
									cheminInutile = true;
									break;
								}
							}
						}
						if (!cheminInutile) {
							List<Case2> newChemin = new ArrayList<>(chemin);
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
		return "Case [positionX=" + positionX + ", positionY=" + positionY + ", mur=" + mur + "]";
	}

	@Override
	public int compareTo(Case2 o) {
		int compareY = Integer.compare(getPositionY(), o.getPositionY());
		if (compareY == 0) {
			return Integer.compare(getPositionX(), o.getPositionX());
		} else {
			return compareY;
		}
	}

}
