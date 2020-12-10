package annees.annee2020.jour08;

import java.util.List;

public class Taches {

	private Donnees donnees;
	private List<Tache> listeTaches;

	public Taches(List<Tache> listeTaches) {
		super();
		this.listeTaches = listeTaches;
		donnees = new Donnees();
	}

	public Tache getIndex() {
		return listeTaches.get(donnees.getIndex());
	}

	public List<Tache> getListeTaches() {
		return listeTaches;
	}

	public void setListeTaches(List<Tache> listeTaches) {
		this.listeTaches = listeTaches;
	}

	public Donnees getDonnees() {
		return donnees;
	}

	public void setDonnees(Donnees donnees) {
		this.donnees = donnees;
	}

}
