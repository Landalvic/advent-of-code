package annees.annee2021.jour04;

public class NumeroBingo {

	private int numero;
	private boolean gagnant;

	public NumeroBingo(int numero) {
		super();
		this.numero = numero;
		gagnant = false;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isGagnant() {
		return gagnant;
	}

	public void setGagnant(boolean gagnant) {
		this.gagnant = gagnant;
	}

	@Override
	public String toString() {
		return "NumeroBingo [numero=" + numero + ", gagnant=" + gagnant + "]";
	}

}
