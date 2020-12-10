package commun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Hierarchie {

	private String id;
	private Hierarchies hierarchies;
	private Map<Hierarchie, Integer> parents;
	private Map<Hierarchie, Integer> enfants;

	public Hierarchie(Hierarchies hierarchies, String id) {
		super();
		this.hierarchies = hierarchies;
		this.id = id;
		parents = new HashMap<>();
		enfants = new HashMap<>();
		hierarchies.ajouter(this);
	}

	public Hierarchies getHierarchies() {
		return hierarchies;
	}

	public void setHierarchies(Hierarchies hierarchies) {
		this.hierarchies = hierarchies;
	}

	public List<Hierarchie> chemin(Hierarchie destination) {
		List<List<Hierarchie>> chemins = new ArrayList<>();
		chemins.add(Arrays.asList(this));
		List<Hierarchie> bonChemin = Collections.emptyList();
		while (bonChemin.isEmpty()) {
			var chemin = chemins.remove(0);
			var last = chemin.get(chemin.size() - 1);
			bonChemin = parcourir(last.getParents().keySet(), chemin, chemins, destination);
			if (!bonChemin.isEmpty()) {
				break;
			}
			bonChemin = parcourir(last.getEnfants().keySet(), chemin, chemins, destination);
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

	public Set<Hierarchie> parentsRecursif() {
		Set<Hierarchie> parentsRetour = new HashSet<>();
		parentsRetour.addAll(parents.keySet());
		for (Hierarchie hierarchie : parents.keySet()) {
			parentsRetour.addAll(hierarchie.parentsRecursif());
		}
		return parentsRetour;
	}

	public Set<Hierarchie> enfantsRecursif() {
		Set<Hierarchie> enfantsRetour = new HashSet<>();
		enfantsRetour.addAll(enfants.keySet());
		for (Hierarchie hierarchie : enfants.keySet()) {
			enfantsRetour.addAll(hierarchie.enfantsRecursif());
		}
		return enfantsRetour;
	}

	public int nombreParentsRecursif() {
		int total = parents.size();
		for (Hierarchie hierarchie : parents.keySet()) {
			total += hierarchie.nombreParentsRecursif();
		}
		return total;
	}

	public int nombreEnfantsRecursif() {
		int total = enfants.size();
		for (Hierarchie hierarchie : enfants.keySet()) {
			total += hierarchie.nombreEnfantsRecursif();
		}
		return total;
	}

	public int nombreEnfantsRecursifAvecQuantite() {
		return nombreEnfantsRecursifAvecQuantite(this, 1);
	}

	private int nombreEnfantsRecursifAvecQuantite(Hierarchie hierarchie, int multiplicateur) {
		int total = hierarchie.getEnfants().values().stream().mapToInt(i -> i).sum() * multiplicateur;
		for (var entry : hierarchie.getEnfants().entrySet()) {
			total += nombreEnfantsRecursifAvecQuantite(entry.getKey(), entry.getValue() * multiplicateur);
		}
		return total;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<Hierarchie, Integer> getParents() {
		return parents;
	}

	public void setParents(Map<Hierarchie, Integer> parents) {
		this.parents = parents;
	}

	public Map<Hierarchie, Integer> getEnfants() {
		return enfants;
	}

	public void setEnfants(Map<Hierarchie, Integer> enfants) {
		this.enfants = enfants;
	}

	public void ajouterParent(Hierarchie hierarchie) {
		ajouterParent(hierarchie, 1);
	}

	public void ajouterParent(Hierarchie hierarchie, int nbr) {
		parents.put(hierarchie, nbr);
		hierarchie.enfants.put(this, nbr);
	}

	public void ajouterEnfant(Hierarchie hierarchie) {
		ajouterEnfant(hierarchie, 1);
	}

	public void ajouterEnfant(Hierarchie hierarchie, int nbr) {
		enfants.put(hierarchie, nbr);
		hierarchie.parents.put(this, nbr);
	}

	@Override
	public String toString() {
		return "Hierarchie [id=" + id + ", parents=" + parents.size() + ", enfants=" + enfants.size() + "]";
	}

}
