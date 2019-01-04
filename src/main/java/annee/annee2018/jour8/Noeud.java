package annee.annee2018.jour8;

import java.util.ArrayList;
import java.util.List;

public class Noeud {

	private int nbrEnfants;
	private int nbrMetadonnees;
	private List<Noeud> enfants;
	private List<Integer> metadonnees;

	public Noeud(int nbrEnfants, int nbrMetadonnees) {
		super();
		this.nbrEnfants = nbrEnfants;
		this.nbrMetadonnees = nbrMetadonnees;
		enfants = new ArrayList<>();
		metadonnees = new ArrayList<>();
	}

	public int calculValeur() {
		int total = 0;
		if (enfants.size() == 0) {
			for (Integer i : metadonnees) {
				total += i;
			}
		} else {
			for (Integer i : metadonnees) {
				if (enfants.size() > i - 1) {
					total += enfants.get(i - 1).calculValeur();
				}
			}
		}
		return total;
	}

	public int getNbrEnfants() {
		return nbrEnfants;
	}

	public void setNbrEnfants(int nbrEnfants) {
		this.nbrEnfants = nbrEnfants;
	}

	public int getNbrMetadonnees() {
		return nbrMetadonnees;
	}

	public void setNbrMetadonnees(int nbrMetadonnees) {
		this.nbrMetadonnees = nbrMetadonnees;
	}

	public List<Noeud> getEnfants() {
		return enfants;
	}

	public void setEnfants(List<Noeud> enfants) {
		this.enfants = enfants;
	}

	public List<Integer> getMetadonnees() {
		return metadonnees;
	}

	public void setMetadonnees(List<Integer> metadonnees) {
		this.metadonnees = metadonnees;
	}

}
