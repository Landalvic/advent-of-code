package annees.annee2015.jour09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lieu {

	private String nom;
	private Map<Lieu, Integer> distance;

	public Lieu(String nom) {
		super();
		this.nom = nom;
		distance = new HashMap<>();
	}

	public List<Chemin> parcourir(Chemin chemin, int taille) {
		chemin.getLieux().add(this);
		List<Chemin> chemins = new ArrayList<>();
		if (chemin.getLieux().size() == taille) {
			chemins.add(chemin);
			return chemins;
		}
		distance.entrySet().stream().filter(lieu -> !chemin.getLieux().contains(lieu.getKey())).forEach(lieu -> {
			Chemin newChemin = new Chemin(new ArrayList<>(chemin.getLieux()), chemin.getDistance() + lieu.getValue());
			chemins.addAll(lieu.getKey().parcourir(newChemin, taille));
		});
		return chemins;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Map<Lieu, Integer> getDistance() {
		return distance;
	}

	public void setDistance(Map<Lieu, Integer> distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Lieu [nom=" + nom + "]";
	}

}
