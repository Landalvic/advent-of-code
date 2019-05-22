package annees.annee2015.jour13;

import java.util.List;

public class Formation {

	private List<Personne> personnes;
	private int bonheur;

	public Formation(List<Personne> personnes, int bonheur) {
		super();
		this.personnes = personnes;
		this.bonheur = bonheur;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	public int getBonheur() {
		return bonheur;
	}

	public void setBonheur(int bonheur) {
		this.bonheur = bonheur;
	}

}
