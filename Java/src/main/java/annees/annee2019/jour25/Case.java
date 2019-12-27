package annees.annee2019.jour25;

import java.util.ArrayList;
import java.util.List;

public class Case implements Comparable<Case> {

	private int positionX;
	private int positionY;
	private boolean mur;
	private boolean verifie;
	private List<Case> casesAdjacentes;
	private Case nord;
	private Case sud;
	private Case est;
	private Case ouest;
	private String objet = null;

	public Case(int positionX, int positionY, boolean mur) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.mur = mur;
		verifie = false;
		casesAdjacentes = new ArrayList<>(4);
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public boolean isVerifie() {
		return verifie;
	}

	public void setVerifie(boolean verifie) {
		this.verifie = verifie;
	}

	public Direction getDirection(Case adj) {
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

	public Case getNord() {
		return nord;
	}

	public void setNord(Case nord) {
		if (nord != null) {
			casesAdjacentes.add(nord);
			this.nord = nord;
			if (nord.getSud() == null) {
				nord.setSud(this);
			}
		}
	}

	public Case getSud() {
		return sud;
	}

	public void setSud(Case sud) {
		if (sud != null) {
			casesAdjacentes.add(sud);
			this.sud = sud;
			if (sud.getNord() == null) {
				sud.setNord(this);
			}
		}
	}

	public Case getEst() {
		return est;
	}

	public void setEst(Case est) {
		if (est != null) {
			casesAdjacentes.add(est);
			this.est = est;
			if (est.getOuest() == null) {
				est.setOuest(this);
			}
		}
	}

	public Case getOuest() {
		return ouest;
	}

	public void setOuest(Case ouest) {
		if (ouest != null) {
			casesAdjacentes.add(ouest);
			this.ouest = ouest;
			if (ouest.getEst() == null) {
				ouest.setEst(this);
			}
		}
	}

	public int distance(Case case1) {
		return Math.abs(positionX - case1.positionX) + Math.abs(positionY - case1.positionY);
	}

	public List<Case> getCasesAdjacentes() {
		return casesAdjacentes;
	}

	public void setCasesAdjacentes(List<Case> casesAdjacentes) {
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
		return "Case [positionX=" + positionX + ", positionY=" + positionY + ", mur=" + mur + "]";
	}

	@Override
	public int compareTo(Case o) {
		int compareY = Integer.compare(getPositionY(), o.getPositionY());
		if (compareY == 0) {
			return Integer.compare(getPositionX(), o.getPositionX());
		} else {
			return compareY;
		}
	}

}
