package annees.annee2019.jour20;

import java.util.ArrayList;
import java.util.List;

public class Chemin {

	private Case depart;
	private int deplacement;
	private int profondeur;
	private List<Etape> parcours = new ArrayList<Etape>();

	public Chemin(Case depart, int deplacement) {
		super();
		this.depart = depart;
		this.deplacement = deplacement;
		profondeur = 0;
	}

	public boolean verifierChemin(Case prochaine) {
		for (Etape etape : parcours) {
			if (etape.getEtape() == prochaine && profondeur == etape.getProfondeur()) {
				return false;
			}
		}
		return true;
	}

	public int getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}

	public List<Etape> getParcours() {
		return parcours;
	}

	public void setParcours(List<Etape> parcours) {
		this.parcours = parcours;
	}

	public Case getDepart() {
		return depart;
	}

	public void setDepart(Case depart) {
		this.depart = depart;
	}

	public int getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(int deplacement) {
		this.deplacement = deplacement;
	}

	@Override
	public String toString() {
		return "Chemin [depart=" + depart + ", deplacement=" + deplacement + ", profondeur=" + profondeur
				+ ", parcours=" + parcours + "]";
	}

}
