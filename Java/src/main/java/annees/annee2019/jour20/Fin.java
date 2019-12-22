package annees.annee2019.jour20;

public class Fin {

	private Chemin chemin;

	public Chemin getChemin() {
		return chemin;
	}

	public void setChemin(Chemin chemin) {
		if (this.chemin == null || this.chemin.getDeplacement() > chemin.getDeplacement()) {
			this.chemin = chemin;
		}
	}

}
