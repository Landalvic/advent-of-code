package annees.annee2018.jour24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Groupe {

	private boolean systemeImmunitaire;
	private int nbrUnites;
	private int nbrUnitesDepart;
	private int pv;
	private int attaque;
	private TypeAttaque typeAttaque;
	private int initiative;
	private List<TypeAttaque> immunites;
	private List<TypeAttaque> faiblesses;

	private Groupe cible;
	private Groupe estCible;

	public Groupe(boolean systemeImmunitaire, int nbrUnites, int pv, int attaque, TypeAttaque typeAttaque,
			int initiative, List<TypeAttaque> immunites, List<TypeAttaque> faiblesses) {
		super();
		this.systemeImmunitaire = systemeImmunitaire;
		this.nbrUnites = nbrUnites;
		this.nbrUnitesDepart = nbrUnites;
		this.pv = pv;
		this.attaque = attaque;
		this.typeAttaque = typeAttaque;
		this.initiative = initiative;
		this.immunites = immunites;
		this.faiblesses = faiblesses;
	}

	public void initialiserCombat() {
		nbrUnites = nbrUnitesDepart;
	}

	public void initialiserTour() {
		cible = null;
		estCible = null;
	}

	public void attaquer() {
		if (cible != null) {
			int degats = attaque * nbrUnites;
			if (cible.getFaiblesses().contains(typeAttaque)) {
				degats *= 2;
			}
			int nbrMorts = degats / cible.getPv();
			cible.setNbrUnites(Math.max(cible.getNbrUnites() - nbrMorts, 0));
		}
	}

	public void meilleureCible(List<Groupe> groupes) {
		List<Groupe> meilleuresCible = new ArrayList<>();
		for (Groupe groupe : groupes) {
			if (groupe.isSystemeImmunitaire() != isSystemeImmunitaire() && groupe.getNbrUnites() > 0
					&& groupe.getEstCible() == null && groupe.faiblesses.contains(typeAttaque)) {
				meilleuresCible.add(groupe);
			}
		}
		if (meilleuresCible.size() == 0) {
			for (Groupe groupe : groupes) {
				if (groupe.isSystemeImmunitaire() != isSystemeImmunitaire() && groupe.getNbrUnites() > 0
						&& groupe.getEstCible() == null && !groupe.immunites.contains(typeAttaque)) {
					meilleuresCible.add(groupe);
				}
			}
		}
		if (meilleuresCible.size() > 0) {
			Collections.sort(meilleuresCible, new Comparator<Groupe>() {
				@Override
				public int compare(Groupe o1, Groupe o2) {
					int compare = -Integer.compare(o1.puissanceEffective(), o2.puissanceEffective());
					if (compare == 0) {
						return -Integer.compare(o1.getInitiative(), o2.getInitiative());
					}
					return compare;
				}
			});
			cible = meilleuresCible.get(0);
			cible.setEstCible(this);
		}
	}

	public Groupe getEstCible() {
		return estCible;
	}

	public void setEstCible(Groupe estCible) {
		this.estCible = estCible;
	}

	public int puissanceEffective() {
		return nbrUnites * attaque;
	}

	public Groupe getCible() {
		return cible;
	}

	public void setCible(Groupe cible) {
		this.cible = cible;
	}

	public boolean isSystemeImmunitaire() {
		return systemeImmunitaire;
	}

	public void setSystemeImmunitaire(boolean systemeImmunitaire) {
		this.systemeImmunitaire = systemeImmunitaire;
	}

	public int getNbrUnites() {
		return nbrUnites;
	}

	public void setNbrUnites(int nbrUnites) {
		this.nbrUnites = nbrUnites;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public TypeAttaque getTypeAttaque() {
		return typeAttaque;
	}

	public void setTypeAttaque(TypeAttaque typeAttaque) {
		this.typeAttaque = typeAttaque;
	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public List<TypeAttaque> getImmunites() {
		return immunites;
	}

	public void setImmunites(List<TypeAttaque> immunites) {
		this.immunites = immunites;
	}

	public List<TypeAttaque> getFaiblesses() {
		return faiblesses;
	}

	public void setFaiblesses(List<TypeAttaque> faiblesses) {
		this.faiblesses = faiblesses;
	}

}
