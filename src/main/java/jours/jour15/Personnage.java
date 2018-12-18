package jours.jour15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Personnage implements Comparable<Personnage> {

	private int pv;
	private int degats;
	private Case emplacement;

	public Personnage(Case emplacement, int degats) {
		super();
		this.pv = 200;
		this.emplacement = emplacement;
		this.degats = degats;
		emplacement.setPersonnage(this);
	}

	public void jouer(List<Personnage> personnages) {
		boolean attaquer = attaquer();

		if (!attaquer) {
			List<Case> cibles = new ArrayList<>();
			personnages
					.stream()
					.filter(personnage -> isEnnemi(personnage))
					.forEach(personnage -> cibles.addAll(personnage
							.getEmplacement()
							.getCasesAdjacentes()
							.stream()
							.filter(item -> !item.isMur() && item.getPersonnage() == null)
							.collect(Collectors.toList())));

			List<List<Case>> chemins = new ArrayList<>();
			List<Case> cheminDepart = new ArrayList<>();
			cheminDepart.add(emplacement);
			chemins.add(cheminDepart);

			List<List<Case>> bonChemin = new ArrayList<>();
			boolean trouve = false;
			while (!trouve && chemins.size() != 0) {
				List<List<Case>> newChemins = new ArrayList<>();
				for (List<Case> chemin : chemins) {
					for (Case case1 : chemin.get(chemin.size() - 1).getCasesAdjacentes()) {
						if (cibles.contains(case1)) {
							List<Case> newChemin = new ArrayList<>(chemin);
							newChemin.add(case1);
							bonChemin.add(newChemin);
							trouve = true;
						} else if (!case1.isMur() && case1.getPersonnage() == null && !chemin.contains(case1)) {
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
				for (int i = 0; i < bonChemin.size() - 1; i++) {
					int compare = bonChemin.get(i).get(bonChemin.get(0).size() - 1).compareTo(
							bonChemin.get(i + 1).get(bonChemin.get(0).size() - 1));
					if (compare == 1) {
						bonChemin.remove(i);
					} else {
						bonChemin.remove(i + 1);
					}
					i--;
				}
				seDeplacer(bonChemin.get(0).get(1));
				attaquer();
			}
		}
	}

	public boolean attaquer() {
		if (pv > 0) {
			Personnage ennemiLePlusBas = null;
			for (Case case1 : emplacement.getCasesAdjacentes()) {
				if (isEnnemi(case1.getPersonnage())
						&& (ennemiLePlusBas == null || ennemiLePlusBas.getPv() > case1.getPersonnage().getPv())) {
					ennemiLePlusBas = case1.getPersonnage();
				}
			}
			if (ennemiLePlusBas != null) {
				ennemiLePlusBas.setPv(ennemiLePlusBas.getPv() - degats);
				return true;
			}
		}
		return false;
	}

	public void seDeplacer(Case case1) {
		emplacement.setPersonnage(null);
		case1.setPersonnage(this);
		emplacement = case1;
	}

	public abstract boolean isEnnemi(Personnage personnage);

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}

	public Case getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(Case emplacement) {
		this.emplacement = emplacement;
	}

	@Override
	public int compareTo(Personnage o) {
		return emplacement.compareTo(o.emplacement);
	}

}
