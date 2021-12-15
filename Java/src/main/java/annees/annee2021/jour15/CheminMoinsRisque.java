package annees.annee2021.jour15;

public class CheminMoinsRisque {

	private int numero;
	private boolean dejaTravaille;
	private Long longueur;

	public CheminMoinsRisque(int numero) {
		super();
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isDejaTravaille() {
		return dejaTravaille;
	}

	public void setDejaTravaille(boolean dejaTravaille) {
		this.dejaTravaille = dejaTravaille;
	}

	public Long getLongueur() {
		return longueur;
	}

	public void setLongueur(Long longueur) {
		this.longueur = longueur;
	}

}
