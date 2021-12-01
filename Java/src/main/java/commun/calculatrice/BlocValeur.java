package commun.calculatrice;

public class BlocValeur implements Bloc {

	private String valeur;

	public BlocValeur(String valeur) {
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
