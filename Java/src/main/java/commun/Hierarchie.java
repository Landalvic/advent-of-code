package commun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;

public class Hierarchie<T extends Infos> {

	private T infos;
	private Hierarchies<T> hierarchies;
	private Map<Hierarchie<T>, Integer> parents;
	private Map<Hierarchie<T>, Integer> enfants;

	public Hierarchie(Hierarchies<T> hierarchies, T infos) {
		super();
		this.hierarchies = hierarchies;
		this.infos = infos;
		parents = new HashMap<>();
		enfants = new HashMap<>();
		hierarchies.ajouter(this);
	}

	public Set<Hierarchie<T>> parentsEtEnfants() {
		Set<Hierarchie<T>> set = new HashSet<>();
		set.addAll(parents.keySet());
		set.addAll(enfants.keySet());
		return set;
	}

	public Hierarchies<T> getHierarchies() {
		return hierarchies;
	}

	public void setHierarchies(Hierarchies<T> hierarchies) {
		this.hierarchies = hierarchies;
	}

	public <U extends Infos> List<Chemin<Hierarchie<T>, U>> listeChemins(Hierarchie<T> destination) {
		return listeChemins(destination, (chemin, hierarchie) -> chemin.contains(hierarchie));
	}

	public <U extends Infos> List<Chemin<Hierarchie<T>, U>> listeChemins(Hierarchie<T> destination, BiPredicate<Chemin<Hierarchie<T>, U>, Hierarchie<T>> function) {
		return listeChemins(destination, function, chemin -> null);
	}

	public <U extends Infos> List<Chemin<Hierarchie<T>, U>> listeChemins(Hierarchie<T> destination, BiPredicate<Chemin<Hierarchie<T>, U>, Hierarchie<T>> function,
			UnaryOperator<U> instanceChemin) {
		List<Chemin<Hierarchie<T>, U>> chemins = new ArrayList<>();
		List<Chemin<Hierarchie<T>, U>> cheminsFinis = new ArrayList<>();
		Chemin<Hierarchie<T>, U> first = new Chemin<>();
		first.setInfos(instanceChemin.apply(null));
		first.add(this);
		chemins.add(first);
		while (!chemins.isEmpty()) {
			List<Chemin<Hierarchie<T>, U>> newChemins = new ArrayList<>();
			for (var chemin : chemins) {
				var voisins = chemin.get(chemin.size() - 1).parentsEtEnfants();
				for (var v : voisins) {
					Chemin<Hierarchie<T>, U> newChemin = new Chemin<>(chemin);
					newChemin.setInfos(instanceChemin.apply(chemin.getInfos()));
					if (function.test(newChemin, v)) {
						newChemin.add(v);
						var listeAjout = v == destination ? cheminsFinis : newChemins;
						listeAjout.add(newChemin);
					}
				}
			}
			chemins = newChemins;
		}
		return cheminsFinis;
	}

	public List<Hierarchie<T>> chemin(Hierarchie<T> destination) {
		List<List<Hierarchie<T>>> chemins = new ArrayList<>();
		chemins.add(Arrays.asList(this));
		List<Hierarchie<T>> bonChemin = Collections.emptyList();
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

	private List<Hierarchie<T>> parcourir(Set<Hierarchie<T>> sousListe, List<Hierarchie<T>> chemin,
			List<List<Hierarchie<T>>> chemins, Hierarchie<T> destination) {
		for (Hierarchie<T> o : sousListe) {
			if (!chemin.contains(o)) {
				List<Hierarchie<T>> newChemin = new ArrayList<>(chemin);
				newChemin.add(o);
				chemins.add(newChemin);
				if (o == destination) {
					return newChemin;
				}
			}
		}
		return Collections.emptyList();
	}

	public Set<Hierarchie<T>> parentsRecursif() {
		Set<Hierarchie<T>> parentsRetour = new HashSet<>();
		parentsRetour.addAll(parents.keySet());
		for (Hierarchie<T> hierarchie : parents.keySet()) {
			parentsRetour.addAll(hierarchie.parentsRecursif());
		}
		return parentsRetour;
	}

	public Set<Hierarchie<T>> enfantsRecursif() {
		Set<Hierarchie<T>> enfantsRetour = new HashSet<>();
		enfantsRetour.addAll(enfants.keySet());
		for (Hierarchie<T> hierarchie : enfants.keySet()) {
			enfantsRetour.addAll(hierarchie.enfantsRecursif());
		}
		return enfantsRetour;
	}

	public int nombreParentsRecursif() {
		int total = parents.size();
		for (Hierarchie<T> hierarchie : parents.keySet()) {
			total += hierarchie.nombreParentsRecursif();
		}
		return total;
	}

	public int nombreEnfantsRecursif() {
		int total = enfants.size();
		for (Hierarchie<T> hierarchie : enfants.keySet()) {
			total += hierarchie.nombreEnfantsRecursif();
		}
		return total;
	}

	public int nombreEnfantsRecursifAvecQuantite() {
		return nombreEnfantsRecursifAvecQuantite(this, 1);
	}

	private int nombreEnfantsRecursifAvecQuantite(Hierarchie<T> hierarchie, int multiplicateur) {
		int total = hierarchie.getEnfants().values().stream().mapToInt(i -> i).sum() * multiplicateur;
		for (var entry : hierarchie.getEnfants().entrySet()) {
			total += nombreEnfantsRecursifAvecQuantite(entry.getKey(), entry.getValue() * multiplicateur);
		}
		return total;
	}

	public T getInfos() {
		return infos;
	}

	public void setInfos(T infos) {
		this.infos = infos;
	}

	public Map<Hierarchie<T>, Integer> getParents() {
		return parents;
	}

	public void setParents(Map<Hierarchie<T>, Integer> parents) {
		this.parents = parents;
	}

	public Map<Hierarchie<T>, Integer> getEnfants() {
		return enfants;
	}

	public void setEnfants(Map<Hierarchie<T>, Integer> enfants) {
		this.enfants = enfants;
	}

	public void ajouterParent(Hierarchie<T> hierarchie) {
		ajouterParent(hierarchie, 1);
	}

	public void ajouterParent(Hierarchie<T> hierarchie, int nbr) {
		parents.put(hierarchie, nbr);
		hierarchie.enfants.put(this, nbr);
	}

	public void ajouterEnfant(Hierarchie<T> hierarchie) {
		ajouterEnfant(hierarchie, 1);
	}

	public void ajouterEnfant(Hierarchie<T> hierarchie, int nbr) {
		enfants.put(hierarchie, nbr);
		hierarchie.parents.put(this, nbr);
	}

	@Override
	public String toString() {
		return "Hierarchie [infos=" + infos + ", parents=" + parents.size() + ", enfants=" + enfants.size() + "]";
	}

}
