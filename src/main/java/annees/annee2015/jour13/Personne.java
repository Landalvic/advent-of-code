package annees.annee2015.jour13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personne {

	private String nom;
	private Map<Personne, Integer> amities;

	public Personne(String nom) {
		super();
		this.nom = nom;
		this.amities = new HashMap<>();
	}

	public List<Formation> placer(Formation formation, int taille) {
		formation.getPersonnes().add(this);
		List<Formation> formations = new ArrayList<>();
		if (formation.getPersonnes().size() == taille) {
			formation.setBonheur(formation.getBonheur() + amities.get(formation.getPersonnes().get(0))
					+ formation.getPersonnes().get(0).getAmities().get(this));
			formations.add(formation);
			return formations;
		}
		amities.entrySet().stream().filter(amitie -> !formation.getPersonnes().contains(amitie.getKey())).forEach(
				amitie -> {
					Formation newFormation = new Formation(new ArrayList<>(formation.getPersonnes()),
							formation.getBonheur() + amitie.getValue() + amitie.getKey().getAmities().get(this));
					formations.addAll(amitie.getKey().placer(newFormation, taille));
				});
		return formations;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Map<Personne, Integer> getAmities() {
		return amities;
	}

	public void setAmities(Map<Personne, Integer> amities) {
		this.amities = amities;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + "]";
	}

}
