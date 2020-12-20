package commun.calculatrice;

public class Valeur implements Bloc {

	private String valeur;

	public Valeur(String valeur) {
		super();
		this.valeur = valeur;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	@Override
	public double valeur() {
		return Double.parseDouble(valeur);
	}

	@Override
	public String toString() {
		return "Valeur [valeur=" + valeur + "]";
	}

}
