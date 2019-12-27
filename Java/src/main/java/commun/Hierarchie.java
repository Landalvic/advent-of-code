package commun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hierarchie {

	private Set<Hierarchie> parents;
	private Set<Hierarchie> enfants;

	public Hierarchie() {
		super();
		parents = new HashSet<>();
		enfants = new HashSet<>();
	}

	public List<Hierarchie> chemin(Hierarchie destination) {
		List<List<Hierarchie>> chemins = new ArrayList<>();
		chemins.add(Arrays.asList(this));
		List<Hierarchie> bonChemin = Collections.emptyList();
		while (bonChemin.isEmpty()) {
			var chemin = chemins.remove(0);
			var last = chemin.get(chemin.size() - 1);
			bonChemin = parcourir(last.getParents(), chemin, chemins, destination);
			if (!bonChemin.isEmpty()) {
				break;
			}
			bonChemin = parcourir(last.getEnfants(), chemin, chemins, destination);
		}
		return bonChemin;
	}

	private List<Hierarchie> parcourir(Set<Hierarchie> sousListe, List<Hierarchie> chemin,
			List<List<Hierarchie>> chemins, Hierarchie destination) {
		for (Hierarchie o : sousListe) {
			if (!chemin.contains(o)) {
				List<Hierarchie> newChemin = new ArrayList<>(chemin);
				newChemin.add(o);
				chemins.add(newChemin);
				if (o == destination) {
					return newChemin;
				}
			}
		}
		return Collections.emptyList();
	}

	public int nombreParentsRecursif() {
		int total = parents.size();
		for (Hierarchie hierarchie : parents) {
			total += hierarchie.nombreParentsRecursif();
		}
		return total;
	}

	public int nombreEnfantsRecursif() {
		int total = enfants.size();
		for (Hierarchie hierarchie : enfants) {
			total += hierarchie.nombreEnfantsRecursif();
		}
		return total;
	}

	public Set<Hierarchie> getParents() {
		return parents;
	}

	public void setParents(Set<Hierarchie> parents) {
		this.parents = parents;
	}

	public Set<Hierarchie> getEnfants() {
		return enfants;
	}

	public void setEnfants(Set<Hierarchie> enfants) {
		this.enfants = enfants;
	}

	public void ajouterParent(Hierarchie hierarchie) {
		parents.add(hierarchie);
		hierarchie.enfants.add(this);
	}

	public void ajouterEnfant(Hierarchie hierarchie) {
		enfants.add(hierarchie);
		hierarchie.parents.add(this);
	}

}
