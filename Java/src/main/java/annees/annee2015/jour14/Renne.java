package annees.annee2015.jour14;

public class Renne {

	private String nom;
	private int vitesse;
	private int endurance;
	private int enduranceTemp;
	private int repos;
	private int reposTemp;
	private int distance;
	private int points;

	public Renne(String nom, int vitesse, int endurance, int repos) {
		super();
		this.nom = nom;
		this.vitesse = vitesse;
		this.endurance = endurance;
		enduranceTemp = endurance;
		this.repos = repos;
		reposTemp = 0;
		distance = 0;
	}

	public void courir1s() {
		if (enduranceTemp > 0) {
			distance += vitesse;
			enduranceTemp--;
		} else if (reposTemp < repos) {
			reposTemp++;
		} else {
			enduranceTemp = endurance;
			reposTemp = 0;
			courir1s();
		}
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getRepos() {
		return repos;
	}

	public void setRepos(int repos) {
		this.repos = repos;
	}

}
