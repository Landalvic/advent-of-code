package annees.annee2019.jour22;

public class Increment implements Operation {

	private int increment;

	public Increment(int increment) {
		super();
		this.increment = increment;
	}

	public int getIncrement() {
		return increment;
	}

	public void setIncrement(int increment) {
		this.increment = increment;
	}

	@Override
	public int calcul(int taille, int monNombre) {
		int inverseRestant = increment - (taille % increment);
		int fois = 0;
		for (int i = 0; i < increment; i++) {
			if ((inverseRestant * i) % increment == 1) {
				fois = i;
				break;
			}
		}
		int unitaire = (taille * fois / increment + 1);
		int total = (monNombre * unitaire) % taille;
		return total;
	}

}
