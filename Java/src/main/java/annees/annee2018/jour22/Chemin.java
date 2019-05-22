package annees.annee2018.jour22;

import java.util.ArrayList;
import java.util.List;

public class Chemin {

	private List<Region> chemin;
	private Equipement equipement;
	private int attenteChangementEquipement;
	private int nbrMinutes;
	private Region regionAttente;

	public Chemin(Chemin chemin, Equipement equipement) {
		super();
		this.chemin = new ArrayList<>(chemin.chemin);
		this.equipement = equipement;
		this.nbrMinutes = chemin.nbrMinutes;
	}

	public Chemin(Chemin chemin) {
		super();
		this.chemin = new ArrayList<>(chemin.chemin);
		this.equipement = chemin.equipement;
		this.nbrMinutes = chemin.nbrMinutes;
	}

	public Chemin(List<Region> chemin, Equipement equipement, int nbrMinutes) {
		super();
		this.chemin = new ArrayList<>(chemin);
		this.equipement = equipement;
		this.nbrMinutes = nbrMinutes;
	}

	public int distance(Region cible) {
		return Math.abs(cible.getPositionX() - chemin.get(chemin.size() - 1).getPositionX())
				+ Math.abs(cible.getPositionY() - chemin.get(chemin.size() - 1).getPositionY());
	}

	public Region getRegionAttente() {
		return regionAttente;
	}

	public void setRegionAttente(Region regionAttente) {
		this.regionAttente = regionAttente;
	}

	public int getNbrMinutes() {
		return nbrMinutes;
	}

	public void setNbrMinutes(int nbrMinutes) {
		this.nbrMinutes = nbrMinutes;
	}

	public List<Region> getChemin() {
		return chemin;
	}

	public void setChemin(List<Region> chemin) {
		this.chemin = chemin;
	}

	public Equipement getEquipement() {
		return equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

	public int getAttenteChangementEquipement() {
		return attenteChangementEquipement;
	}

	public void setAttenteChangementEquipement(int attenteChangementEquipement) {
		this.attenteChangementEquipement = attenteChangementEquipement;
	}

}
